/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.order;

import com.mirakl.client.core.internal.mapper.BigDecimalRateDeserializer;
import com.mirakl.client.domain.common.Unicity;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import java.math.BigDecimal;

@Unicity(includeAll = true)
public class MiraklOrderLineCommissionTax extends MiraklCommissionTax {

    @JsonDeserialize(using = BigDecimalRateDeserializer.class)
    private BigDecimal rate;

    /**
     * The rate of the tax, as a percentage (between 0 and 100).
     */
    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        MiraklOrderLineCommissionTax that = (MiraklOrderLineCommissionTax) o;

        return rate != null ? rate.equals(that.rate) : that.rate == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (rate != null ? rate.hashCode() : 0);
        return result;
    }
}
