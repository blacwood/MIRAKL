/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.operator.request.payment.invoice;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.request.payment.invoice.AbstractMiraklGetInvoicesRequest;

import java.util.Map;

@Unicity(includeAll = true)
public class MiraklGetInvoicesRequest extends AbstractMiraklGetInvoicesRequest {

    private String shopId;

    public String getShop() {
        return shopId;
    }

    /**
     * Shop ID
     */
    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    @Override
    public Map<String, String> getQueryParams() {

        Map<String, String> params = super.getQueryParams();

        if (shopId != null) {
            params.put("shop", shopId);

        }

        return params;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklGetInvoicesRequest that = (MiraklGetInvoicesRequest) o;

        return shopId != null ? shopId.equals(that.shopId) : that.shopId == null;

    }

    @Override
    public int hashCode() {
        return shopId != null ? shopId.hashCode() : 0;
    }
}
