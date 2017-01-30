package com.bigname.core.restful.client.security;

/**
 * Created by Manu on 1/30/2017.
 */
public class Credential {
    private String apiKey;

    public Credential(String apiKey) {
        if(apiKey == null || apiKey.isEmpty()) {
            throw new IllegalArgumentException("API Key cannot be empty");
        }
        this.apiKey = apiKey;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}
