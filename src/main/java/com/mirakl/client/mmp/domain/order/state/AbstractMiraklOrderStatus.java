/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.order.state;


import com.mirakl.client.domain.common.Unicity;

@Unicity(includeAll = true)
public abstract class AbstractMiraklOrderStatus {

    private State state;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public static enum State {
        /**
         * Initial order state.
         */
        STAGING,

        /**
         * Order has been validated by Acme and wait for shop input.
         */
        WAITING_ACCEPTANCE,

        /**
         * Shop has accepted order.
         */
        WAITING_DEBIT,

        /**
         * Mirakl asked the front operator sytem to debit the customer account.
         */
        WAITING_DEBIT_PAYMENT,

        /**
         * The order has been paid by the customer and is waiting for a shop input.
         */
        SHIPPING,

        /**
         * The order has been sent by the shop.
         */
        SHIPPED,

        /**
         * The order is available for collection in the operator shop by the customer.
         */
        TO_COLLECT,

        /**
         * The order has been received by the customer.
         */
        RECEIVED,

        /**
         * The order is closed.
         */
        CLOSED,

        /**
         * Shop has refused the order.
         */
        REFUSED,

        /**
         * The Order has been canceled.
         */
        CANCELED,

        /**
         * An incident on the order line has been opened.
         */
        INCIDENT_OPEN,

        /**
         * An incident on the order line has been closed. (used only with the order history)
         */
        INCIDENT_CLOSED,

        /**
         * A Refund has been opened on the order line.
         */
        @Deprecated
        WAITING_REFUND,

        /**
         * Mirakl asked the front operator system to credit the customer account with the refund amount
         */
        @Deprecated
        WAITING_REFUND_PAYMENT,

        /**
         * The order line has been refunded.
         */
        REFUNDED
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AbstractMiraklOrderStatus that = (AbstractMiraklOrderStatus) o;

        return state == that.state;

    }

    @Override
    public int hashCode() {
        return state != null ? state.hashCode() : 0;
    }
}
