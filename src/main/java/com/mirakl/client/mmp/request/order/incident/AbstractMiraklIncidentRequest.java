/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.request.order.incident;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.request.AbstractMiraklApiRequest;

import java.util.Map;

@Unicity(includeAll = true)
public abstract class AbstractMiraklIncidentRequest extends AbstractMiraklApiRequest {

    private String orderId;
    private String orderLineId;
    private String reasonCode;

    public AbstractMiraklIncidentRequest(String orderId, String orderLineId, String reasonCode) {
        setOrderId(orderId);
        setOrderLineId(orderLineId);
        setReasonCode(reasonCode);
    }

    public String getOrderId() {
        return orderId;
    }

    /**
     * Order ID
     */
    public void setOrderId(String orderId) {
        checkRequiredArgument(orderId, "orderId");
        this.orderId = orderId;
    }

    public String getOrderLineId() {
        return orderLineId;
    }

    /**
     * Order line ID
     */
    public void setOrderLineId(String orderLineId) {
        checkRequiredArgument(orderLineId, "orderLineId");
        this.orderLineId = orderLineId;
    }

    public String getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(String reasonCode) {
        checkRequiredArgument(reasonCode, "reasonCode");
        this.reasonCode = reasonCode;
    }

    @Override
    public Map<String, String> getRequestTemplates() {
        Map<String, String> templates = super.getRequestTemplates();
        templates.put("order", orderId);
        templates.put("line", orderLineId);
        return templates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AbstractMiraklIncidentRequest that = (AbstractMiraklIncidentRequest) o;

        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) {
            return false;
        }
        if (orderLineId != null ? !orderLineId.equals(that.orderLineId) : that.orderLineId != null) {
            return false;
        }
        return reasonCode != null ? reasonCode.equals(that.reasonCode) : that.reasonCode == null;

    }

    @Override
    public int hashCode() {
        int result = orderId != null ? orderId.hashCode() : 0;
        result = 31 * result + (orderLineId != null ? orderLineId.hashCode() : 0);
        result = 31 * result + (reasonCode != null ? reasonCode.hashCode() : 0);
        return result;
    }
}
