package com.bigname.core.restful.client.error;


import com.bigname.core.restful.client.exception.RestfulException;
import com.bigname.core.restful.client.mapper.CustomObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Manu on 1/30/2017.
 */
public class ErrorResponseParser {

    private static final Logger LOGGER = Logger.getLogger(ErrorResponseParser.class.getName());

    private static final ObjectMapper MAPPER = new CustomObjectMapper();

    public static ErrorResponse parseErrorFromResponse(Response response) {
        String responseAsString = response.readEntity(String.class);

        MediaType mediaType = response.getMediaType();

        if (MediaType.APPLICATION_JSON_TYPE.isCompatible(mediaType)) {
            return parse(responseAsString);
        } else {
            LOGGER.severe("Cannot parse error as " + ErrorResponse.class.getSimpleName() + ", media type is not JSON, body response is : " + responseAsString);

            if (!responseAsString.isEmpty()) {
                WebApplicationException e = new WebApplicationException("Response body is: " + responseAsString, response.getStatus());
                throw new RestfulException("Cannot parse error response from server", e);
            } else {
                throw new RestfulException("Cannot parse error response from server");
            }
        }

    }

    private static ErrorResponse parse(String responseAsString) {
        try {
            return MAPPER.readValue(responseAsString, ErrorResponse.class);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Cannot parse error as " + ErrorResponse.class.getSimpleName() + ", body response is : " + responseAsString, e);
            throw new RestfulException("Cannot parse error response", e);
        }
    }
}
