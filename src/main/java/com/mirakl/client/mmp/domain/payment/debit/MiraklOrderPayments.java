/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.payment.debit;

import com.mirakl.client.domain.common.Unicity;

import java.util.List;

@Unicity(includeAll = true)
public class MiraklOrderPayments {

    private List<MiraklOrderPayment> orders;

    public MiraklOrderPayments(List<MiraklOrderPayment> orderPayments) {
        this.orders = orderPayments;
    }

    public List<MiraklOrderPayment> getOrders() {
        return orders;
    }

    public void setOrders(List<MiraklOrderPayment> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklOrderPayments that = (MiraklOrderPayments) o;

        return orders != null ? orders.equals(that.orders) : that.orders == null;

    }

    @Override
    public int hashCode() {
        return orders != null ? orders.hashCode() : 0;
    }
}
