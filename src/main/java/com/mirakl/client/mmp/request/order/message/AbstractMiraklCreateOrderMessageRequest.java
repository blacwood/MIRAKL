/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.request.order.message;

import com.mirakl.client.core.internal.MiraklApiEndpoint;
import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.core.internal.MiraklMarketplacePlatformCommonApiEndpoint;
import com.mirakl.client.request.AbstractMiraklApiRequest;

import java.util.Map;

@Unicity(includeAll = true)
public abstract class AbstractMiraklCreateOrderMessageRequest extends AbstractMiraklApiRequest {

    private String orderId;
    private MiraklCreateOrderMessage message;

    public AbstractMiraklCreateOrderMessageRequest(String orderId, MiraklCreateOrderMessage message) {
        setOrderId(orderId);
        setMessage(message);
    }

    @Override
    public MiraklApiEndpoint getEndpoint() {
        return MiraklMarketplacePlatformCommonApiEndpoint.OR42;
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

    public void setOrderId(String orderId) {
        checkRequiredArgument(orderId, "orderId");
        this.orderId = orderId;
    }

    public MiraklCreateOrderMessage getMessage() {
        return message;
    }

    /**
     * Message details
     */
    public void setMessage(MiraklCreateOrderMessage message) {
        checkRequiredArgument(message, "message");
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AbstractMiraklCreateOrderMessageRequest that = (AbstractMiraklCreateOrderMessageRequest) o;

        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) {
            return false;
        }
        return message != null ? message.equals(that.message) : that.message == null;

    }

    @Override
    public int hashCode() {
        int result = orderId != null ? orderId.hashCode() : 0;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }
}
