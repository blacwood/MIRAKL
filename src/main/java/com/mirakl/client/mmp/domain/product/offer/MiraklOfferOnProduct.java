/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.product.offer;

import com.mirakl.client.domain.common.Unicity;
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

/**
 * @deprecated Please use {@link com.mirakl.client.mmp.shop.domain.product.MiraklOfferOnProduct}, or {@link com.mirakl.client.mmp.domain.product.MiraklOfferOnProduct}
 */
@Deprecated
@Unicity(props = "id")
public class MiraklOfferOnProduct {

    @JsonProperty("offer_id")
    private String id;

    private String description;
    private String stateCode;

    private BigDecimal price;
    private String priceAdditionalInfo;
    private BigDecimal totalPrice;

    private String shopName;
    @JsonProperty("is_professional")
    private boolean professional;
    private BigDecimal shopGrade;
    private Long nbEvaluation;

    @JsonUnwrapped
    private MiraklOfferMinimumShipping minShipping;
    private MiraklIsoCurrencyCode currencyIsoCode;
    private Integer leadtimeToShip;

    // Output deprecated for the shops
    private int quantity;
    private int minQuantityAlert;
    private String shopId;
    private boolean premium;
    private Set<String> channels;
    private MiraklDiscount discount;
    @JsonProperty("offer_additional_fields")
    private List<MiraklAdditionalFieldValue> additionalFields;
    private Integer favoriteRank;
    private MiraklOfferAvailability availability;


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
     * Number of evaluation on the shop
     */
    public Long getNbEvaluation() {
        return nbEvaluation;
    }

    public void setNbEvaluation(Long nbEvaluation) {
        this.nbEvaluation = nbEvaluation;
    }

    public MiraklOfferMinimumShipping getMinShipping() {
        return minShipping;
    }

    public void setMinShipping(MiraklOfferMinimumShipping minShipping) {
        this.minShipping = minShipping;
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

    /**
     * Offer ID
     *
     * @deprecated This field is deprecated for SHOPS the value will always null
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Available stock
     *
     * @deprecated This field is deprecated for SHOPS the value will always 999
     */
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * An alert is raised to the shop when the offer stock reach this minimum quantity
     *
     * @deprecated This field is deprecated for SHOPS the value will always 0
     */
    public int getMinQuantityAlert() {
        return minQuantityAlert;
    }

    public void setMinQuantityAlert(int minQuantityAlert) {
        this.minQuantityAlert = minQuantityAlert;
    }

    /**
     * Shop ID
     *
     * @deprecated This field is deprecated for SHOPS the value will always null
     */
    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    /**
     * Is the shop premium?
     *
     * @deprecated This field is deprecated for SHOPS the value will always FALSE
     */
    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    /**
     * Offer discount
     *
     * @deprecated This field is deprecated for SHOPS the value will always null
     */
    public MiraklDiscount getDiscount() {
        return discount;
    }

    public void setDiscount(MiraklDiscount discount) {
        this.discount = discount;
    }

    /**
     * Channels code associated to the offer
     *
     * @deprecated This field is deprecated for SHOPS the value will always be an empty set
     */
    public Set<String> getChannels() {
        return channels;
    }

    public void setChannels(Set<String> channels) {
        this.channels = channels;
    }

    /**
     * Additional fields on the offer
     *
     * @deprecated This field is deprecated for SHOPS the value will always be an empry list
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
     *
     * @deprecated This field is deprecated for SHOPS the value will always null
     */
    public Integer getFavoriteRank() {
        return favoriteRank;
    }

    public void setFavoriteRank(Integer favoriteRank) {
        this.favoriteRank = favoriteRank;
    }

    /**
     * Availability period
     *
     * @deprecated This field is deprecated for SHOPS the value will always null
     */
    public MiraklOfferAvailability getAvailability() {
        return availability;
    }

    public void setAvailability(MiraklOfferAvailability availability) {
        this.availability = availability;
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
