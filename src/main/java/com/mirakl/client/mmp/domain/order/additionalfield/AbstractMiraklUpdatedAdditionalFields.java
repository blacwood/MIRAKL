/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.order.additionalfield;

import com.mirakl.client.domain.common.Unicity;

@Unicity(includeAll = true)
public abstract class AbstractMiraklUpdatedAdditionalFields<RESULT extends AbstractMiraklUpdateAdditionalFields, ERRORS extends AbstractMiraklUpdatedAdditionalFieldsWithErrors> {

    private RESULT orderUpdateResult;
    private ERRORS orderUpdateErrors;

    public RESULT getOrderUpdateResult() {
        return orderUpdateResult;
    }

    public void setOrderUpdateResult(RESULT orderUpdateResult) {
        this.orderUpdateResult = orderUpdateResult;
    }

    public ERRORS getOrderUpdateErrors() {
        return orderUpdateErrors;
    }

    public void setOrderUpdateErrors(ERRORS orderUpdateErrors) {
        this.orderUpdateErrors = orderUpdateErrors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractMiraklUpdatedAdditionalFields that = (AbstractMiraklUpdatedAdditionalFields) o;

        if (orderUpdateResult != null ? !orderUpdateResult.equals(that.orderUpdateResult) : that.orderUpdateResult != null)
            return false;
        return orderUpdateErrors != null ? orderUpdateErrors.equals(that.orderUpdateErrors) : that.orderUpdateErrors == null;

    }

    @Override
    public int hashCode() {
        int result = orderUpdateResult != null ? orderUpdateResult.hashCode() : 0;
        result = 31 * result + (orderUpdateErrors != null ? orderUpdateErrors.hashCode() : 0);
        return result;
    }
}
