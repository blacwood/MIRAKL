/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.order;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.domain.order.refund.MiraklRefundState;
import com.mirakl.client.mmp.domain.order.tax.MiraklOrderTaxAmount;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Unicity(props = "id")
public class MiraklRefund {

    private String id;
    private BigDecimal amount;
    private BigDecimal shippingAmount;
    private BigDecimal commissionAmount;
    private BigDecimal commissionTaxAmount;
    private BigDecimal commissionTotalAmount;
    private String reasonCode;
    private Date createdDate;
    private MiraklRefundState state;
    private Date transactionDate;
    private String transactionNumber;
    private Integer quantity;
    private List<MiraklOrderTaxAmount> taxes;
    private List<MiraklOrderTaxAmount> shippingTaxes;
    private List<MiraklCommissionTax> commissionTaxes = new ArrayList<MiraklCommissionTax>();

    /**
     * Refund ID
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Refund amount
     */
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * Refund shipping amount
     */
    public BigDecimal getShippingAmount() {
        return shippingAmount;
    }

    public void setShippingAmount(BigDecimal shippingAmount) {
        this.shippingAmount = shippingAmount;
    }

    /**
     * Refund commission amount
     */
    public BigDecimal getCommissionAmount() {
        return commissionAmount;
    }

    public void setCommissionAmount(BigDecimal commissionAmount) {
        this.commissionAmount = commissionAmount;
    }

    /**
     * Refund commission tax amount
     * @deprecated Please use {@link #getCommissionTaxes()} instead. If multi-taxes are applied to
     * this refund, this field will return the amount of the first tax applied.
     */
    @Deprecated
    public BigDecimal getCommissionTaxAmount() {
        return commissionTaxAmount;
    }

    /**
     * @deprecated Please use {@link #addCommissionTax(MiraklCommissionTax)} instead
     */
    @Deprecated
    public void setCommissionTaxAmount(BigDecimal commissionTaxAmount) {
        this.commissionTaxAmount = commissionTaxAmount;
    }

    /**
     * Refund total commission amount (commission amount + commission taxes)
     */
    public BigDecimal getCommissionTotalAmount() {
        return commissionTotalAmount;
    }

    public void setCommissionTotalAmount(BigDecimal commissionTotalAmount) {
        this.commissionTotalAmount = commissionTotalAmount;
    }

    /**
     * Refund reason code
     */
    public String getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }

    /**
     * Refund creation date
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * Refund state
     */
    public MiraklRefundState getState() {
        return state;
    }

    public void setState(MiraklRefundState state) {
        this.state = state;
    }

    /**
     * Refund payment transaction date
     */
    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    /**
     * Refund payment transaction date
     */
    public String getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(String transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    /**
     * The quantity of products to refund<br/>
     * This quantity is informative only
     */
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * Refunded tax on the price
     */
    public List<MiraklOrderTaxAmount> getTaxes() {
        return taxes;
    }

    public void setTaxes(List<MiraklOrderTaxAmount> taxes) {
        this.taxes = taxes;
    }

    /**
     * Refunded tax on the shipping price
     */
    public List<MiraklOrderTaxAmount> getShippingTaxes() {
        return shippingTaxes;
    }

    public void setShippingTaxes(List<MiraklOrderTaxAmount> shippingTaxes) {
        this.shippingTaxes = shippingTaxes;
    }

    /**
     * List of refunded taxes
     */
    public List<MiraklCommissionTax> getCommissionTaxes() {
        return Collections.unmodifiableList(commissionTaxes);
    }

    public void addCommissionTax(MiraklCommissionTax commissionTax) {
        commissionTaxes.add(commissionTax);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklRefund that = (MiraklRefund) o;

        return id != null ? id.equals(that.id) : that.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
