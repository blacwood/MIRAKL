package com.bigname.marketplace.mirakl.client.request;

import com.bigname.core.restful.client.request.AbstractApiRequest;
import com.bigname.core.restful.client.request.ApiEndpoint;

/**
 * Created by Manu on 2/2/2017.
 */
public class GetHierarchyRequest extends AbstractApiRequest {
    @Override
    public ApiEndpoint getEndpoint() {
        return MiraklEndpoint.H11;
    }
}
