/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.front.domain.order.create;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.domain.order.MiraklOrder;

import java.util.List;

@Unicity(includeAll = true)
public class MiraklCreatedOrders {

    private List<MiraklOfferNotShippable> offersNotShippable;
    private List<MiraklOrder> orders;

    /**
     * List of offers not shippable
     */
    public List<MiraklOfferNotShippable> getOffersNotShippable() {
        return offersNotShippable;
    }

    public void setOffersNotShippable(List<MiraklOfferNotShippable> offersNotShippable) {
        this.offersNotShippable = offersNotShippable;
    }

    /**
     * List of orders created
     */
    public List<MiraklOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<MiraklOrder> orders) {
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

        MiraklCreatedOrders that = (MiraklCreatedOrders) o;

        if (offersNotShippable != null ? !offersNotShippable.equals(that.offersNotShippable) : that.offersNotShippable != null) {
            return false;
        }
        return orders != null ? orders.equals(that.orders) : that.orders == null;

    }

    @Override
    public int hashCode() {
        int result = offersNotShippable != null ? offersNotShippable.hashCode() : 0;
        result = 31 * result + (orders != null ? orders.hashCode() : 0);
        return result;
    }
}
