/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.order;

import com.mirakl.client.core.internal.mapper.BigDecimalRateDeserializer;
import com.mirakl.client.domain.common.Unicity;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Unicity(includeAll = true)
public class MiraklOrderLineCommission {

    @JsonProperty("commission_fee")
    private BigDecimal fee;

    @JsonProperty("commission_rate_vat")
    @JsonDeserialize(using = BigDecimalRateDeserializer.class)
    private BigDecimal taxRate;

    @JsonProperty("commission_vat")
    private BigDecimal tax;

    @JsonProperty("total_commission")
    private BigDecimal total;

    private List<MiraklOrderLineCommissionTax> commissionTaxes = new ArrayList<MiraklOrderLineCommissionTax>();

    /**
     * Commission fee of the order line.
     */
    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    /**
     * Rate of the commission vat applied for the order line.
     * @deprecated Please use {@link #getCommissionTaxes()} instead. If multi-taxes are applied to
     * this order, this field will return the amount of the first tax applied.
     */
    @Deprecated
    public BigDecimal getTaxRate() {
        return taxRate;
    }

    /**
     * @deprecated Please use {@link #addCommissionTax(MiraklOrderLineCommissionTax)} instead.
     */
    @Deprecated
    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    /**
     * Commission tax of the order line.
     * @deprecated Please use {@link #getCommissionTaxes()} instead. If multi-taxes are applied to
     * this order, this field will return the amount of the first tax applied.
     */
    @Deprecated
    public BigDecimal getTax() {
        return tax;
    }

    /**
     * @deprecated Please use {@link #addCommissionTax(MiraklOrderLineCommissionTax)} instead.
     */
    @Deprecated
    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    /**
     * Total commission of the order line (sum of the commission fee and the commission vat)
     */
    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    /**
     * List of taxes applied on the commission
     */
    public List<MiraklOrderLineCommissionTax> getCommissionTaxes() {
        return Collections.unmodifiableList(commissionTaxes);
    }

    public void addCommissionTax(MiraklOrderLineCommissionTax commissionTax) {
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

        MiraklOrderLineCommission that = (MiraklOrderLineCommission) o;

        if (fee != null ? !fee.equals(that.fee) : that.fee != null) {
            return false;
        }
        if (taxRate != null ? !taxRate.equals(that.taxRate) : that.taxRate != null) {
            return false;
        }
        if (tax != null ? !tax.equals(that.tax) : that.tax != null) {
            return false;
        }
        if (total != null ? !total.equals(that.total) : that.total != null) {
            return false;
        }
        return commissionTaxes != null ? commissionTaxes.equals(that.commissionTaxes) : that.commissionTaxes == null;

    }

    @Override
    public int hashCode() {
        int result = fee != null ? fee.hashCode() : 0;
        result = 31 * result + (taxRate != null ? taxRate.hashCode() : 0);
        result = 31 * result + (tax != null ? tax.hashCode() : 0);
        result = 31 * result + (total != null ? total.hashCode() : 0);
        result = 31 * result + (commissionTaxes != null ? commissionTaxes.hashCode() : 0);
        return result;
    }
}
