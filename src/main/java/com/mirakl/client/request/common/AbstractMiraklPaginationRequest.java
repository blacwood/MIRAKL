/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.request.common;

import com.mirakl.client.request.AbstractMiraklApiRequest;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractMiraklPaginationRequest extends AbstractMiraklApiRequest {

    private int offset;
    private int max = 10;

    /**
     * Indicate whether or not this API should return paginated results
     * Default to true
     */
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

        AbstractMiraklPaginationRequest that = (AbstractMiraklPaginationRequest) o;

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
