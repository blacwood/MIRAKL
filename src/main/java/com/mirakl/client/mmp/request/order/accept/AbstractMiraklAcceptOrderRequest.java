/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.request.order.accept;

import com.mirakl.client.core.internal.MiraklApiEndpoint;
import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.core.internal.MiraklMarketplacePlatformCommonApiEndpoint;
import com.mirakl.client.request.AbstractMiraklApiRequest;

import java.util.List;
import java.util.Map;


@Unicity(includeAll = true)
public abstract class AbstractMiraklAcceptOrderRequest extends AbstractMiraklApiRequest {

    private String orderId;

    private List<MiraklAcceptOrderLine> orderLines;

    public AbstractMiraklAcceptOrderRequest(String orderId, List<MiraklAcceptOrderLine> orderLines) {
        setOrderId(orderId);
        setOrderLines(orderLines);
    }

    @Override
    public MiraklApiEndpoint getEndpoint() {
        return MiraklMarketplacePlatformCommonApiEndpoint.OR21;
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
     * The ID of the order
     */
    public void setOrderId(String orderId) {
        checkRequiredArgument(orderId, "orderId");
        this.orderId = orderId;
    }

    public List<MiraklAcceptOrderLine> getOrderLines() {
        return orderLines;
    }

    /**
     * Order line acceptance information
     */
    public void setOrderLines(List<MiraklAcceptOrderLine> orderLines) {
        checkRequiredArgument(orderLines, "orderLines");
        this.orderLines = orderLines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AbstractMiraklAcceptOrderRequest that = (AbstractMiraklAcceptOrderRequest) o;

        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) {
            return false;
        }
        return orderLines != null ? orderLines.equals(that.orderLines) : that.orderLines == null;

    }

    @Override
    public int hashCode() {
        int result = orderId != null ? orderId.hashCode() : 0;
        result = 31 * result + (orderLines != null ? orderLines.hashCode() : 0);
        return result;
    }
}
