/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.payment.debit;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.domain.common.currency.MiraklIsoCurrencyCode;
import com.mirakl.client.mmp.domain.payment.MiraklPaymentStatus;

import java.math.BigDecimal;
import java.util.Date;

@Unicity(includeAll = true)
public class MiraklOrderPayment {

    private BigDecimal amount;
    private String customerId;
    private String orderId;
    private MiraklPaymentStatus paymentStatus;
    private Date transactionDate;
    private String transactionNumber;
    private MiraklIsoCurrencyCode currencyIsoCode;

    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Amount debited for the order
     * Required if {@link #paymentStatus} is {@link com.mirakl.client.mmp.domain.payment.MiraklPaymentStatus#OK}
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCustomerId() {
        return customerId;
    }

    /**
     * Order customer ID
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getOrderId() {
        return orderId;
    }

    /**
     * Order ID
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public MiraklPaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    /**
     * Payment status
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
     * Order currency (optional if the shop is using the default platform currency)
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

        MiraklOrderPayment that = (MiraklOrderPayment) o;

        if (amount != null ? !amount.equals(that.amount) : that.amount != null) {
            return false;
        }
        if (customerId != null ? !customerId.equals(that.customerId) : that.customerId != null) {
            return false;
        }
        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) {
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
        result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
        result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
        result = 31 * result + (paymentStatus != null ? paymentStatus.hashCode() : 0);
        result = 31 * result + (transactionDate != null ? transactionDate.hashCode() : 0);
        result = 31 * result + (transactionNumber != null ? transactionNumber.hashCode() : 0);
        result = 31 * result + (currencyIsoCode != null ? currencyIsoCode.hashCode() : 0);
        return result;
    }
}
