/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.front.domain.quote.get;

import com.mirakl.client.domain.common.Unicity;

import java.math.BigDecimal;

@Unicity(includeAll = true)
public class MiraklQuotePriceSummary {

    private BigDecimal price;
    private BigDecimal shippingPrice;
    private BigDecimal totalCommission;
    private BigDecimal totalPrice;

    /**
     * Sum of quantity * unitPrice of all lines
     */
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * Sum of shippingPrice of all lines
     */
    public BigDecimal getShippingPrice() {
        return shippingPrice;
    }

    public void setShippingPrice(BigDecimal shippingPrice) {
        this.shippingPrice = shippingPrice;
    }

    /**
     * Sum of commissionFee + commissionTaxes.amount of all lines
     */
    public BigDecimal getTotalCommission() {
        return totalCommission;
    }

    public void setTotalCommission(BigDecimal totalCommission) {
        this.totalCommission = totalCommission;
    }

    /**
     * Sum of price + shippingFee of all lines
     */
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklQuotePriceSummary that = (MiraklQuotePriceSummary) o;

        if (price != null ? !price.equals(that.price) : that.price != null) {
            return false;
        }
        if (shippingPrice != null ? !shippingPrice.equals(that.shippingPrice) : that.shippingPrice != null) {
            return false;
        }
        if (totalCommission != null ? !totalCommission.equals(that.totalCommission) : that.totalCommission != null) {
            return false;
        }
        return totalPrice != null ? totalPrice.equals(that.totalPrice) : that.totalPrice == null;

    }

    @Override
    public int hashCode() {
        int result = price != null ? price.hashCode() : 0;
        result = 31 * result + (shippingPrice != null ? shippingPrice.hashCode() : 0);
        result = 31 * result + (totalCommission != null ? totalCommission.hashCode() : 0);
        result = 31 * result + (totalPrice != null ? totalPrice.hashCode() : 0);
        return result;
    }
}
