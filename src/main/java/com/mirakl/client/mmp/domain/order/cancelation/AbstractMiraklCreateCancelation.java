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
import java.util.Collections;
import java.util.List;

@Unicity(includeAll = true)
public abstract class AbstractMiraklCreateCancelation {

    private BigDecimal amount;
    private MiraklIsoCurrencyCode currencyIsoCode;
    private String orderLineId;
    private Integer quantity;
    private String reasonCode;
    private BigDecimal shippingAmount;
    private List<MiraklOrderTaxAmount> shippingTaxes = new ArrayList<MiraklOrderTaxAmount>();
    private List<MiraklOrderTaxAmount> taxes = new ArrayList<MiraklOrderTaxAmount>();

    /**
     * @param orderLineId The order line id that must be canceled
     */
    public void setOrderLineId(String orderLineId) {
        this.orderLineId = orderLineId;
    }

    /**
     * Cancelation reason code
     */
    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }

    /**
     * The offer part amount to be canceled.
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * The quantity of products to cancel.<br/>
     * <b>This quantity is informative only.</b>
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * The shipping charges part amount to be canceled.
     */
    public void setShippingAmount(BigDecimal shippingAmount) {
        this.shippingAmount = shippingAmount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public BigDecimal getShippingAmount() {
        return shippingAmount;
    }

    public String getOrderLineId() {
        return orderLineId;
    }

    public String getReasonCode() {
        return reasonCode;
    }

    /**
     * The taxes on the price to cancel
     */
    public List<MiraklOrderTaxAmount> getTaxes() {
        return taxes;
    }

    public void setTaxes(List<MiraklOrderTaxAmount> taxes) {
        this.taxes = taxes;
    }

    /**
     * The taxes on the shipping price to ca,cel
     */
    public List<MiraklOrderTaxAmount> getShippingTaxes() {
        return Collections.unmodifiableList(shippingTaxes);
    }

    public void setShippingTaxes(List<MiraklOrderTaxAmount> shippingTaxes) {
        this.shippingTaxes.addAll(shippingTaxes);
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

        AbstractMiraklCreateCancelation that = (AbstractMiraklCreateCancelation) o;

        if (amount != null ? !amount.equals(that.amount) : that.amount != null) {
            return false;
        }
        if (currencyIsoCode != that.currencyIsoCode) {
            return false;
        }
        if (orderLineId != null ? !orderLineId.equals(that.orderLineId) : that.orderLineId != null) {
            return false;
        }
        if (quantity != null ? !quantity.equals(that.quantity) : that.quantity != null) {
            return false;
        }
        if (reasonCode != null ? !reasonCode.equals(that.reasonCode) : that.reasonCode != null) {
            return false;
        }
        if (shippingAmount != null ? !shippingAmount.equals(that.shippingAmount) : that.shippingAmount != null) {
            return false;
        }
        if (shippingTaxes != null ? !shippingTaxes.equals(that.shippingTaxes) : that.shippingTaxes != null) {
            return false;
        }
        return taxes != null ? taxes.equals(that.taxes) : that.taxes == null;

    }

    @Override
    public int hashCode() {
        int result = amount != null ? amount.hashCode() : 0;
        result = 31 * result + (currencyIsoCode != null ? currencyIsoCode.hashCode() : 0);
        result = 31 * result + (orderLineId != null ? orderLineId.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (reasonCode != null ? reasonCode.hashCode() : 0);
        result = 31 * result + (shippingAmount != null ? shippingAmount.hashCode() : 0);
        result = 31 * result + (shippingTaxes != null ? shippingTaxes.hashCode() : 0);
        result = 31 * result + (taxes != null ? taxes.hashCode() : 0);
        return result;
    }
}
