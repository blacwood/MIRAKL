package com.bigname.core.restful.client.request;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Manu on 2/1/2017.
 */
abstract public class AbstractApiPaginationRequest extends AbstractApiRequest {
    private int offset;
    private int max = 10;

    private boolean paginate = true;

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public boolean isPaginate() {
        return paginate;
    }

    public void setPaginate(boolean paginate) {
        this.paginate = paginate;
    }

    @Override
    public Map<String, String> getQueryParams() {

        Map<String, String> params = new HashMap<String, String>();
        params.put("paginate", String.valueOf(paginate));

        if (paginate) {
            params.put("max", String.valueOf(max));
            params.put("offset", String.valueOf(offset));
        }

        return params;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AbstractApiPaginationRequest that = (AbstractApiPaginationRequest) o;

        if (offset != that.offset) {
            return false;
        }
        if (max != that.max) {
            return false;
        }
        return paginate == that.paginate;

    }

    @Override
    public int hashCode() {
        int result = offset;
        result = 31 * result + max;
        result = 31 * result + (paginate ? 1 : 0);
        return result;
    }

}
