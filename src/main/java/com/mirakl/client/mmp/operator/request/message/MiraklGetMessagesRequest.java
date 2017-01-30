/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.operator.request.message;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.request.common.message.AbstractGetMessagesRequest;

import java.util.Map;

@Unicity(includeAll = true)
public class MiraklGetMessagesRequest extends AbstractGetMessagesRequest {

    private String offerId;
    private String orderId;

    @Override
    public Map<String, String> getQueryParams() {
        Map<String, String> params = super.getQueryParams();

        if (offerId != null) {
            params.put("offer_id", offerId);
        }

        if (orderId != null) {
            params.put("order_id", orderId);
        }

        return params;
    }

    public String getOfferId() {
        return offerId;
    }

    /**
     * Filter by Offer ID
     */
    public void setOfferId(String offerId) {
        this.offerId = offerId;
    }

    public String getOrderId() {
        return orderId;
    }

    /**
     * Filter by Order ID
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
        if (!super.equals(o)) {
            return false;
        }

        MiraklGetMessagesRequest that = (MiraklGetMessagesRequest) o;

        if (offerId != null ? !offerId.equals(that.offerId) : that.offerId != null) {
            return false;
        }
        return orderId != null ? orderId.equals(that.orderId) : that.orderId == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (offerId != null ? offerId.hashCode() : 0);
        result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
        return result;
    }
}
