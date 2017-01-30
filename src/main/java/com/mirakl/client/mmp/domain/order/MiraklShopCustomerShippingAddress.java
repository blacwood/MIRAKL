/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.order;

import com.mirakl.client.domain.common.Unicity;

@Unicity(includeAll = true)
public class MiraklShopCustomerShippingAddress extends MiraklCustomerBillingAddress {

    private String additionalInfo;

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    /**
     * Configure addtional information of the customer shipping address
     */
    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
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

        MiraklShopCustomerShippingAddress that = (MiraklShopCustomerShippingAddress) o;

        return additionalInfo != null ? additionalInfo.equals(that.additionalInfo) : that.additionalInfo == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (additionalInfo != null ? additionalInfo.hashCode() : 0);
        return result;
    }
}
