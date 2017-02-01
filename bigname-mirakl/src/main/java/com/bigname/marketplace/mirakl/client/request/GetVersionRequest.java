package com.bigname.marketplace.mirakl.client.request;

import com.bigname.core.restful.client.request.AbstractApiRequest;
import com.bigname.core.restful.client.request.ApiEndpoint;

/**
 * Created by Manu on 1/30/2017.
 */
public class GetVersionRequest extends AbstractApiRequest{
    @Override
    public ApiEndpoint getEndpoint() {
        return MiraklEndpoint.V01;
    }
}
