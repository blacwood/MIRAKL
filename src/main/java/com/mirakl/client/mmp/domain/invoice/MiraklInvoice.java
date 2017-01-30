/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.invoice;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.domain.common.currency.MiraklIsoCurrencyCode;
import org.codehaus.jackson.annotate.JsonProperty;

import java.math.BigDecimal;
import java.util.Date;

@Unicity(props = "id")
public class MiraklInvoice {

    @JsonProperty("invoice_id")
    private String id;
    private Date dateCreated;
    private BigDecimal totalChargedAmount;
    private Date startTime;
    private Date endTime;
    private MiraklIsoCurrencyCode currencyIsoCode;

    /**
     * Invoice Number
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Invoice creation date
     */
    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    /**
     * Invoice total charged amount
     */
    public BigDecimal getTotalChargedAmount() {
        return totalChargedAmount;
    }

    public void setTotalChargedAmount(BigDecimal totalChargedAmount) {
        this.totalChargedAmount = totalChargedAmount;
    }

    /**
     * Invoice period start date
     */
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * Invoice period end date
     */
    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * ISO Currency code
     */
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

        MiraklInvoice that = (MiraklInvoice) o;

        return id.equals(that.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
