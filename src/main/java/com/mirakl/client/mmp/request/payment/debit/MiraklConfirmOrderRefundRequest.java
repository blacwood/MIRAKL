/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.request.payment.debit;

import com.mirakl.client.core.internal.MiraklApiEndpoint;
import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.core.internal.MiraklFrontOperatorApiEndpoint;
import com.mirakl.client.mmp.domain.payment.refund.MiraklOrderLineRefund;
import com.mirakl.client.request.AbstractMiraklApiRequest;

import java.util.List;

@Unicity(includeAll = true)
public class MiraklConfirmOrderRefundRequest extends AbstractMiraklApiRequest {

    private List<MiraklOrderLineRefund> refunds;

    public MiraklConfirmOrderRefundRequest(List<MiraklOrderLineRefund> refunds) {
        setRefunds(refunds);
    }

    @Override
    public MiraklApiEndpoint getEndpoint() {
        return MiraklFrontOperatorApiEndpoint.PA02;
    }

    public List<MiraklOrderLineRefund> getRefunds() {
        return refunds;
    }

    public void setRefunds(List<MiraklOrderLineRefund> refunds) {
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

        MiraklConfirmOrderRefundRequest that = (MiraklConfirmOrderRefundRequest) o;

        return refunds != null ? refunds.equals(that.refunds) : that.refunds == null;

    }

    @Override
    public int hashCode() {
        return refunds != null ? refunds.hashCode() : 0;
    }
}
