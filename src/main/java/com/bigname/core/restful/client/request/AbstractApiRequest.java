package com.bigname.core.restful.client.request;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Manu on 1/30/2017.
 */
abstract public class AbstractApiRequest implements ApiRequest {

    @Override
    public Map<String, String> getRequestTemplates() {
        return new HashMap<>();
    }

    @Override
    public Map<String, String> getQueryParams() {
        return new HashMap<>();
    }

    @Override
    public int hashCode() {
        return getEndpoint() != null ? getEndpoint().hashCode() : 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        ApiRequest that = (ApiRequest) obj;

        return getEndpoint() != null ? getEndpoint().equals(that.getEndpoint()) : that.getEndpoint() == null;
    }
}
