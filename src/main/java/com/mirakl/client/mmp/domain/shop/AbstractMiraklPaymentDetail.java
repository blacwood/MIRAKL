/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.shop;

import com.mirakl.client.domain.common.Unicity;

import java.math.BigDecimal;

/**
 * Transaction information about the shop : balances, subscription
 */
@Unicity(includeAll = true)
public abstract class AbstractMiraklPaymentDetail {

    /**
     * The total amount of the orders (minus commissions) in the shipping process
     * Once received, an order will see it's amount goes in the payable balance
     */
    private BigDecimal pendingBalance;

    /**
     * Total amount of the orders (minus commissions) received by the customers
     * This amount will be the one used by the next payment process
     */
    private BigDecimal payableBalance;

    /**
     * Total amount of the orders received by the customers and paid back to the shop
     */
    private BigDecimal paidBalance;

    public BigDecimal getPendingBalance() {
        return pendingBalance;
    }

    public void setPendingBalance(BigDecimal pendingBalance) {
        this.pendingBalance = pendingBalance;
    }

    public BigDecimal getPayableBalance() {
        return payableBalance;
    }

    public void setPayableBalance(BigDecimal payableBalance) {
        this.payableBalance = payableBalance;
    }

    public BigDecimal getPaidBalance() {
        return paidBalance;
    }

    public void setPaidBalance(BigDecimal paidBalance) {
        this.paidBalance = paidBalance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AbstractMiraklPaymentDetail that = (AbstractMiraklPaymentDetail) o;

        if (pendingBalance != null ? !pendingBalance.equals(that.pendingBalance) : that.pendingBalance != null) {
            return false;
        }
        if (payableBalance != null ? !payableBalance.equals(that.payableBalance) : that.payableBalance != null) {
            return false;
        }
        return paidBalance != null ? paidBalance.equals(that.paidBalance) : that.paidBalance == null;

    }

    @Override
    public int hashCode() {
        int result = pendingBalance != null ? pendingBalance.hashCode() : 0;
        result = 31 * result + (payableBalance != null ? payableBalance.hashCode() : 0);
        result = 31 * result + (paidBalance != null ? paidBalance.hashCode() : 0);
        return result;
    }
}
