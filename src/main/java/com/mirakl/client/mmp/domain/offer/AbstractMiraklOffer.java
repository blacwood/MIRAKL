/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.offer;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.domain.category.MiraklLogisticClass;
import com.mirakl.client.mmp.domain.common.MiraklAdditionalFieldValue;
import com.mirakl.client.mmp.domain.common.MiraklDiscount;
import com.mirakl.client.mmp.domain.common.currency.MiraklIsoCurrencyCode;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonUnwrapped;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Unicity(props = "id")
public abstract class AbstractMiraklOffer {

    @JsonProperty("offer_id")
    private String id;

    private String description;
    private String stateCode;

    private BigDecimal price;
    private String priceAdditionalInfo;
    private BigDecimal totalPrice;
    private MiraklDiscount discount;

    private int quantity;
    private int minQuantityAlert;

    private Set<String> channels;
    private MiraklIsoCurrencyCode currencyIsoCode;

    private Integer favoriteRank;

    @JsonUnwrapped
    private MiraklProductInformationWithReferences product;

    @JsonUnwrapped
    private MiraklOfferMinimumShipping minShipping;

    @JsonUnwrapped
    private MiraklOfferAvailability availability;

    @JsonProperty("offer_additional_fields")
    private List<MiraklAdditionalFieldValue> additionalFields;

    private boolean active;

    private MiraklLogisticClass logisticClass;

    private Integer leadtimeToShip;

    /**
     * Offer ID
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Offer description
     */
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Offer State Code
     */
    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    /**
     * Offer Price
     */
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * Additional information on offer price
     */
    public String getPriceAdditionalInfo() {
        return priceAdditionalInfo;
    }

    public void setPriceAdditionalInfo(String priceAdditionalInfo) {
        this.priceAdditionalInfo = priceAdditionalInfo;
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
     * Offer total price (includes shipping)
     */
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * Offer quantity (stock)
     */
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Offer additional fields
     */
    public List<MiraklAdditionalFieldValue> getAdditionalFields() {
        return additionalFields == null ? null : Collections.unmodifiableList(additionalFields);
    }

    public void setAdditionalFields(List<MiraklAdditionalFieldValue> additionalFields) {
        this.additionalFields = additionalFields;
    }

    /**
     * Channels code associated to the shop selling the offer
     */
    public Set<String> getChannels() {
        return channels;
    }

    public void setChannels(Set<String> channels) {
        this.channels = channels;
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
    public Integer getFavoriteRank() {
        return favoriteRank;
    }

    public void setFavoriteRank(Integer favoriteRank) {
        this.favoriteRank = favoriteRank;
    }

    /**
     * An alert is raised to the shop when the offer stock reach this minimum quantity
     */
    public int getMinQuantityAlert() {
        return minQuantityAlert;
    }

    public void setMinQuantityAlert(int minQuantityAlert) {
        this.minQuantityAlert = minQuantityAlert;
    }

    public MiraklOfferMinimumShipping getMinShipping() {
        return minShipping;
    }

    public void setMinShipping(MiraklOfferMinimumShipping minShipping) {
        this.minShipping = minShipping;
    }

    public MiraklProductInformationWithReferences getProduct() {
        return product;
    }

    public void setProduct(MiraklProductInformationWithReferences product) {
        this.product = product;
    }

    public MiraklOfferAvailability getAvailability() {
        return availability;
    }

    public void setAvailability(MiraklOfferAvailability availability) {
        this.availability = availability;
    }

    /**
     * Offer active status
     */
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * Logistic class of the offer
     */
    public MiraklLogisticClass getLogisticClass() {
        return logisticClass;
    }

    public void setLogisticClass(MiraklLogisticClass logisticClass) {
        this.logisticClass = logisticClass;
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
     * The leadtime to ship of the offer, or null if no leadtime to ship is associated with the offer
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

        AbstractMiraklOffer that = (AbstractMiraklOffer) o;

        return id != null ? id.equals(that.id) : that.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
