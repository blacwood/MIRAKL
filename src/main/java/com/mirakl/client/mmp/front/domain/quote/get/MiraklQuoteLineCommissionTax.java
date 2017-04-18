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
public class MiraklQuoteLineCommissionTax {

    private BigDecimal amount;
    private String code;
    private BigDecimal rate;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MiraklQuoteLineCommissionTax that = (MiraklQuoteLineCommissionTax) o;

        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        return rate != null ? rate.equals(that.rate) : that.rate == null;

    }

    @Override
    public int hashCode() {
        int result = amount != null ? amount.hashCode() : 0;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (rate != null ? rate.hashCode() : 0);
        return result;
    }
}
