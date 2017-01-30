/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.shop;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.domain.common.currency.MiraklIsoCurrencyCode;
import com.mirakl.client.mmp.domain.shop.bank.MiraklPaymentInformation;
import com.mirakl.client.mmp.request.additionalfield.MiraklRequestAdditionalFieldValue;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Unicity(includeAll = true)
public abstract class AbstractCommonMiraklShop {


    @JsonProperty("pro_details")
    private MiraklProfessionalInformation professionalInformation;
    @JsonProperty("shop_name")
    private String name;
    private String email;
    private String fax;
    private String webSite;
    private String operatorInternalId;
    @JsonProperty("is_professional")
    private boolean professional;
    private String shippingCountry;
    private String description;
    private String returnPolicy;
    @JsonProperty("closed_from_date")
    private Date closedFrom;
    @JsonProperty("closed_to_date")
    private Date closedTo;
    @JsonProperty("immunity_date")
    private Date immunizedUntil;

    private Boolean suspend;
    private Boolean paymentBlocked;

    private MiraklIsoCurrencyCode currencyIsoCode;

    @JsonProperty("shop_additional_fields")
    private List<MiraklRequestAdditionalFieldValue> additionalFieldValues;

    @JsonProperty("payment_info")
    private MiraklPaymentInformation paymentInformation;

    public MiraklProfessionalInformation getProfessionalInformation() {
        return professionalInformation;
    }

    public void setProfessionalInformation(MiraklProfessionalInformation professionalInformation) {
        this.professionalInformation = professionalInformation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getOperatorInternalId() {
        return operatorInternalId;
    }

    public void setOperatorInternalId(String operatorInternalId) {
        this.operatorInternalId = operatorInternalId;
    }

    public boolean isProfessional() {
        return professional;
    }

    public void setProfessional(boolean professional) {
        this.professional = professional;
    }

    public Boolean getSuspend() {
        return suspend;
    }

    public void setSuspend(Boolean suspend) {
        this.suspend = suspend;
    }

    public Boolean getPaymentBlocked() {
        return paymentBlocked;
    }

    public void setPaymentBlocked(Boolean paymentBlocked) {
        this.paymentBlocked = paymentBlocked;
    }

    public String getShippingCountry() {
        return shippingCountry;
    }

    public void setShippingCountry(String shippingCountry) {
        this.shippingCountry = shippingCountry;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReturnPolicy() {
        return returnPolicy;
    }

    public void setReturnPolicy(String returnPolicy) {
        this.returnPolicy = returnPolicy;
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

    public Date getImmunizedUntil() {
        return immunizedUntil;
    }

    public void setImmunizedUntil(Date immunizedUntil) {
        this.immunizedUntil = immunizedUntil;
    }

    public List<MiraklRequestAdditionalFieldValue> getAdditionalFieldValues() {
        return additionalFieldValues == null ? null : Collections.unmodifiableList(additionalFieldValues);
    }

    public void setAdditionalFieldValues(List<MiraklRequestAdditionalFieldValue> additionalFieldValues) {
        this.additionalFieldValues = additionalFieldValues;
    }

    public MiraklPaymentInformation getPaymentInformation() {
        return paymentInformation;
    }

    public void setPaymentInformation(MiraklPaymentInformation paymentInformation) {
        this.paymentInformation = paymentInformation;
    }

    public MiraklIsoCurrencyCode getCurrencyIsoCode() {
        return currencyIsoCode;
    }

    public void setCurrencyIsoCode(MiraklIsoCurrencyCode currencyIsoCode) {
        this.currencyIsoCode = currencyIsoCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractCommonMiraklShop)) return false;

        AbstractCommonMiraklShop that = (AbstractCommonMiraklShop) o;

        if (professional != that.professional) return false;
        if (additionalFieldValues != null ? !additionalFieldValues.equals(that.additionalFieldValues) : that.additionalFieldValues != null)
            return false;
        if (closedFrom != null ? !closedFrom.equals(that.closedFrom) : that.closedFrom != null) return false;
        if (closedTo != null ? !closedTo.equals(that.closedTo) : that.closedTo != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (fax != null ? !fax.equals(that.fax) : that.fax != null) return false;
        if (immunizedUntil != null ? !immunizedUntil.equals(that.immunizedUntil) : that.immunizedUntil != null)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (operatorInternalId != null ? !operatorInternalId.equals(that.operatorInternalId) : that.operatorInternalId != null)
            return false;
        if (paymentInformation != null ? !paymentInformation.equals(that.paymentInformation) : that.paymentInformation != null)
            return false;
        if (professionalInformation != null ? !professionalInformation.equals(that.professionalInformation) : that.professionalInformation != null)
            return false;
        if (returnPolicy != null ? !returnPolicy.equals(that.returnPolicy) : that.returnPolicy != null) return false;
        if (shippingCountry != null ? !shippingCountry.equals(that.shippingCountry) : that.shippingCountry != null)
            return false;
        if (suspend != null ? !suspend.equals(that.suspend) : that.suspend != null) return false;
        if (webSite != null ? !webSite.equals(that.webSite) : that.webSite != null) return false;
        if (paymentBlocked != null ? !paymentBlocked.equals(that.paymentBlocked) : that.paymentBlocked != null)
            return false;
        if (currencyIsoCode != null ? !currencyIsoCode.equals(that.currencyIsoCode) : that.currencyIsoCode != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = professionalInformation != null ? professionalInformation.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (fax != null ? fax.hashCode() : 0);
        result = 31 * result + (webSite != null ? webSite.hashCode() : 0);
        result = 31 * result + (operatorInternalId != null ? operatorInternalId.hashCode() : 0);
        result = 31 * result + (professional ? 1 : 0);
        result = 31 * result + (suspend != null ? suspend.hashCode() : 0);
        result = 31 * result + (paymentBlocked != null ? paymentBlocked.hashCode() : 0);
        result = 31 * result + (shippingCountry != null ? shippingCountry.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (returnPolicy != null ? returnPolicy.hashCode() : 0);
        result = 31 * result + (closedFrom != null ? closedFrom.hashCode() : 0);
        result = 31 * result + (closedTo != null ? closedTo.hashCode() : 0);
        result = 31 * result + (immunizedUntil != null ? immunizedUntil.hashCode() : 0);
        result = 31 * result + (additionalFieldValues != null ? additionalFieldValues.hashCode() : 0);
        result = 31 * result + (paymentInformation != null ? paymentInformation.hashCode() : 0);
        result = 31 * result + (currencyIsoCode != null ? currencyIsoCode.hashCode() : 0);
        return result;
    }
}
