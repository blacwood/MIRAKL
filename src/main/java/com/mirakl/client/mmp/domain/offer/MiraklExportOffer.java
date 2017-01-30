/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.offer;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.domain.common.MiraklDiscount;
import com.mirakl.client.mmp.domain.common.currency.MiraklIsoCurrencyCode;
import org.codehaus.jackson.annotate.JsonUnwrapped;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Unicity(props = "id")
public class MiraklExportOffer {

    private String id;
    private String productSku;
    @JsonUnwrapped
    private MiraklOfferMinimumShipping minShipping = new MiraklOfferMinimumShipping();
    private BigDecimal price;
    private BigDecimal totalPrice;
    private String priceAdditionalInfo;
    private Integer quantity;
    private String description;
    private String stateCode;
    private String shopId;
    private String shopName;
    private Boolean professional;
    private Boolean premium;
    private String logisticClassCode;
    private boolean active;
    private Integer favoritRank;
    private List<String> channels;
    private Boolean deleted;
    private MiraklDiscount discount;
    private Map<String, String> additionalFields = new HashMap<String, String>();
    private Date availableStartDate;
    private Date availableEndDate;
    private MiraklIsoCurrencyCode currencyIsoCode;
    private Integer leadtimeToShip;

    /**
     * ID of the offer
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * SKU of the product associated to the offer
     */
    public String getProductSku() {
        return productSku;
    }

    public void setProductSku(String productSku) {
        this.productSku = productSku;
    }

    /**
     * Price of the offer (shipping charges excluded)
     */
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * Price of the offer (shipping charges included)
     */
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * Additional information about the price of the offer
     */
    public String getPriceAdditionalInfo() {
        return priceAdditionalInfo;
    }

    public void setPriceAdditionalInfo(String priceAdditionalInfo) {
        this.priceAdditionalInfo = priceAdditionalInfo;
    }

    /**
     * Available stock of the offer
     */
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * Description of the offer
     */
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Code of the condition of the offer (New, Used...)
     */
    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String conditionCode) {
        this.stateCode = conditionCode;
    }

    /**
     * ID of the shop
     */
    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    /**
     * Name of the shop
     */
    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    /**
     * Does the shop is a professional seller
     */
    public Boolean isProfessional() {
        return professional;
    }

    public void setProfessional(Boolean professional) {
        this.professional = professional;
    }

    /**
     * Does the shop has the premium state
     */
    public Boolean isPremium() {
        return premium;
    }

    public void setPremium(Boolean premium) {
        this.premium = premium;
    }

    /**
     * Logistic class code of the offer
     */
    public String getLogisticClassCode() {
        return logisticClassCode;
    }

    public void setLogisticClassCode(String logisticClassCode) {
        this.logisticClassCode = logisticClassCode;
    }

    /**
     * Does the offer is active
     */
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * Favorite rank of the offer.
     * <p>
     * The value can be null if
     * <ul>
     * <li>The favorite offer feature is not enabled</li>
     * <li>The offer has not been marked as favorite by the shop</li>
     * </ul>
     * </p>
     */
    public Integer getFavoritRank() {
        return favoritRank;
    }

    public void setFavoritRank(Integer favoritRank) {
        this.favoritRank = favoritRank;
    }

    /**
     * List of the channels code of the offer
     */
    public List<String> getChannels() {
        return channels;
    }

    public void setChannels(List<String> channels) {
        this.channels = channels;
    }

    /**
     * Is the offer has been deleted?
     */
    public Boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    /**
     * Offer discount
     */
    public MiraklDiscount getDiscount() {
        return discount;
    }

    public void setDiscount(MiraklDiscount discount) {
        this.discount = discount;
    }

    /**
     * A map containing the additional field values mapped by code
     */
    public Map<String, String> getAdditionalFields() {
        return additionalFields;
    }

    public void setAdditionalFields(Map<String, String> additionalFields) {
        this.additionalFields = additionalFields;
    }

    public MiraklOfferMinimumShipping getMinShipping() {
        return minShipping;
    }

    public void setMinShipping(MiraklOfferMinimumShipping minShipping) {
        this.minShipping = minShipping;
    }

    /**
     * When does the offer become available.
     */
    public Date getAvailableStartDate() {
        return availableStartDate;
    }

    public void setAvailableStartDate(Date availableStartDate) {
        this.availableStartDate = availableStartDate;
    }

    /**
     * When does the offer end to be available.
     */
    public Date getAvailableEndDate() {
        return availableEndDate;
    }

    public void setAvailableEndDate(Date availableEndDate) {
        this.availableEndDate = availableEndDate;
    }

    /**
     * Code of the offer's currency
     */
    public MiraklIsoCurrencyCode getCurrencyIsoCode() {
        return currencyIsoCode;
    }

    public void setCurrencyIsoCode(MiraklIsoCurrencyCode currencyIsoCode) {
        this.currencyIsoCode = currencyIsoCode;
    }

    /**
     * The leadtime to ship of the offer (in days), or null if no leadtime to ship is affected to the offer.
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

        MiraklExportOffer that = (MiraklExportOffer) o;

        return id != null ? id.equals(that.id) : that.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
