/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.invoice;

import com.mirakl.client.domain.common.Unicity;

import java.util.List;

@Unicity(includeAll = true)
public class MiraklInvoices {

    private List<MiraklInvoice> invoices;
    private long totalCount;

    public List<MiraklInvoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<MiraklInvoice> invoices) {
        this.invoices = invoices;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklInvoices that = (MiraklInvoices) o;

        if (totalCount != that.totalCount) {
            return false;
        }
        return invoices != null ? invoices.equals(that.invoices) : that.invoices == null;

    }

    @Override
    public int hashCode() {
        int result = invoices != null ? invoices.hashCode() : 0;
        result = 31 * result + (int) (totalCount ^ (totalCount >>> 32));
        return result;
    }
}
