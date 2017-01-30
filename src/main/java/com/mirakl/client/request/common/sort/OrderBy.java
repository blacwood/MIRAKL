/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.request.common.sort;

import com.mirakl.client.domain.common.Unicity;

@Unicity(includeAll = true)
public class OrderBy<T extends Sort> {

    private T sort;
    private Order order;

    /**
     * Constructor used internally by the framework, should not be called explicitly
     */
    public OrderBy(T sort, Order order) {
        this.sort = sort;
        this.order = order;
    }

    public T getSort() {
        return sort;
    }

    public void setSort(T sort) {
        this.sort = sort;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public static enum Order {

        ASC, DESC;

        public String getValue() {
            return this.name().toLowerCase();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        OrderBy<?> orderBy = (OrderBy<?>) o;

        if (sort != null ? !sort.equals(orderBy.sort) : orderBy.sort != null) {
            return false;
        }
        return order == orderBy.order;

    }

    @Override
    public int hashCode() {
        int result = sort != null ? sort.hashCode() : 0;
        result = 31 * result + (order != null ? order.hashCode() : 0);
        return result;
    }
}
