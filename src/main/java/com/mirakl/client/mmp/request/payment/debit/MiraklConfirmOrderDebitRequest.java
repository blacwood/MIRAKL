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
import com.mirakl.client.mmp.domain.payment.debit.MiraklOrderPayment;
import com.mirakl.client.request.AbstractMiraklApiRequest;

import java.util.List;

@Unicity(includeAll = true)
public class MiraklConfirmOrderDebitRequest extends AbstractMiraklApiRequest {

    private List<MiraklOrderPayment> orderPayments;

    public MiraklConfirmOrderDebitRequest(List<MiraklOrderPayment> orderPayments) {
        this.orderPayments = orderPayments;
    }

    public List<MiraklOrderPayment> getOrderPayments() {
        return orderPayments;
    }

    public void setOrderPayments(List<MiraklOrderPayment> orderPayments) {
        checkRequiredArgument(orderPayments, "orderPayments");
        this.orderPayments = orderPayments;
    }

    @Override
    public MiraklApiEndpoint getEndpoint() {
        return MiraklFrontOperatorApiEndpoint.PA01;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklConfirmOrderDebitRequest that = (MiraklConfirmOrderDebitRequest) o;

        return orderPayments != null ? orderPayments.equals(that.orderPayments) : that.orderPayments == null;

    }

    @Override
    public int hashCode() {
        return orderPayments != null ? orderPayments.hashCode() : 0;
    }
}
