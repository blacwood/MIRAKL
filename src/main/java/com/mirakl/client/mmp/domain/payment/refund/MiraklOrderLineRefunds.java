/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.payment.refund;

import com.mirakl.client.domain.common.Unicity;

import java.util.ArrayList;
import java.util.List;

@Unicity(includeAll = true)
public class MiraklOrderLineRefunds {

    private List<MiraklOrderLineRefund> refunds = new ArrayList<MiraklOrderLineRefund>();

    public MiraklOrderLineRefunds(List<MiraklOrderLineRefund> refunds) {
        this.refunds = refunds;
    }

    public List<MiraklOrderLineRefund> getRefunds() {
        return refunds;
    }

    public void setRefunds(List<MiraklOrderLineRefund> refunds) {
        this.refunds = refunds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklOrderLineRefunds that = (MiraklOrderLineRefunds) o;

        return refunds != null ? refunds.equals(that.refunds) : that.refunds == null;

    }

    @Override
    public int hashCode() {
        return refunds != null ? refunds.hashCode() : 0;
    }
}
