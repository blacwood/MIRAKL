/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.request.order.document;

import com.mirakl.client.core.internal.MiraklApiEndpoint;
import com.mirakl.client.core.internal.util.MiraklApiUtils;
import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.core.internal.MiraklMarketplacePlatformCommonApiEndpoint;
import com.mirakl.client.request.AbstractMiraklApiRequest;

import java.util.Collection;
import java.util.Map;

@Unicity(includeAll = true)
public abstract class AbstractMiraklGetOrderDocumentsRequest extends AbstractMiraklApiRequest {

    private Collection<String> orderIds;

    public AbstractMiraklGetOrderDocumentsRequest(Collection<String> orderIds) {
        setOrderIds(orderIds);
    }

    @Override
    public MiraklApiEndpoint getEndpoint() {
        return MiraklMarketplacePlatformCommonApiEndpoint.OR72;
    }

    @Override
    public Map<String, String> getQueryParams() {
        Map<String, String> params = super.getQueryParams();

        params.put("order_ids", MiraklApiUtils.convertCollectionToStringParam(orderIds));

        return params;
    }

    public Collection<String> getOrderIds() {
        return orderIds;
    }

    /**
     * The order IDs
     */
    public void setOrderIds(Collection<String> orderIds) {
        checkExpression(orderIds != null && !orderIds.isEmpty(), "orderIds must be set and not empty");
        this.orderIds = orderIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AbstractMiraklGetOrderDocumentsRequest that = (AbstractMiraklGetOrderDocumentsRequest) o;

        return orderIds != null ? orderIds.equals(that.orderIds) : that.orderIds == null;

    }

    @Override
    public int hashCode() {
        return orderIds != null ? orderIds.hashCode() : 0;
    }
}
