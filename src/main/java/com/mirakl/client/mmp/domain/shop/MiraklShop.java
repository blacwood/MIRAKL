/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.shop;

import com.mirakl.client.domain.common.Unicity;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.Date;

/**
 * A shop is a legal entity or individual who is able to sell products on the Mirakl Marketplace.
 */
@JsonIgnoreProperties({"shipping_types", "shipping_zones", "billing_info"})
@Unicity(props = "id")
public class MiraklShop extends AbstractMiraklShop {

    /**
     * Date until the shop is immunized against suspension
     */
    private Date immunityDate;

    /**
     * Uniqued identifier provided by the Operator
     */
    private String operatorInternalId;

    /**
     * Indicate which method is used to determine if the shop should be premium or not
     */
    private MiraklPremiumState premiumState;

    /**
     * Payment details
     */
    @JsonProperty("payment_details")
    private MiraklPaymentDetail paymentDetail;

    public MiraklPaymentDetail getPaymentDetail() {
        return paymentDetail;
    }

    public void setPaymentDetail(MiraklPaymentDetail paymentDetail) {
        this.paymentDetail = paymentDetail;
    }

    public Date getImmunityDate() {
        return immunityDate;
    }

    public void setImmunityDate(Date immunityDate) {
        this.immunityDate = immunityDate;
    }

    public String getOperatorInternalId() {
        return operatorInternalId;
    }

    public void setOperatorInternalId(String operatorInternalId) {
        this.operatorInternalId = operatorInternalId;
    }

    public MiraklPremiumState getPremiumState() {
        return premiumState;
    }

    public void setPremiumState(MiraklPremiumState premiumState) {
        this.premiumState = premiumState;
    }
}
