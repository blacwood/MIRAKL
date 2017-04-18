/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.front.domain.quote.create;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.domain.common.currency.MiraklIsoCurrencyCode;

import java.math.BigDecimal;

@Unicity(includeAll = true)
public class MiraklQuoteOffer {

    private MiraklIsoCurrencyCode currencyIsoCode;
    private String offerId;
    private BigDecimal unitPrice;
    private Integer quantity;

    public MiraklIsoCurrencyCode getCurrencyIsoCode() {
        return currencyIsoCode;
    }

    public void setCurrencyIsoCode(MiraklIsoCurrencyCode currencyIsoCode) {
        this.currencyIsoCode = currencyIsoCode;
    }

    public String getOfferId() {
        return offerId;
    }

    public void setOfferId(String offerId) {
        this.offerId = offerId;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklQuoteOffer that = (MiraklQuoteOffer) o;

        if (currencyIsoCode != that.currencyIsoCode) {
            return false;
        }
        if (offerId != null ? !offerId.equals(that.offerId) : that.offerId != null) {
            return false;
        }
        if (unitPrice != null ? !unitPrice.equals(that.unitPrice) : that.unitPrice != null) {
            return false;
        }
        return quantity != null ? quantity.equals(that.quantity) : that.quantity == null;

    }

    @Override
    public int hashCode() {
        int result = currencyIsoCode != null ? currencyIsoCode.hashCode() : 0;
        result = 31 * result + (offerId != null ? offerId.hashCode() : 0);
        result = 31 * result + (unitPrice != null ? unitPrice.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        return result;
    }
}
