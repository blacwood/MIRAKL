package com.bigname.marketplace.mirakl.client;

import com.bigname.core.restful.client.AbstractApiClient;
import com.bigname.core.restful.client.security.Credential;
import com.bigname.marketplace.mirakl.client.domain.MiraklVersion;
import com.bigname.marketplace.mirakl.client.request.GetVersionRequest;

import java.io.IOException;

/**
 * Created by Manu on 2/7/2017.
 */
public class MiraklApiClient extends AbstractApiClient {

    public MiraklApiClient(String endpoint, Credential credential) {
        super(endpoint, credential);
    }

    public MiraklVersion getVersion() throws IOException {
        return get(new GetVersionRequest(), MiraklVersion.class);
    }
}
