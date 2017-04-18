/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.front.domain.payment;

import com.mirakl.client.domain.common.Unicity;
import org.codehaus.jackson.annotate.JsonProperty;

@Unicity(props = "paymentId")
public abstract class AbstractMiraklCreatePaymentInfo {

    @JsonProperty("imprint_number")
    private String paymentId;
    private String paymentType;

    public String getPaymentId() {
        return paymentId;
    }

    /**
     * Number to identify the payment associated to the order
     */
    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentType() {
        return paymentType;
    }

    /**
     * Payment type used for the order
     */
    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AbstractMiraklCreatePaymentInfo that = (AbstractMiraklCreatePaymentInfo) o;

        return paymentId != null ? paymentId.equals(that.paymentId) : that.paymentId == null;

    }

    @Override
    public int hashCode() {
        return paymentId != null ? paymentId.hashCode() : 0;
    }
}
