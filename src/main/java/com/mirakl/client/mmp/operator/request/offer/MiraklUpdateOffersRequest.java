/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.operator.request.offer;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.request.offer.AbstractMiraklUpdateOffersRequest;

import java.util.Map;

@Unicity(includeAll = true)
public class MiraklUpdateOffersRequest extends AbstractMiraklUpdateOffersRequest {

    private String shopId;

    public MiraklUpdateOffersRequest(String shopId) {
        setShopId(shopId);
    }

    @Override
    public Map<String, String> getQueryParams() {
        Map<String, String> templates = super.getRequestTemplates();
        templates.put("shop", shopId);
        return templates;
    }

    public String getShopId() {
        return shopId;
    }

    /**
     * Shop ID
     */
    public void setShopId(String shopId) {
        checkRequiredArgument(shopId, "shopId");
        this.shopId = shopId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklUpdateOffersRequest that = (MiraklUpdateOffersRequest) o;

        return shopId != null ? shopId.equals(that.shopId) : that.shopId == null;

    }

    @Override
    public int hashCode() {
        return shopId != null ? shopId.hashCode() : 0;
    }
}
