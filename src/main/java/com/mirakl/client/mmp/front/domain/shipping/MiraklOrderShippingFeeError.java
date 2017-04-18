/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.front.domain.shipping;

import com.mirakl.client.domain.common.Unicity;

@Unicity(includeAll = true)
public class MiraklOrderShippingFeeError {

    private MiraklOrderShippingFeeErrorEnum errorCode;
    private String offerId;
    private String shippingTypeCode;

    /**
     * Error code
     */
    public MiraklOrderShippingFeeErrorEnum getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(MiraklOrderShippingFeeErrorEnum errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * ID of the in error offer
     */
    public String getOfferId() {
        return offerId;
    }

    public void setOfferId(String offerId) {
        this.offerId = offerId;
    }

    /**
     * Code of the in error shipping type
     */
    public String getShippingTypeCode() {
        return shippingTypeCode;
    }

    public void setShippingTypeCode(String shippingTypeCode) {
        this.shippingTypeCode = shippingTypeCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklOrderShippingFeeError that = (MiraklOrderShippingFeeError) o;

        if (errorCode != that.errorCode) {
            return false;
        }
        if (offerId != null ? !offerId.equals(that.offerId) : that.offerId != null) {
            return false;
        }
        return shippingTypeCode != null ? shippingTypeCode.equals(that.shippingTypeCode) : that.shippingTypeCode == null;

    }

    @Override
    public int hashCode() {
        int result = errorCode != null ? errorCode.hashCode() : 0;
        result = 31 * result + (offerId != null ? offerId.hashCode() : 0);
        result = 31 * result + (shippingTypeCode != null ? shippingTypeCode.hashCode() : 0);
        return result;
    }
}
