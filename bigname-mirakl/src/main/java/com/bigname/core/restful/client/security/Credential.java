package com.bigname.core.restful.client.security;

import com.bigname.core.restful.client.util.Preconditions;

/**
 * Created by Manu on 1/30/2017.
 */
public class Credential {
    private String apiKey;

    public Credential(String apiKey) {
        Preconditions.checkNotNull(apiKey, "The apiKey cannot be null");
        this.apiKey = apiKey;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}
