package com.bigname.marketplace.mirakl.client;

import com.bigname.core.restful.client.AbstractApiClient;
import com.bigname.core.restful.client.security.Credential;
import com.bigname.marketplace.mirakl.client.domain.MiraklVersion;
import com.bigname.marketplace.mirakl.client.request.GetVersionRequest;


/**
 * Created by Manu on 1/30/2017.
 */
public class MiraklApiClient extends AbstractMiraklApiClient implements MiraklApi {

    public MiraklApiClient(String endpoint, Credential credential) {
        super(endpoint, credential);
    }

    @Override
    public MiraklVersion getVersion() {
        return get(new GetVersionRequest(), MiraklVersion.class);
    }
}
