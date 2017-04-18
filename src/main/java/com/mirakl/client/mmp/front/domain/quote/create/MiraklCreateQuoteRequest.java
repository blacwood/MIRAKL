/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.front.domain.quote.create;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.domain.common.currency.MiraklIsoCurrencyCode;
import com.mirakl.client.mmp.domain.quote.MiraklQuoteRequestCustomer;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;

@Unicity(props = "id")
public class MiraklCreateQuoteRequest {

    private String id;
    private boolean scored;
    private MiraklQuoteRequestCustomer customer;
    private List<MiraklQuoteOffer> offers = new ArrayList<MiraklQuoteOffer>();
    private String body;
    private String subject;
    private List<MiraklShopQuoteRequestCreateDocument> documents = new ArrayList<MiraklShopQuoteRequestCreateDocument>();
    private String shippingZoneCode;
    private String channelCode;
    private boolean taxesIncluded;
    private MiraklCreateQuotePaymentInfo paymentInfo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isScored() {
        return scored;
    }

    public void setScored(boolean scored) {
        this.scored = scored;
    }

    public MiraklQuoteRequestCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(MiraklQuoteRequestCustomer customer) {
        this.customer = customer;
    }

    public List<MiraklQuoteOffer> getOffers() {
        return unmodifiableList(offers);
    }

    public boolean addAllOffers(List<MiraklQuoteOffer> offers) {
        return this.offers.addAll(offers);
    }

    public boolean addOffer(MiraklQuoteOffer offer) {
        return this.offers.add(offer);
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public List<MiraklShopQuoteRequestCreateDocument> getDocuments() {
        return unmodifiableList(documents);
    }

    public boolean addDocument(MiraklShopQuoteRequestCreateDocument document) {
        return documents.add(document);
    }

    public boolean addAllDocuments(List<MiraklShopQuoteRequestCreateDocument> documents) {
        return this.documents.addAll(documents);
    }

    public String getShippingZoneCode() {
        return shippingZoneCode;
    }

    public void setShippingZoneCode(String shippingZoneCode) {
        this.shippingZoneCode = shippingZoneCode;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public boolean isTaxesIncluded() {
        return taxesIncluded;
    }

    public void setTaxesIncluded(boolean taxesIncluded) {
        this.taxesIncluded = taxesIncluded;
    }

    public MiraklCreateQuotePaymentInfo getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(MiraklCreateQuotePaymentInfo paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklCreateQuoteRequest that = (MiraklCreateQuoteRequest) o;

        return id.equals(that.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
