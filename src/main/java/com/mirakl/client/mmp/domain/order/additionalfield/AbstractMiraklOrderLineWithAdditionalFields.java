/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.order.additionalfield;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.domain.common.MiraklAdditionalFieldValue;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.Collections;
import java.util.List;

@Unicity(includeAll = true)
public abstract class AbstractMiraklOrderLineWithAdditionalFields {

    @JsonProperty("order_line_id")
    private String orderLineId;

    @JsonProperty("order_line_additional_fields")
    private List<MiraklAdditionalFieldValue> additionalFields;

    public String getOrderLineId() {
        return orderLineId;
    }

    public void setOrderLineId(String orderLineId) {
        this.orderLineId = orderLineId;
    }

    public List<MiraklAdditionalFieldValue> getAdditionalFields() {
        return additionalFields == null ? null : Collections.unmodifiableList(additionalFields);
    }

    public void setAdditionalFields(List<MiraklAdditionalFieldValue> additionalFields) {
        this.additionalFields = additionalFields;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractMiraklOrderLineWithAdditionalFields that = (AbstractMiraklOrderLineWithAdditionalFields) o;

        if (orderLineId != null ? !orderLineId.equals(that.orderLineId) : that.orderLineId != null) return false;
        return additionalFields != null ? additionalFields.equals(that.additionalFields) : that.additionalFields == null;

    }

    @Override
    public int hashCode() {
        int result = orderLineId != null ? orderLineId.hashCode() : 0;
        result = 31 * result + (additionalFields != null ? additionalFields.hashCode() : 0);
        return result;
    }
}
