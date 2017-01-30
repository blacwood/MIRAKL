/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.core.error;

import com.mirakl.client.core.exception.MiraklException;
import com.mirakl.client.core.internal.mapper.CustomObjectMapper;
import org.codehaus.jackson.map.ObjectMapper;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MiraklErrorResponseBeanParser {

    private static final Logger LOGGER = Logger.getLogger(MiraklErrorResponseBeanParser.class.getName());

    private static final ObjectMapper MAPPER = new CustomObjectMapper();

    public static MiraklErrorResponseBean parseErrorFromResponse(Response response) {
        String responseAsString = response.readEntity(String.class);

        MediaType mediaType = response.getMediaType();

        if (MediaType.APPLICATION_JSON_TYPE.isCompatible(mediaType)) {
            return parse(responseAsString);
        } else {
            LOGGER.severe("Cannot parse error as " + MiraklErrorResponseBean.class.getSimpleName() + ", media type is not JSON, body response is : " + responseAsString);

            if (!responseAsString.isEmpty()) {
                WebApplicationException e = new WebApplicationException("Response body is: " + responseAsString, response.getStatus());
                throw new MiraklException("Cannot parse error response from server", e);
            } else {
                throw new MiraklException("Cannot parse error response from server");
            }
        }

    }

    private static MiraklErrorResponseBean parse(String responseAsString) {
        try {
            return MAPPER.readValue(responseAsString, MiraklErrorResponseBean.class);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Cannot parse error as " + MiraklErrorResponseBean.class.getSimpleName() + ", body response is : " + responseAsString, e);
            throw new MiraklException("Cannot parse error response", e);
        }
    }
}
