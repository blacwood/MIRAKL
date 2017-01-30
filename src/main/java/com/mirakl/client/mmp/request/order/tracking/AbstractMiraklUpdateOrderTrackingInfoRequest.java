/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.request.order.tracking;

import com.mirakl.client.core.internal.MiraklApiEndpoint;
import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.core.internal.MiraklMarketplacePlatformCommonApiEndpoint;
import com.mirakl.client.request.AbstractMiraklApiRequest;

import java.util.Map;

@Unicity(includeAll = true)
public abstract class AbstractMiraklUpdateOrderTrackingInfoRequest extends AbstractMiraklApiRequest {

    private String orderId;
    private MiraklOrderTrackingInfo trackingOrderInfo;

    public AbstractMiraklUpdateOrderTrackingInfoRequest(String orderId, MiraklOrderTrackingInfo trackingOrderInfo) {
        setOrderId(orderId);
        setTrackingOrderInfo(trackingOrderInfo);
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

    public MiraklOrderTrackingInfo getTrackingOrderInfo() {
        return trackingOrderInfo;
    }

    public void setTrackingOrderInfo(MiraklOrderTrackingInfo trackingOrderInfo) {
        checkRequiredArgument(trackingOrderInfo, "trackingOrderInfo");
        this.trackingOrderInfo = trackingOrderInfo;
    }

    @Override
    public MiraklApiEndpoint getEndpoint() {
        return MiraklMarketplacePlatformCommonApiEndpoint.OR23;
    }

    @Override
    public Map<String, String> getRequestTemplates() {
        Map<String, String> templates = super.getRequestTemplates();
        templates.put("order_id", orderId);
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

        AbstractMiraklUpdateOrderTrackingInfoRequest that = (AbstractMiraklUpdateOrderTrackingInfoRequest) o;

        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) {
            return false;
        }
        return trackingOrderInfo != null ? trackingOrderInfo.equals(that.trackingOrderInfo) : that.trackingOrderInfo == null;

    }

    @Override
    public int hashCode() {
        int result = orderId != null ? orderId.hashCode() : 0;
        result = 31 * result + (trackingOrderInfo != null ? trackingOrderInfo.hashCode() : 0);
        return result;
    }
}
