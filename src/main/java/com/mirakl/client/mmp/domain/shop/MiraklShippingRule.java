/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.shop;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.domain.shipping.MiraklShippingType;
import com.mirakl.client.mmp.domain.shipping.MiraklShippingZone;
import org.codehaus.jackson.annotate.JsonUnwrapped;

import java.math.BigDecimal;

/**
 * Group of a shipping type and a shippinh zone supported by a shop
 */
@Unicity(includeAll = true)
public class MiraklShippingRule {

    private BigDecimal shippingFreeAmount;

    @JsonUnwrapped
    private MiraklShippingType shippingType;

    @JsonUnwrapped
    private MiraklShippingZone shippingZone;

    /**
     * Free shipping minimum threshold
     */
    public BigDecimal getShippingFreeAmount() {
        return shippingFreeAmount;
    }

    public void setShippingFreeAmount(BigDecimal shippingFreeAmount) {
        this.shippingFreeAmount = shippingFreeAmount;
    }

    public MiraklShippingZone getShippingZone() {
        return shippingZone;
    }

    public void setShippingZone(MiraklShippingZone shippingZone) {
        this.shippingZone = shippingZone;
    }

    public MiraklShippingType getShippingType() {
        return shippingType;
    }

    public void setShippingType(MiraklShippingType shippingType) {
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

        MiraklShippingRule that = (MiraklShippingRule) o;

        if (shippingFreeAmount != null ? !shippingFreeAmount.equals(that.shippingFreeAmount) : that.shippingFreeAmount != null) {
            return false;
        }
        if (shippingType != null ? !shippingType.equals(that.shippingType) : that.shippingType != null) {
            return false;
        }
        return shippingZone != null ? shippingZone.equals(that.shippingZone) : that.shippingZone == null;

    }

    @Override
    public int hashCode() {
        int result = shippingFreeAmount != null ? shippingFreeAmount.hashCode() : 0;
        result = 31 * result + (shippingType != null ? shippingType.hashCode() : 0);
        result = 31 * result + (shippingZone != null ? shippingZone.hashCode() : 0);
        return result;
    }
}
