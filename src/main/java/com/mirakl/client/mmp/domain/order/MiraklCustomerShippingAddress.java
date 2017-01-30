/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.order;

import com.mirakl.client.domain.common.Unicity;

@Unicity(includeAll = true)
public class MiraklCustomerShippingAddress extends MiraklShopCustomerShippingAddress {

    private String internalAdditionalInfo;

    public String getInternalAdditionalInfo() {
        return internalAdditionalInfo;
    }

    /**
     * Configure internal addtional information of the customer shipping address<br/>
     * This information cannot be seen by the shop
     */
    public void setInternalAdditionalInfo(String internalAdditionalInfo) {
        this.internalAdditionalInfo = internalAdditionalInfo;
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

        MiraklCustomerShippingAddress that = (MiraklCustomerShippingAddress) o;

        return internalAdditionalInfo != null ? internalAdditionalInfo.equals(that.internalAdditionalInfo) : that.internalAdditionalInfo == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (internalAdditionalInfo != null ? internalAdditionalInfo.hashCode() : 0);
        return result;
    }
}
