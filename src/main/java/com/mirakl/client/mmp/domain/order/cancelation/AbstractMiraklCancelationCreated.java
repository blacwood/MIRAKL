/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.order.cancelation;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.domain.common.currency.MiraklIsoCurrencyCode;
import com.mirakl.client.mmp.domain.order.tax.MiraklOrderTaxAmount;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Unicity(props = "id")
public abstract class AbstractMiraklCancelationCreated {

    private String id;
    private BigDecimal amount;
    private MiraklIsoCurrencyCode currencyIsoCode;
    private String orderLineId;
    private Integer quantity;
    private String reasonCode;
    private BigDecimal shippingAmount;
    private List<MiraklOrderTaxAmount> shippingTaxes = new ArrayList<MiraklOrderTaxAmount>();
    private List<MiraklOrderTaxAmount> taxes = new ArrayList<MiraklOrderTaxAmount>();

    /**
     * The cancelation id
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * The product amount of the cancelation
     */
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * The ISO code of the currency in which the order was placed
     */
    public MiraklIsoCurrencyCode getCurrencyIsoCode() {
        return currencyIsoCode;
    }

    public void setCurrencyIsoCode(MiraklIsoCurrencyCode currencyIsoCode) {
        this.currencyIsoCode = currencyIsoCode;
    }

    /**
     * The id of the canceled order line
     */
    public String getOrderLineId() {
        return orderLineId;
    }

    public void setOrderLineId(String orderLineId) {
        this.orderLineId = orderLineId;
    }

    /**
     * The quantity canceled.
     * This quantity is given only as an information, no computation should be done from it.
     */
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * The code of the cancelation reason
     */
    public String getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }

    /**
     * The shipping amount of the cancelation
     */
    public BigDecimal getShippingAmount() {
        return shippingAmount;
    }

    public void setShippingAmount(BigDecimal shippingAmount) {
        this.shippingAmount = shippingAmount;
    }

    /**
     * The canceled shipping taxes
     */
    public List<MiraklOrderTaxAmount> getShippingTaxes() {
        return shippingTaxes;
    }

    public void setShippingTaxes(List<MiraklOrderTaxAmount> shippingTaxes) {
        this.shippingTaxes = shippingTaxes;
    }

    /**
     * The canceled taxes
     */
    public List<MiraklOrderTaxAmount> getTaxes() {
        return taxes;
    }

    public void setTaxes(List<MiraklOrderTaxAmount> taxes) {
        this.taxes = taxes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AbstractMiraklCancelationCreated that = (AbstractMiraklCancelationCreated) o;

        return id != null ? id.equals(that.id) : that.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
