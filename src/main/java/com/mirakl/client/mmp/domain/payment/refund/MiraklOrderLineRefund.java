/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.payment.refund;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.domain.common.currency.MiraklIsoCurrencyCode;
import com.mirakl.client.mmp.domain.payment.MiraklPaymentStatus;

import java.math.BigDecimal;
import java.util.Date;

@Unicity(includeAll = true)
public class MiraklOrderLineRefund {

    private BigDecimal amount;
    private String refundId;
    private MiraklPaymentStatus paymentStatus;
    private Date transactionDate;
    private String transactionNumber;
    private MiraklIsoCurrencyCode currencyIsoCode;

    /**
     * Refund amount.
     * Required if {@link #paymentStatus} is {@link com.mirakl.client.mmp.domain.payment.MiraklPaymentStatus#OK}
     */
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getRefundId() {
        return refundId;
    }

    /**
     * Refund ID
     */
    public void setRefundId(String refundId) {
        this.refundId = refundId;
    }

    public MiraklPaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    /**
     * Payment Status of the refund
     */
    public void setPaymentStatus(MiraklPaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    /**
     * Transaction date (optional)
     */
    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionNumber() {
        return transactionNumber;
    }

    /**
     * Transaction number (optional)
     */
    public void setTransactionNumber(String transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    /**
     * Refund currency (optional if the shop is using the default platform currency)
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

        MiraklOrderLineRefund that = (MiraklOrderLineRefund) o;

        if (amount != null ? !amount.equals(that.amount) : that.amount != null) {
            return false;
        }
        if (refundId != null ? !refundId.equals(that.refundId) : that.refundId != null) {
            return false;
        }
        if (paymentStatus != that.paymentStatus) {
            return false;
        }
        if (transactionDate != null ? !transactionDate.equals(that.transactionDate) : that.transactionDate != null) {
            return false;
        }
        if (transactionNumber != null ? !transactionNumber.equals(that.transactionNumber) : that.transactionNumber != null) {
            return false;
        }
        return currencyIsoCode == that.currencyIsoCode;

    }

    @Override
    public int hashCode() {
        int result = amount != null ? amount.hashCode() : 0;
        result = 31 * result + (refundId != null ? refundId.hashCode() : 0);
        result = 31 * result + (paymentStatus != null ? paymentStatus.hashCode() : 0);
        result = 31 * result + (transactionDate != null ? transactionDate.hashCode() : 0);
        result = 31 * result + (transactionNumber != null ? transactionNumber.hashCode() : 0);
        result = 31 * result + (currencyIsoCode != null ? currencyIsoCode.hashCode() : 0);
        return result;
    }
}
