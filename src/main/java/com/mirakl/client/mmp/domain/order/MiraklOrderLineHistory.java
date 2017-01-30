/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.order;

import com.mirakl.client.domain.common.Unicity;

import java.util.Date;

@Unicity(includeAll = true)
public class MiraklOrderLineHistory {

    private Date createdDate;
    private Date lastUpdatedDate;
    private Date debitedDate;
    private Date shippedDate;
    private Date receivedDate;

    /**
     * Order line creation date
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    /**
     * Debited date of the order line
     */
    public Date getDebitedDate() {
        return debitedDate;
    }

    public void setDebitedDate(Date debitedDate) {
        this.debitedDate = debitedDate;
    }

    public Date getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }

    public Date getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(Date receivedDate) {
        this.receivedDate = receivedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklOrderLineHistory that = (MiraklOrderLineHistory) o;

        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) {
            return false;
        }
        if (lastUpdatedDate != null ? !lastUpdatedDate.equals(that.lastUpdatedDate) : that.lastUpdatedDate != null) {
            return false;
        }
        if (debitedDate != null ? !debitedDate.equals(that.debitedDate) : that.debitedDate != null) {
            return false;
        }
        if (shippedDate != null ? !shippedDate.equals(that.shippedDate) : that.shippedDate != null) {
            return false;
        }
        return receivedDate != null ? receivedDate.equals(that.receivedDate) : that.receivedDate == null;

    }

    @Override
    public int hashCode() {
        int result = createdDate != null ? createdDate.hashCode() : 0;
        result = 31 * result + (lastUpdatedDate != null ? lastUpdatedDate.hashCode() : 0);
        result = 31 * result + (debitedDate != null ? debitedDate.hashCode() : 0);
        result = 31 * result + (shippedDate != null ? shippedDate.hashCode() : 0);
        result = 31 * result + (receivedDate != null ? receivedDate.hashCode() : 0);
        return result;
    }
}
