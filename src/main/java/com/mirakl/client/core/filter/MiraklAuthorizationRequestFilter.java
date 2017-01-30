/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.core.filter;


import com.mirakl.client.core.internal.util.Preconditions;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
public class MiraklAuthorizationRequestFilter implements ClientRequestFilter {

    @Override
    public void filter(ClientRequestContext requestContext) throws IOException {
        String apiKey = (String) requestContext.getProperty(HttpHeaders.AUTHORIZATION);
        Preconditions.checkNotNull(apiKey, "no mirakl api key found for autentication");
        requestContext.getHeaders().putSingle(HttpHeaders.AUTHORIZATION, apiKey);
    }

}
