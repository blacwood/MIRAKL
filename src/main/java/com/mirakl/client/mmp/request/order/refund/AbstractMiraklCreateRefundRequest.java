/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.request.order.refund;

import com.mirakl.client.core.internal.MiraklApiEndpoint;
import com.mirakl.client.core.internal.MiraklOperatorShopApiEndpoint;
import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.domain.order.refund.MiraklCreateRefund;
import com.mirakl.client.request.AbstractMiraklApiRequest;

import java.util.List;

@Unicity(includeAll = true)
public abstract class AbstractMiraklCreateRefundRequest extends AbstractMiraklApiRequest {

    private List<MiraklCreateRefund> refunds;

    public AbstractMiraklCreateRefundRequest(List<MiraklCreateRefund> refunds) {
        setRefunds(refunds);
    }

    @Override
    public MiraklApiEndpoint getEndpoint() {
        return MiraklOperatorShopApiEndpoint.OR28;
    }

    public List<MiraklCreateRefund> getRefunds() {
        return refunds;
    }

    /**
     * The list of order lines which will be refunded
     */
    public void setRefunds(List<MiraklCreateRefund> refunds) {
        checkRequiredArgument(refunds, "refunds");
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
        if (!super.equals(o)) {
            return false;
        }

        AbstractMiraklCreateRefundRequest that = (AbstractMiraklCreateRefundRequest) o;

        return refunds != null ? refunds.equals(that.refunds) : that.refunds == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (refunds != null ? refunds.hashCode() : 0);
        return result;
    }
}
