/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.order.tax;

import com.mirakl.client.domain.common.Unicity;

import java.math.BigDecimal;

@Unicity(includeAll = true)
public class MiraklOrderTaxAmount {

    private BigDecimal amount;
    private String code;

    public MiraklOrderTaxAmount() {
    }

    public MiraklOrderTaxAmount(BigDecimal amount, String code) {
        this.amount = amount;
        this.code = code;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * The tax amount
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCode() {
        return code;
    }

    /**
     * The tax code
     */
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklOrderTaxAmount that = (MiraklOrderTaxAmount) o;

        if (amount != null ? !amount.equals(that.amount) : that.amount != null) {
            return false;
        }
        return code != null ? code.equals(that.code) : that.code == null;

    }

    @Override
    public int hashCode() {
        int result = amount != null ? amount.hashCode() : 0;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        return result;
    }
}
