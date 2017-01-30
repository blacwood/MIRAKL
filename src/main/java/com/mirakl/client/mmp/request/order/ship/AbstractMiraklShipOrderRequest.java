/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.request.order.ship;

import com.mirakl.client.core.internal.MiraklApiEndpoint;
import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.core.internal.MiraklMarketplacePlatformCommonApiEndpoint;
import com.mirakl.client.request.AbstractMiraklApiRequest;

import java.util.Map;

@Unicity(includeAll = true)
public abstract class AbstractMiraklShipOrderRequest extends AbstractMiraklApiRequest {

    private String orderId;

    public AbstractMiraklShipOrderRequest(String orderId) {
        checkRequiredArgument(orderId, "orderId");
        setOrderId(orderId);
    }

    @Override
    public MiraklApiEndpoint getEndpoint() {
        return MiraklMarketplacePlatformCommonApiEndpoint.OR24;
    }

    @Override
    public Map<String, String> getRequestTemplates() {
        Map<String, String> templates = super.getRequestTemplates();
        templates.put("order", orderId);
        return templates;
    }

    public String getOrderId() {
        return orderId;
    }

    /**
     * Order ID
     */
    public void setOrderId(String orderId) {
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

        AbstractMiraklShipOrderRequest that = (AbstractMiraklShipOrderRequest) o;

        return orderId != null ? orderId.equals(that.orderId) : that.orderId == null;

    }

    @Override
    public int hashCode() {
        return orderId != null ? orderId.hashCode() : 0;
    }
}
