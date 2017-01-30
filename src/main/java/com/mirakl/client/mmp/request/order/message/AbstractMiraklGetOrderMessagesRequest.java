/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.request.order.message;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.request.common.message.AbstractGetMessagesRequest;

import java.util.Map;

@Unicity(includeAll = true)
public abstract class AbstractMiraklGetOrderMessagesRequest extends AbstractGetMessagesRequest {

    private String orderId;

    public AbstractMiraklGetOrderMessagesRequest(String orderId) {
        setOrderId(orderId);
    }

    @Override
    public Map<String, String> getQueryParams() {
        Map<String, String> params = super.getQueryParams();

        if (orderId != null) {
            params.put("order_id", orderId);
        }

        return params;
    }

    public String getOrderId() {
        return orderId;
    }

    /**
     * Filter by Order ID
     */
    public void setOrderId(String orderId) {
        checkRequiredArgument(orderId, "orderId");
        this.orderId = orderId;
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

        AbstractMiraklGetOrderMessagesRequest that = (AbstractMiraklGetOrderMessagesRequest) o;

        return orderId != null ? orderId.equals(that.orderId) : that.orderId == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
        return result;
    }
}
