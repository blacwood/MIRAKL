/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.front.domain.quote.order;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.domain.common.MiraklAdditionalFieldValue;
import com.mirakl.client.mmp.domain.payment.MiraklPaymentWorkflow;
import com.mirakl.client.mmp.front.domain.order.create.MiraklCreateOrderPaymentInfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.*;

@Unicity (includeAll = true)
public class MiraklOrderFromQuote {
    private String channelCode;
    private String commercialId;
    private List<MiraklQuoteOrderLine> lines = new ArrayList<MiraklQuoteOrderLine>();
    private List<MiraklAdditionalFieldValue> orderAdditionalFields = new ArrayList<MiraklAdditionalFieldValue>();
    private MiraklCreateOrderPaymentInfo paymentInfo;
    private MiraklPaymentWorkflow paymentWorkflow;
    private boolean scored;

    public String getCommercialId() {
        return commercialId;
    }

    /**
     * Commercial ID of the order
     * Must be a composition of alphanumeric characters, hyphen and underscore
     */
    public void setCommercialId(String commercialId) {
        this.commercialId = commercialId;
    }

    public String getChannelCode() {
        return channelCode;
    }

    /**
     * Channel code of the commercial order
     */
    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public List<MiraklQuoteOrderLine> getLines() {
        return unmodifiableList(lines);
    }

    /**
     * List of offers to place the order on. This list is optional and useful only to override
     * default offer parameters
     */
    public boolean addAllLines(List<MiraklQuoteOrderLine> lines) {
        return this.lines.addAll(lines);
    }

    public boolean addLine(MiraklQuoteOrderLine lines) {
        return this.lines.add(lines);
    }

    public List<MiraklAdditionalFieldValue> getOrderAdditionalFields() {
        return unmodifiableList(orderAdditionalFields);
    }

    /**
     * Custom fields of the commercial order
     */
    public boolean addAllOrderAdditionalFields(List<MiraklAdditionalFieldValue> orderAdditionalFields) {
        return this.orderAdditionalFields.addAll(orderAdditionalFields);
    }

    public boolean addOrderAdditionalField(MiraklAdditionalFieldValue orderAdditionalField) {
        return this.orderAdditionalFields.add(orderAdditionalField);
    }

    public MiraklCreateOrderPaymentInfo getPaymentInfo() {
        return paymentInfo;
    }

    /**
     * Payment information of the commercial order
     */
    public void setPaymentInfo(MiraklCreateOrderPaymentInfo paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public MiraklPaymentWorkflow getPaymentWorkflow() {
        return paymentWorkflow;
    }

    /**
     * Payment workflow followed by the commercial order
     */
    public void setPaymentWorkflow(MiraklPaymentWorkflow paymentWorkflow) {
        this.paymentWorkflow = paymentWorkflow;
    }

    public boolean isScored() {
        return scored;
    }

    /**
     * Is the customer is already scored or not?
     */
    public void setScored(boolean scored) {
        this.scored = scored;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MiraklOrderFromQuote that = (MiraklOrderFromQuote) o;

        if (scored != that.scored) return false;
        if (channelCode != null ? !channelCode.equals(that.channelCode) : that.channelCode != null) return false;
        if (commercialId != null ? !commercialId.equals(that.commercialId) : that.commercialId != null) return false;
        if (lines != null ? !lines.equals(that.lines) : that.lines != null) return false;
        if (orderAdditionalFields != null ? !orderAdditionalFields.equals(that.orderAdditionalFields) : that.orderAdditionalFields != null)
            return false;
        if (paymentInfo != null ? !paymentInfo.equals(that.paymentInfo) : that.paymentInfo != null) return false;
        return paymentWorkflow == that.paymentWorkflow;

    }

    @Override
    public int hashCode() {
        int result = channelCode != null ? channelCode.hashCode() : 0;
        result = 31 * result + (commercialId != null ? commercialId.hashCode() : 0);
        result = 31 * result + (lines != null ? lines.hashCode() : 0);
        result = 31 * result + (orderAdditionalFields != null ? orderAdditionalFields.hashCode() : 0);
        result = 31 * result + (paymentInfo != null ? paymentInfo.hashCode() : 0);
        result = 31 * result + (paymentWorkflow != null ? paymentWorkflow.hashCode() : 0);
        result = 31 * result + (scored ? 1 : 0);
        return result;
    }
}
