/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.request.offer;


import com.mirakl.client.core.internal.MiraklApiEndpoint;
import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.core.internal.util.MiraklApiUtils;
import com.mirakl.client.mmp.core.internal.MiraklFrontOperatorApiEndpoint;

import java.util.Collection;
import java.util.Map;

@Unicity(includeAll = true)
public class MiraklGetOffersRequest extends AbstractMiraklGetOffersRequest {

    private String shopId;
    private Collection<String> productSkus;
    private boolean allOffers;


    public MiraklGetOffersRequest(String shopId) {
        setShopId(shopId);
    }

    @Override
    public Map<String, String> getRequestTemplates() {
        Map<String, String> templates = super.getRequestTemplates();
        templates.put("shop", shopId);
        return templates;
    }

    @Override
    public Map<String, String> getQueryParams() {
        Map<String, String> params = super.getQueryParams();

        if (productSkus != null) {
            params.put("product_skus", MiraklApiUtils.convertCollectionToStringParam(productSkus));
        }

        if (allOffers) {
            params.put("all_offers", Boolean.TRUE.toString());
        }

        return params;
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

    public Collection<String> getProductSkus() {
        return productSkus;
    }

    /**
     * List of product SKUs
     */
    public void setProductSkus(Collection<String> productSkus) {
        this.productSkus = productSkus;
    }

    public boolean isAllOffers() {
        return allOffers;
    }

    /**
     * Boolean indicating whether or not to get all non-filtered offers
     */
    public void setAllOffers(boolean allOffers) {
        this.allOffers = allOffers;
    }

    @Override
    public MiraklApiEndpoint getEndpoint() {
        return MiraklFrontOperatorApiEndpoint.S04;
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

        MiraklGetOffersRequest that = (MiraklGetOffersRequest) o;

        return shopId != null ? shopId.equals(that.shopId) : that.shopId == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (shopId != null ? shopId.hashCode() : 0);
        return result;
    }
}
