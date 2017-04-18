/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.front.domain.order.create;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.domain.order.MiraklOrderCustomer;
import com.mirakl.client.mmp.domain.payment.MiraklPaymentWorkflow;
import com.mirakl.client.mmp.request.additionalfield.MiraklRequestAdditionalFieldValue;

import java.util.Collections;
import java.util.List;

@Unicity(includeAll = true)
public class MiraklCreateOrder {

    private String commercialId;
    private MiraklOrderCustomer customer;
    private List<MiraklCreateOrderOffer> offers;
    private MiraklCreateOrderPaymentInfo paymentInfo;
    private boolean scored;
    private String shippingZoneCode;
    private String channelCode;
    private List<MiraklRequestAdditionalFieldValue> orderAdditionalFields;
    private MiraklPaymentWorkflow paymentWorkflow;

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

    public MiraklOrderCustomer getCustomer() {
        return customer;
    }

    /**
     * Customer of the order
     */
    public void setCustomer(MiraklOrderCustomer customer) {
        this.customer = customer;
    }

    public List<MiraklCreateOrderOffer> getOffers() {
        return offers;
    }

    /**
     * List of offers of the commercial order
     */
    public void setOffers(List<MiraklCreateOrderOffer> offers) {
        this.offers = offers;
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

    public boolean getScored() {
        return scored;
    }

    /**
     * Is the customer is already scored or not?
     */
    public void setScored(boolean scored) {
        this.scored = scored;
    }

    public String getShippingZoneCode() {
        return shippingZoneCode;
    }

    /**
     * Shipping zone code of the commercial order
     */
    public void setShippingZoneCode(String shippingZoneCode) {
        this.shippingZoneCode = shippingZoneCode;
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

    public List<MiraklRequestAdditionalFieldValue> getOrderAdditionalFields() {
        return orderAdditionalFields == null ? null : Collections.unmodifiableList(orderAdditionalFields);
    }

    /**
     * Custom fields of the commercial order
     */
    public void setOrderAdditionalFields(List<MiraklRequestAdditionalFieldValue> orderAdditionalFields) {
        this.orderAdditionalFields = orderAdditionalFields;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklCreateOrder that = (MiraklCreateOrder) o;

        if (scored != that.scored) {
            return false;
        }
        if (commercialId != null ? !commercialId.equals(that.commercialId) : that.commercialId != null) {
            return false;
        }
        if (customer != null ? !customer.equals(that.customer) : that.customer != null) {
            return false;
        }
        if (offers != null ? !offers.equals(that.offers) : that.offers != null) {
            return false;
        }
        if (paymentInfo != null ? !paymentInfo.equals(that.paymentInfo) : that.paymentInfo != null) {
            return false;
        }
        if (shippingZoneCode != null ? !shippingZoneCode.equals(that.shippingZoneCode) : that.shippingZoneCode != null) {
            return false;
        }
        if (channelCode != null ? !channelCode.equals(that.channelCode) : that.channelCode != null) {
            return false;
        }
        return orderAdditionalFields != null ? orderAdditionalFields.equals(that.orderAdditionalFields) : that.orderAdditionalFields == null;

    }

    @Override
    public int hashCode() {
        int result = commercialId != null ? commercialId.hashCode() : 0;
        result = 31 * result + (customer != null ? customer.hashCode() : 0);
        result = 31 * result + (offers != null ? offers.hashCode() : 0);
        result = 31 * result + (paymentInfo != null ? paymentInfo.hashCode() : 0);
        result = 31 * result + (scored ? 1 : 0);
        result = 31 * result + (shippingZoneCode != null ? shippingZoneCode.hashCode() : 0);
        result = 31 * result + (channelCode != null ? channelCode.hashCode() : 0);
        result = 31 * result + (orderAdditionalFields != null ? orderAdditionalFields.hashCode() : 0);
        return result;
    }
}
