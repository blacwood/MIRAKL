/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.front.domain.quote.get;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.domain.quote.MiraklQuoteRequestCustomer;
import com.mirakl.client.mmp.front.domain.quote.create.MiraklCreateQuotePaymentInfo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.util.Collections.unmodifiableList;

@Unicity(props= "id")
public class MiraklQuoteRequest {

    private String id;
    private Date dateCreated;
    private String channelCode;
    private String shippingZoneCode;
    private boolean taxesIncluded;

    private MiraklQuoteRequestCustomer customer;
    private MiraklQuoteInitialRequest initialRequest;
    private MiraklCreateQuotePaymentInfo paymentInfo;
    private List<MiraklShopQuoteRequest> shopQuoteRequests = new ArrayList<MiraklShopQuoteRequest>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public String getShippingZoneCode() {
        return shippingZoneCode;
    }

    public void setShippingZoneCode(String shippingZoneCode) {
        this.shippingZoneCode = shippingZoneCode;
    }

    public boolean isTaxesIncluded() {
        return taxesIncluded;
    }

    public void setTaxesIncluded(boolean taxesIncluded) {
        this.taxesIncluded = taxesIncluded;
    }

    public MiraklQuoteRequestCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(MiraklQuoteRequestCustomer customer) {
        this.customer = customer;
    }

    public MiraklQuoteInitialRequest getInitialRequest() {
        return initialRequest;
    }

    public void setInitialRequest(MiraklQuoteInitialRequest initialRequest) {
        this.initialRequest = initialRequest;
    }

    public MiraklCreateQuotePaymentInfo getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(MiraklCreateQuotePaymentInfo paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public List<MiraklShopQuoteRequest> getShopQuoteRequests() {
        return unmodifiableList(shopQuoteRequests);
    }

    public boolean addShopQuoteRequest(MiraklShopQuoteRequest shopQuoteRequest) {
        return shopQuoteRequests.add(shopQuoteRequest);
    }

    public boolean addAllShopQuoteRequests(List<MiraklShopQuoteRequest> shopQuoteRequests) {
        return this.shopQuoteRequests.addAll(shopQuoteRequests);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MiraklQuoteRequest that = (MiraklQuoteRequest) o;

        return id != null ? id.equals(that.id) : that.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
