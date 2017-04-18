/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.front.domain.shipping;

import com.mirakl.client.domain.common.Unicity;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties("total_count")
@Unicity(includeAll = true)
public class MiraklOrderShippingFees {

    private List<MiraklOrderShippingFeeError> errors = new ArrayList<MiraklOrderShippingFeeError>();

    private List<MiraklOrderShippingFee> orders = new ArrayList<MiraklOrderShippingFee>();

    /**
     * List of offers in error. It can be because offers are not found, are not available to shipping for the
     * provided shipping type nor shipping zone
     */
    public List<MiraklOrderShippingFeeError> getErrors() {
        return errors;
    }

    public void setErrors(List<MiraklOrderShippingFeeError> errors) {
        this.errors = errors;
    }

    /**
     * Shipping fees information group by logistic order
     */
    public List<MiraklOrderShippingFee> getOrders() {
        return orders;
    }

    public void setOrders(List<MiraklOrderShippingFee> orders) {
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

        MiraklOrderShippingFees that = (MiraklOrderShippingFees) o;

        if (errors != null ? !errors.equals(that.errors) : that.errors != null) {
            return false;
        }
        return orders != null ? orders.equals(that.orders) : that.orders == null;

    }

    @Override
    public int hashCode() {
        int result = errors != null ? errors.hashCode() : 0;
        result = 31 * result + (orders != null ? orders.hashCode() : 0);
        return result;
    }
}
