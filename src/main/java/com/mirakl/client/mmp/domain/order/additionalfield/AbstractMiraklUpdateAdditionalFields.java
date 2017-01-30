/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.order.additionalfield;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.domain.common.MiraklAdditionalFieldValue;

import java.util.Collections;
import java.util.List;

@Unicity(includeAll = true)
public abstract class AbstractMiraklUpdateAdditionalFields<ORDERLINE extends AbstractMiraklOrderLineWithAdditionalFields> {
    private List<MiraklAdditionalFieldValue> orderAdditionalFields;
    private List<ORDERLINE> orderLines;

    public List<MiraklAdditionalFieldValue> getOrderAdditionalFields() {
        return orderAdditionalFields == null ? null : Collections.unmodifiableList(orderAdditionalFields);
    }

    /**
     * Custom fields of the commercial order
     */
    public void setOrderAdditionalFields(List<MiraklAdditionalFieldValue> orderAdditionalFields) {
        this.orderAdditionalFields = orderAdditionalFields;
    }

    public List<ORDERLINE> getOrderLines() {
        return orderLines == null ? null : Collections.unmodifiableList(orderLines);
    }

    public void setOrderLines(List<ORDERLINE> orderLines) {
        this.orderLines = orderLines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractMiraklUpdateAdditionalFields that = (AbstractMiraklUpdateAdditionalFields) o;

        if (orderAdditionalFields != null ? !orderAdditionalFields.equals(that.orderAdditionalFields) : that.orderAdditionalFields != null)
            return false;
        return orderLines != null ? orderLines.equals(that.orderLines) : that.orderLines == null;

    }

    @Override
    public int hashCode() {
        int result = orderAdditionalFields != null ? orderAdditionalFields.hashCode() : 0;
        result = 31 * result + (orderLines != null ? orderLines.hashCode() : 0);
        return result;
    }
}
