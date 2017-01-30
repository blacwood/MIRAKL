/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.request.common.sort;

import com.mirakl.client.request.common.AbstractMiraklPaginationRequest;

import java.util.Map;

public abstract class AbstractMiraklSortRequest<T extends Sort> extends AbstractMiraklPaginationRequest {

    private OrderBy<T> orderBy;

    @Override
    public Map<String, String> getQueryParams() {
        Map<String, String> params = super.getQueryParams();

        if (orderBy != null) {
            params.put("sort", orderBy.getSort().getValue());
            params.put("order", orderBy.getOrder().getValue());
        }

        return params;
    }

    public void setOrderBy(OrderBy<T> orderBy){
        this.orderBy = orderBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        AbstractMiraklSortRequest<?> that = (AbstractMiraklSortRequest<?>) o;

        return orderBy != null ? orderBy.equals(that.orderBy) : that.orderBy == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (orderBy != null ? orderBy.hashCode() : 0);
        return result;
    }
}
