/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.front.domain.shipping;

import com.mirakl.client.domain.common.Unicity;

import java.util.ArrayList;
import java.util.List;

@Unicity(includeAll = true)
public class MiraklOrderShippingFeeOffer extends MiraklAbstractShippingFeeOffer {

    private List<MiraklAllowedShippingType> allowedShippingTypes = new ArrayList<MiraklAllowedShippingType>();

    /**
     * Shipping types allowed for the offer
     */
    public List<MiraklAllowedShippingType> getAllowedShippingTypes() {
        return allowedShippingTypes;
    }

    public void setAllowedShippingTypes(List<MiraklAllowedShippingType> allowedShippingTypes) {
        this.allowedShippingTypes = allowedShippingTypes;
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

        MiraklOrderShippingFeeOffer that = (MiraklOrderShippingFeeOffer) o;

        return allowedShippingTypes != null ? allowedShippingTypes.equals(that.allowedShippingTypes) : that.allowedShippingTypes == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (allowedShippingTypes != null ? allowedShippingTypes.hashCode() : 0);
        return result;
    }
}
