/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.request.offer;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.request.product.offer.AbstractMiraklGetOffersOnProductsRequest;

import java.util.Collection;
import java.util.Map;

/**
 * @deprecated Please use {@link com.mirakl.client.mmp.request.product.MiraklGetOffersOnProductsRequest},
 */
@Deprecated
@Unicity(includeAll = true)
public class MiraklGetOffersOnProductsRequest extends AbstractMiraklGetOffersOnProductsRequest {

    private Boolean premium;

    public MiraklGetOffersOnProductsRequest(Collection<String> productIds) {
        setProductIds(productIds);
    }

    @Override
    public Map<String, String> getQueryParams() {
        Map<String, String> params = super.getQueryParams();

        if (premium != null) {
            params.put("premium", String.valueOf(premium));
        }

        return params;
    }

    /**
     * Filter only offers of premium shop
     * Default value is null, no filtering is done.
     * If set to true, only offers of premium shops will be returned
     * If set to false, only offers of non-premium shops will be returned
     */
    public void setPremium(Boolean premium) {
        this.premium = premium;
    }

}
