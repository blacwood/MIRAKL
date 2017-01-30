/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.shop;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.domain.common.MiraklAdditionalFieldValue;
import com.mirakl.client.mmp.domain.common.currency.MiraklIsoCurrencyCode;
import com.mirakl.client.mmp.domain.shop.bank.MiraklPaymentInformation;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonUnwrapped;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * A shop is a legal entity or individual who is able to sell products on the Mirakl Marketplace.
 */
@Unicity(props = "id")
public abstract class AbstractMiraklShop {

    /**
     * Unique identifier
     */
    @JsonProperty("shop_id")
    private String id;

    /**
     * Creation date on the platform
     */
    private Date dateCreated;

    /**
     * Name
     */
    @JsonProperty("shop_name")
    private String name;

    /**
     * Currency
     */
    private MiraklIsoCurrencyCode currencyIsoCode;

    /**
     * Short text describing the shop
     */
    private String description;

    /**
     * Indicate whether the shop is a professional or not
     */
    @JsonProperty("is_professional")
    private boolean professional;

    /**
     * Indicate whether the shop is a premium or not
     */
    private boolean premium;

    /**
     * List of the channel codes
     */
    private List<String> channels;

    /**
     * Payment information
     */
    @JsonProperty("payment_info")
    private MiraklPaymentInformation paymentInformation;

    /**
     * Date from which the shop will be closed for business and it's offers deactivated
     */
    private Date closedFrom;

    /**
     * Date from which the shop will be opened for business
     */
    private Date closedTo;

    /**
     * Media URLs
     */
    @JsonUnwrapped
    private MiraklMediaInformation mediaInformation;

    /**
     * Contact information
     */
    @JsonProperty("contact_informations")
    private MiraklContactInformation contactInformation;

    /**
     * Shipping information
     */
    @JsonUnwrapped
    private MiraklShippingInformation shippingInformation;

    /**
     * Date indicated when the shop last modification on any attributes has occured
     */
    private Date lastUpdatedDate;

    /**
     * Professional details
     */
    @JsonProperty("pro_details")
    private MiraklProfessionalInformation professionalInformation;

    /**
     * Short text indicating the terms of restitution of a product to the shop
     */
    private String returnPolicy;

    /**
     * State shop : OPEN or CLOSE
     */
    @JsonProperty("shop_state")
    private MiraklShopState state;

    /**
     * List of additional fields
     */
    @JsonProperty("shop_additional_fields")
    private List<MiraklAdditionalFieldValue> additionalFieldValues;

    /**
     * Average evaluations grade
     */
    private BigDecimal grade;

    /**
     * Shop statistic
     */
    @JsonUnwrapped
    private MiraklShopStats shopStatistic;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isProfessional() {
        return professional;
    }

    public void setProfessional(boolean professional) {
        this.professional = professional;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public List<String> getChannels() {
        return channels;
    }

    public void setChannels(List<String> channels) {
        this.channels = channels;
    }

    public MiraklPaymentInformation getPaymentInformation() {
        return paymentInformation;
    }

    public void setPaymentInformation(MiraklPaymentInformation paymentInformation) {
        this.paymentInformation = paymentInformation;
    }

    public Date getClosedFrom() {
        return closedFrom;
    }

    public void setClosedFrom(Date closedFrom) {
        this.closedFrom = closedFrom;
    }

    public Date getClosedTo() {
        return closedTo;
    }

    public void setClosedTo(Date closedTo) {
        this.closedTo = closedTo;
    }

    public MiraklMediaInformation getMediaInformation() {
        return mediaInformation;
    }

    public void setMediaInformation(MiraklMediaInformation mediaInformation) {
        this.mediaInformation = mediaInformation;
    }

    public MiraklContactInformation getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(MiraklContactInformation contactInformation) {
        this.contactInformation = contactInformation;
    }

    public MiraklShippingInformation getShippingInformation() {
        return shippingInformation;
    }

    public void setShippingInformation(MiraklShippingInformation shippingInformation) {
        this.shippingInformation = shippingInformation;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public MiraklProfessionalInformation getProfessionalInformation() {
        return professionalInformation;
    }

    public void setProfessionalInformation(MiraklProfessionalInformation professionalInformation) {
        this.professionalInformation = professionalInformation;
    }

    public String getReturnPolicy() {
        return returnPolicy;
    }

    public void setReturnPolicy(String returnPolicy) {
        this.returnPolicy = returnPolicy;
    }

    public MiraklShopState getState() {
        return state;
    }

    public void setState(MiraklShopState state) {
        this.state = state;
    }

    public List<MiraklAdditionalFieldValue> getAdditionalFieldValues() {
        return additionalFieldValues == null ? null : Collections.unmodifiableList(additionalFieldValues);
    }

    public void setAdditionalFieldValues(List<MiraklAdditionalFieldValue> additionalFieldValues) {
        this.additionalFieldValues = additionalFieldValues;
    }

    public BigDecimal getGrade() {
        return grade;
    }

    public void setGrade(BigDecimal grade) {
        this.grade = grade;
    }

    public MiraklShopStats getShopStatistic() {
        return shopStatistic;
    }

    public void setShopStatistic(MiraklShopStats shopStatistic) {
        this.shopStatistic = shopStatistic;
    }

    public MiraklIsoCurrencyCode getCurrencyIsoCode() {
        return currencyIsoCode;
    }

    public void setCurrencyIsoCode(MiraklIsoCurrencyCode currencyIsoCode) {
        this.currencyIsoCode = currencyIsoCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AbstractMiraklShop that = (AbstractMiraklShop) o;

        return id != null ? id.equals(that.id) : that.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
