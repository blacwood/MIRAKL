/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.front.request.shipping;


import com.mirakl.client.core.internal.util.MiraklApiUtils;
import com.mirakl.client.core.internal.util.Preconditions;
import com.mirakl.client.domain.common.Unicity;

/**
 * Tuple representing the offer with an offer ID, an ordered quantity and a selected shipping type (optional)
 */
@Unicity(includeAll = true)
public class MiraklOfferQuantityShippingTypeTuple {

    private String offerId;
    private int quantity;
    private String shippingTypeCode;
    private Integer leadtimeToShip;

    public MiraklOfferQuantityShippingTypeTuple(String offerId, int quantity, String shippingTypeCode) {
        setOfferId(offerId);
        setQuantity(quantity);
        setShippingTypeCode(shippingTypeCode);
    }

    public MiraklOfferQuantityShippingTypeTuple(String offerId, int quantity) {
        setOfferId(offerId);
        setQuantity(quantity);
    }

    /**
     * Offer ID
     */
    public String getOfferId() {
        return offerId;
    }

    public void setOfferId(String offerId) {
        Preconditions.checkRequiredRequestArgument(offerId, "offerId");
        this.offerId = offerId;
    }

    /**
     * Quantity
     */
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        Preconditions.checkRequiredRequestArgument(quantity, "quantity");
        this.quantity = quantity;
    }

    /**
     * Shipping type code
     */
    public String getShippingTypeCode() {
        return shippingTypeCode;
    }

    public void setShippingTypeCode(String shippingTypeCode) {
        this.shippingTypeCode = shippingTypeCode;
    }

    public Integer getLeadtimeToShip() {
        return leadtimeToShip;
    }

    public void setLeadtimeToShip(Integer leadtimeToShip) {
        this.leadtimeToShip = leadtimeToShip;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(offerId)
                .append(MiraklApiUtils.API_MAP_SEPARATOR)
                .append(quantity);

        if (shippingTypeCode != null) {
            builder.append(MiraklApiUtils.API_MAP_SEPARATOR)
                    .append(shippingTypeCode);
        }

        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklOfferQuantityShippingTypeTuple that = (MiraklOfferQuantityShippingTypeTuple) o;

        if (quantity != that.quantity) {
            return false;
        }
        if (offerId != null ? !offerId.equals(that.offerId) : that.offerId != null) {
            return false;
        }
        return shippingTypeCode != null ? shippingTypeCode.equals(that.shippingTypeCode) : that.shippingTypeCode == null;

    }

    @Override
    public int hashCode() {
        int result = offerId != null ? offerId.hashCode() : 0;
        result = 31 * result + quantity;
        result = 31 * result + (shippingTypeCode != null ? shippingTypeCode.hashCode() : 0);
        return result;
    }
}