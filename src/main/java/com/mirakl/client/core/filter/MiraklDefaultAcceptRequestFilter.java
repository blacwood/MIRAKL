/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.core.filter;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.logging.Logger;

@Provider
public class MiraklDefaultAcceptRequestFilter implements ClientRequestFilter {

    private static final Logger LOGGER = Logger.getLogger(MiraklDefaultAcceptRequestFilter.class.getName());

    @Override
    public void filter(ClientRequestContext requestContext) throws IOException {
        if (requestContext.getAcceptableMediaTypes().size() == 1) {
            MediaType mediaType = requestContext.getAcceptableMediaTypes().get(0);
            if (mediaType.equals(MediaType.WILDCARD_TYPE)) {
                LOGGER.fine("using '" + MediaType.APPLICATION_JSON + "' as acceptable media type");
                requestContext.getHeaders().putSingle(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_TYPE);
            }
        }
    }

}
