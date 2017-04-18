/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.front.domain.quote.order;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.domain.common.MiraklAdditionalFieldValue;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;

@Unicity(includeAll = true)
public class MiraklQuoteOrderLine {

    private Integer leadtimeToShip;
    private String orderLineId;
    private String quoteLineId;
    private List<MiraklAdditionalFieldValue> orderLineAdditionalFields = new ArrayList<MiraklAdditionalFieldValue>();

    public Integer getLeadtimeToShip() {
        return leadtimeToShip;
    }

    public void setLeadtimeToShip(Integer leadtimeToShip) {
        this.leadtimeToShip = leadtimeToShip;
    }

    public String getOrderLineId() {
        return orderLineId;
    }

    public void setOrderLineId(String orderLineId) {
        this.orderLineId = orderLineId;
    }

    public String getQuoteLineId() {
        return quoteLineId;
    }

    public void setQuoteLineId(String quoteLineId) {
        this.quoteLineId = quoteLineId;
    }

    public List<MiraklAdditionalFieldValue> getOrderLineAdditionalFields() {
        return unmodifiableList(orderLineAdditionalFields);
    }

    public boolean addAllOrderLineAdditionalFields(List<MiraklAdditionalFieldValue> orderLineAdditionalFields) {
        return this.orderLineAdditionalFields.addAll(orderLineAdditionalFields);
    }

    public boolean addOrderLineAdditionalField(MiraklAdditionalFieldValue orderLineAdditionalField) {
        return this.orderLineAdditionalFields.add(orderLineAdditionalField);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklQuoteOrderLine that = (MiraklQuoteOrderLine) o;

        if (leadtimeToShip != null ? !leadtimeToShip.equals(that.leadtimeToShip) : that.leadtimeToShip != null) {
            return false;
        }
        if (orderLineId != null ? !orderLineId.equals(that.orderLineId) : that.orderLineId != null) {
            return false;
        }
        if (quoteLineId != null ? !quoteLineId.equals(that.quoteLineId) : that.quoteLineId != null) {
            return false;
        }
        return orderLineAdditionalFields != null ? orderLineAdditionalFields.equals(that.orderLineAdditionalFields) : that.orderLineAdditionalFields == null;

    }

    @Override
    public int hashCode() {
        int result = leadtimeToShip != null ? leadtimeToShip.hashCode() : 0;
        result = 31 * result + (orderLineId != null ? orderLineId.hashCode() : 0);
        result = 31 * result + (quoteLineId != null ? quoteLineId.hashCode() : 0);
        result = 31 * result + (orderLineAdditionalFields != null ? orderLineAdditionalFields.hashCode() : 0);
        return result;
    }
}
