/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.front.domain.quote.order;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.domain.order.MiraklOrder;

import java.util.Collections;
import java.util.List;

@Unicity(includeAll = true)
public class MiraklOrdersFromQuote {

    private List<MiraklOrder> orders;

    public List<MiraklOrder> getOrders() {
        return Collections.unmodifiableList(orders);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MiraklOrdersFromQuote that = (MiraklOrdersFromQuote) o;

        return orders != null ? orders.equals(that.orders) : that.orders == null;

    }

    @Override
    public int hashCode() {
        return orders != null ? orders.hashCode() : 0;
    }
}
