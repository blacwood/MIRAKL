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
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

@Unicity(includeAll = true)
@JsonIgnoreProperties({
        "shipping_type_code", "shipping_type_label" //deprecated fields moved in selected_shipping_type
})
public class MiraklShopShippingFee {

    private String shopId;
    private String shopName;

    private MiraklShippingTypeWithConfiguration selectedShippingType;

    @JsonProperty("shipping_types")
    private List<MiraklShippingFeeType> availableShippingTypes;

    private List<MiraklShippingFeeOffer> offers;

    private MiraklShopShippingFeeErrorEnum errorCode;
    private String errorMessage;

    private MiraklIsoCurrencyCode currencyIsoCode;
    private Integer leadtimeToShip;

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

    public void setSelectedShippingType(MiraklShippingTypeWithConfiguration selectedShippingType) {
        this.selectedShippingType = selectedShippingType;
    }

    /**
     * List of shipping type information for the shop
     */
    public List<MiraklShippingFeeType> getAvailableShippingTypes() {
        return availableShippingTypes;
    }

    public void setAvailableShippingTypes(List<MiraklShippingFeeType> availableShippingTypes) {
        this.availableShippingTypes = availableShippingTypes;
    }

    /**
     * List of information about the selected offers
     */
    public List<MiraklShippingFeeOffer> getOffers() {
        return offers;
    }

    public void setOffers(List<MiraklShippingFeeOffer> offers) {
        this.offers = offers;
    }

    /**
     * Code of the error associated to the shop
     */
    public MiraklShopShippingFeeErrorEnum getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(MiraklShopShippingFeeErrorEnum errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * Message of the error associated to the shop
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
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

        MiraklShopShippingFee that = (MiraklShopShippingFee) o;

        if (shopId != null ? !shopId.equals(that.shopId) : that.shopId != null) {
            return false;
        }
        if (shopName != null ? !shopName.equals(that.shopName) : that.shopName != null) {
            return false;
        }
        if (selectedShippingType != null ? !selectedShippingType.equals(that.selectedShippingType) : that.selectedShippingType != null) {
            return false;
        }
        if (availableShippingTypes != null ? !availableShippingTypes.equals(that.availableShippingTypes) : that.availableShippingTypes != null) {
            return false;
        }
        if (offers != null ? !offers.equals(that.offers) : that.offers != null) {
            return false;
        }
        if (errorCode != that.errorCode) {
            return false;
        }
        if (errorMessage != null ? !errorMessage.equals(that.errorMessage) : that.errorMessage != null) {
            return false;
        }
        return currencyIsoCode == that.currencyIsoCode;

    }

    @Override
    public int hashCode() {
        int result = shopId != null ? shopId.hashCode() : 0;
        result = 31 * result + (shopName != null ? shopName.hashCode() : 0);
        result = 31 * result + (selectedShippingType != null ? selectedShippingType.hashCode() : 0);
        result = 31 * result + (availableShippingTypes != null ? availableShippingTypes.hashCode() : 0);
        result = 31 * result + (offers != null ? offers.hashCode() : 0);
        result = 31 * result + (errorCode != null ? errorCode.hashCode() : 0);
        result = 31 * result + (errorMessage != null ? errorMessage.hashCode() : 0);
        result = 31 * result + (currencyIsoCode != null ? currencyIsoCode.hashCode() : 0);
        return result;
    }
}
