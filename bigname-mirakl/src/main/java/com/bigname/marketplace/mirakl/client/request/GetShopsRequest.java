package com.bigname.marketplace.mirakl.client.request;

import com.bigname.core.restful.client.request.AbstractApiPaginationRequest;
import com.bigname.core.restful.client.request.ApiEndpoint;

/**
 * Created by Manu on 2/1/2017.
 */
public class GetShopsRequest extends AbstractApiPaginationRequest {
    @Override
    public ApiEndpoint getEndpoint() {
        return MiraklEndpoint.S20;
    }
}
