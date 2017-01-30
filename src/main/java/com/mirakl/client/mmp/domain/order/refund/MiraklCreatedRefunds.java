/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.order.refund;

import com.mirakl.client.domain.common.Unicity;

import java.util.List;

@Unicity(includeAll = true)
public class MiraklCreatedRefunds {

    private List<MiraklRefundCreated> refunds;

    public List<MiraklRefundCreated> getRefunds() {
        return refunds;
    }

    public void setRefunds(List<MiraklRefundCreated> refunds) {
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

        MiraklCreatedRefunds that = (MiraklCreatedRefunds) o;

        return refunds != null ? refunds.equals(that.refunds) : that.refunds == null;

    }

    @Override
    public int hashCode() {
        return refunds != null ? refunds.hashCode() : 0;
    }
}
