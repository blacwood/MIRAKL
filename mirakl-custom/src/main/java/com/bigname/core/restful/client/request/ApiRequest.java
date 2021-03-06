package com.bigname.core.restful.client.request;

import java.util.Map;

/**
 * Created by Manu on 2/7/2017.
 */
public interface ApiRequest {

    ApiEndpoint getEndpoint();

    Map<String, String> getRequestTemplates();

    Map<String, String> getQueryParams();

}
