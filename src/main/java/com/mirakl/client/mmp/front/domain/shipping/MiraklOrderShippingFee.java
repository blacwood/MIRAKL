/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.front.domain.shipping;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.domain.common.currency.MiraklIsoCurrencyCode;
import com.mirakl.client.mmp.domain.shipping.MiraklShippingTypeWithConfiguration;

import java.util.ArrayList;
import java.util.List;

@Unicity(includeAll = true)
public class MiraklOrderShippingFee {

    private List<MiraklOrderShippingFeeOffer> offers = new ArrayList<MiraklOrderShippingFeeOffer>();

    private List<MiraklShippingFeeType> shippingTypes = new ArrayList<MiraklShippingFeeType>();

    private MiraklIsoCurrencyCode currencyIsoCode;
    private String shopId;
    private String shopName;
    private Integer leadtimeToShip;

    private MiraklShippingTypeWithConfiguration selectedShippingType;

    /**
     * Order's offers
     */
    public List<MiraklOrderShippingFeeOffer> getOffers() {
        return offers;
    }

    public void setOffers(List<MiraklOrderShippingFeeOffer> offers) {
        this.offers = offers;
    }

    /**
     * Other available shipping types for the order
     */
    public List<MiraklShippingFeeType> getShippingTypes() {
        return shippingTypes;
    }

    public void setShippingTypes(List<MiraklShippingFeeType> shippingTypes) {
        this.shippingTypes = shippingTypes;
    }

    /**
     * Iso currency code
     */
    public MiraklIsoCurrencyCode getCurrencyIsoCode() {
        return currencyIsoCode;
    }

    public void setCurrencyIsoCode(MiraklIsoCurrencyCode currencyIsoCode) {
        this.currencyIsoCode = currencyIsoCode;
    }

    /**
     * Shop ID
     */
    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    /**
     * Shop name
     */
    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    /**
     * Shipping type selected for the shop and used to calculate the shipping price for each offers
     */
    public MiraklShippingTypeWithConfiguration getSelectedShippingType() {
        return selectedShippingType;
    }

    public void setSelectedShippingType(MiraklShippingTypeWithConfiguration shippingType) {
        this.selectedShippingType = shippingType;
    }

    /**
     * Leadtime to ship for the order
     */
    public Integer getLeadtimeToShip() {
        return leadtimeToShip;
    }

    public void setLeadtimeToShip(Integer leadtimeToShip) {
        this.leadtimeToShip = leadtimeToShip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklOrderShippingFee that = (MiraklOrderShippingFee) o;

        if (offers != null ? !offers.equals(that.offers) : that.offers != null) {
            return false;
        }
        if (shippingTypes != null ? !shippingTypes.equals(that.shippingTypes) : that.shippingTypes != null) {
            return false;
        }
        if (currencyIsoCode != that.currencyIsoCode) {
            return false;
        }
        if (shopId != null ? !shopId.equals(that.shopId) : that.shopId != null) {
            return false;
        }
        if (shopName != null ? !shopName.equals(that.shopName) : that.shopName != null) {
            return false;
        }
        if (leadtimeToShip != null ? !leadtimeToShip.equals(that.leadtimeToShip) : that.leadtimeToShip != null) {
            return false;
        }
        return selectedShippingType != null ? selectedShippingType.equals(that.selectedShippingType) : that.selectedShippingType == null;

    }

    @Override
    public int hashCode() {
        int result = offers != null ? offers.hashCode() : 0;
        result = 31 * result + (shippingTypes != null ? shippingTypes.hashCode() : 0);
        result = 31 * result + (currencyIsoCode != null ? currencyIsoCode.hashCode() : 0);
        result = 31 * result + (shopId != null ? shopId.hashCode() : 0);
        result = 31 * result + (shopName != null ? shopName.hashCode() : 0);
        result = 31 * result + (leadtimeToShip != null ? leadtimeToShip.hashCode() : 0);
        result = 31 * result + (selectedShippingType != null ? selectedShippingType.hashCode() : 0);
        return result;
    }
}
