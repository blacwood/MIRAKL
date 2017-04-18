/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.front.request.message;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.domain.common.MiraklUserType;
import com.mirakl.client.mmp.request.common.message.AbstractGetMessagesRequest;

import java.util.Map;

import static com.mirakl.client.core.internal.util.MiraklApiUtils.addBooleanOrAllParam;

@Unicity(includeAll = true)
public abstract class AbstractFrontGetMessagesRequest extends AbstractGetMessagesRequest {

    private MiraklUserType userType;
    private String shopId;
    private Boolean received = null;

    @Override
    public Map<String, String> getQueryParams() {
        Map<String, String> params = super.getQueryParams();

        addBooleanOrAllParam(params, received, "received");

        if (shopId != null) {
            params.put("shop_id", shopId);
        }
        if (userType != null) {
            params.put("user_type", userType.name());
        }

        return params;
    }

    /**
     * If this param is set, it filters only messages concerned by one type of use
     * <ul>
     * <li>{@link com.mirakl.client.mmp.domain.common.MiraklUserType#ALL}: Returns all messages from all users (parameters "received" should not be used)</li>
     * <li>{@link com.mirakl.client.mmp.domain.common.MiraklUserType#CUSTOMER}: Returns all messages from or to a customer (parameters "received" concerns the customer)</li>
     * <li>{@link com.mirakl.client.mmp.domain.common.MiraklUserType#SHOP}: Returns all messages from or to a shop (parameters "received" concerns the shop)</li>
     * <li>{@link com.mirakl.client.mmp.domain.common.MiraklUserType#OPERATOR}: Returns all messages from or to an operator (parameters "received" concerns the operator)</li>
     * </ul>
     */
    public void setUserType(MiraklUserType userType) {
        this.userType = userType;
    }

    /**
     * Filter by Shop ID
     */
    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    /**
     * (optional) Must be called with FRONT user
     * Default value is null (all messages will be returned without filtering)
     * If set to true only messages received will be returned.
     * If set to false only messages sent will be returned.
     */
    public void setReceived(Boolean received) {
        this.received = received;
    }

    public MiraklUserType getUserType() {
        return userType;
    }

    public String getShopId() {
        return shopId;
    }

    public Boolean getReceived() {
        return received;
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

        AbstractFrontGetMessagesRequest that = (AbstractFrontGetMessagesRequest) o;

        if (userType != that.userType) {
            return false;
        }
        if (shopId != null ? !shopId.equals(that.shopId) : that.shopId != null) {
            return false;
        }
        return received != null ? received.equals(that.received) : that.received == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (userType != null ? userType.hashCode() : 0);
        result = 31 * result + (shopId != null ? shopId.hashCode() : 0);
        result = 31 * result + (received != null ? received.hashCode() : 0);
        return result;
    }
}
