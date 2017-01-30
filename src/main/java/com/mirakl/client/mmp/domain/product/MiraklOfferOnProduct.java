/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.product;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.domain.category.MiraklLogisticClass;
import com.mirakl.client.mmp.domain.common.MiraklAdditionalFieldValue;
import com.mirakl.client.mmp.domain.common.MiraklDiscount;
import com.mirakl.client.mmp.domain.common.currency.MiraklIsoCurrencyCode;
import com.mirakl.client.mmp.domain.offer.MiraklOfferAvailability;
import com.mirakl.client.mmp.domain.offer.MiraklOfferMinimumShipping;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonUnwrapped;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Unicity(props = "id")
public class MiraklOfferOnProduct {

    @JsonProperty("offer_id")
    private String id;

    private String description;
    private String stateCode;
    private boolean active;
    private MiraklLogisticClass logisticClass;

    private BigDecimal price;
    private String priceAdditionalInfo;
    private MiraklDiscount discount;
    private BigDecimal totalPrice;

    private int quantity;
    private Integer minQuantityAlert;

    @JsonUnwrapped
    private MiraklOfferMinimumShipping minShipping;

    private String shopId;
    private String shopName;
    @JsonProperty("is_professional")
    private boolean professional;
    private BigDecimal shopGrade;
    private boolean premium;
    private Long nbEvaluation;

    private Set<String> channels;

    @JsonProperty("offer_additional_fields")
    private List<MiraklAdditionalFieldValue> additionalFields;

    private Integer favoriteRank;
    private MiraklOfferAvailability availability;
    private MiraklIsoCurrencyCode currencyIsoCode;
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
     * Offer state code (aka, offer's condition: new, used...)
     */
    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    /**
     * Is the offer active ?
     */
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * The logistic class associated to the offer
     */
    public MiraklLogisticClass getLogisticClass() {
        return logisticClass;
    }

    public void setLogisticClass(MiraklLogisticClass logisticClass) {
        this.logisticClass = logisticClass;
    }

    /**
     * Offer price
     */
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * Additional info on the offer price
     */
    public String getPriceAdditionalInfo() {
        return priceAdditionalInfo;
    }

    public void setPriceAdditionalInfo(String priceAdditionalInfo) {
        this.priceAdditionalInfo = priceAdditionalInfo;
    }

    /**
     * Offer total price (price + minShipping price)
     */
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * Available stock
     */
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * An alert is raised to the shop when the offer stock reach this minimum quantity
     */
    public Integer getMinQuantityAlert() {
        return minQuantityAlert;
    }

    public void setMinQuantityAlert(Integer minQuantityAlert) {
        this.minQuantityAlert = minQuantityAlert;
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
     * Is the shop professional?
     */
    public boolean isProfessional() {
        return professional;
    }

    public void setProfessional(boolean professional) {
        this.professional = professional;
    }

    /**
     * Shop grade
     */
    public BigDecimal getShopGrade() {
        return shopGrade;
    }

    public void setShopGrade(BigDecimal shopGrade) {
        this.shopGrade = shopGrade;
    }

    /**
     * Is the shop premium?
     */
    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    /**
     * Number of evaluation on the shop
     */
    public Long getNbEvaluation() {
        return nbEvaluation;
    }

    public void setNbEvaluation(Long nbEvaluation) {
        this.nbEvaluation = nbEvaluation;
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
     * Channels code associated to the offer
     */
    public Set<String> getChannels() {
        return channels;
    }

    public void setChannels(Set<String> channels) {
        this.channels = channels;
    }

    /**
     * Additional fields on the offer
     */
    public List<MiraklAdditionalFieldValue> getAdditionalFields() {
        return additionalFields == null ? null : Collections.unmodifiableList(additionalFields);
    }

    public void setAdditionalFields(List<MiraklAdditionalFieldValue> additionalFields) {
        this.additionalFields = additionalFields;
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

    public MiraklOfferMinimumShipping getMinShipping() {
        return minShipping;
    }

    public void setMinShipping(MiraklOfferMinimumShipping minShipping) {
        this.minShipping = minShipping;
    }

    /**
     * Availability period
     */
    public MiraklOfferAvailability getAvailability() {
        return availability;
    }

    public void setAvailability(MiraklOfferAvailability availability) {
        this.availability = availability;
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

        MiraklOfferOnProduct that = (MiraklOfferOnProduct) o;

        return id != null ? id.equals(that.id) : that.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
