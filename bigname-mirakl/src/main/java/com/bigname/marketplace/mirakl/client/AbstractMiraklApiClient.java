package com.bigname.marketplace.mirakl.client;

import com.bigname.core.restful.client.AbstractApiClient;
import com.bigname.core.restful.client.security.Credential;

import javax.ws.rs.client.ClientRequestFilter;

/**
 * Created by Manu on 1/30/2017.
 */
public class AbstractMiraklApiClient extends AbstractApiClient {

    protected AbstractMiraklApiClient(String endpoint, Credential credential) {
        super(endpoint, credential);
        init(new ClientRequestFilter[]{});
    }
}
