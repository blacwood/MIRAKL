/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.front.domain.shipping;

import com.mirakl.client.mmp.domain.shipping.MiraklShippingTypeWithConfiguration;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import com.mirakl.client.domain.common.Unicity;

/**
 * Offer information for the shipping fees
 */
@JsonIgnoreProperties({
        "shipping_type_code", "shipping_type_label" //deprecated fields moved in selected_shipping_type
})
@Unicity(includeAll = true)
public class MiraklShippingFeeOffer extends MiraklAbstractShippingFeeOffer {

    @JsonProperty("selected_shipping_type")
    private MiraklShippingTypeWithConfiguration shippingType;

    /**
     * Shipping type selected for the shop and used to calculate the shipping price for each offers
     */
    public MiraklShippingTypeWithConfiguration getShippingType() {
        return shippingType;
    }

    public void setShippingType(MiraklShippingTypeWithConfiguration shippingType) {
        this.shippingType = shippingType;
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

        MiraklShippingFeeOffer that = (MiraklShippingFeeOffer) o;

        return shippingType != null ? shippingType.equals(that.shippingType) : that.shippingType == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (shippingType != null ? shippingType.hashCode() : 0);
        return result;
    }
}
