package com.bigname.marketplace.mirakl.client.request;

import com.bigname.core.restful.client.request.ApiEndpoint;

/**
 * Created by Manu on 1/30/2017.
 */
public enum MiraklEndpoint implements ApiEndpoint{

    H11("hierarchies"),

    S20("shops"),

    V01("version");



    private final String[] paths;

    MiraklEndpoint(String... paths) {
        this.paths = paths;
    }
    @Override
    public String[] getPaths() {
        return paths;
    }
}
