/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.shop;

import com.mirakl.client.domain.common.Unicity;

import java.util.Date;

/**
 * Transaction information about the shop : balances, subscription
 */
@Unicity(includeAll = true)
public class MiraklPaymentDetail extends AbstractMiraklPaymentDetail {

    /**
     * Indicate whether the shop should pay the plateform subscription fee defined by it's commission grid or not
     */
    private Boolean paySubscription;

    /**
     * Indicate whether the operator has blocked the payment on this shop in order to stop giving money back
     */
    private Boolean paymentBlocked;

    /**
     * Date from which the shop will be offered the subscription fee
     */
    private Date subscriptionFreeFrom;

    /**
     * Date from which the operator will stop offering the subscription fee to the shop
     */
    private Date subscriptionFreeTo;

    public Boolean getPaySubscription() {
        return paySubscription;
    }

    public void setPaySubscription(Boolean paySubscription) {
        this.paySubscription = paySubscription;
    }

    public Boolean getPaymentBlocked() {
        return paymentBlocked;
    }

    public void setPaymentBlocked(Boolean paymentBlocked) {
        this.paymentBlocked = paymentBlocked;
    }

    public Date getSubscriptionFreeFrom() {
        return subscriptionFreeFrom;
    }

    public void setSubscriptionFreeFrom(Date subscriptionFreeFrom) {
        this.subscriptionFreeFrom = subscriptionFreeFrom;
    }

    public Date getSubscriptionFreeTo() {
        return subscriptionFreeTo;
    }

    public void setSubscriptionFreeTo(Date subscriptionFreeTo) {
        this.subscriptionFreeTo = subscriptionFreeTo;
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

        MiraklPaymentDetail that = (MiraklPaymentDetail) o;

        if (paySubscription != null ? !paySubscription.equals(that.paySubscription) : that.paySubscription != null) {
            return false;
        }
        if (paymentBlocked != null ? !paymentBlocked.equals(that.paymentBlocked) : that.paymentBlocked != null) {
            return false;
        }
        if (subscriptionFreeFrom != null ? !subscriptionFreeFrom.equals(that.subscriptionFreeFrom) : that.subscriptionFreeFrom != null) {
            return false;
        }
        return subscriptionFreeTo != null ? subscriptionFreeTo.equals(that.subscriptionFreeTo) : that.subscriptionFreeTo == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (paySubscription != null ? paySubscription.hashCode() : 0);
        result = 31 * result + (paymentBlocked != null ? paymentBlocked.hashCode() : 0);
        result = 31 * result + (subscriptionFreeFrom != null ? subscriptionFreeFrom.hashCode() : 0);
        result = 31 * result + (subscriptionFreeTo != null ? subscriptionFreeTo.hashCode() : 0);
        return result;
    }
}
