/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.front.domain.quote.get;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.domain.common.currency.MiraklIsoCurrencyCode;
import com.mirakl.client.mmp.front.domain.quote.message.MiraklQuoteRequestMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.*;

@Unicity(props= "id")
public class MiraklShopQuoteRequest {

    private String id;

    private Integer shopId;
    private MiraklIsoCurrencyCode currencyIsoCode;
    private MiraklShopQuoteRequestState state;

    private List<MiraklQuoteRequestMessage> messages = new ArrayList<MiraklQuoteRequestMessage>();
    private List<MiraklQuote> quotes = new ArrayList<MiraklQuote>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public MiraklIsoCurrencyCode getCurrencyIsoCode() {
        return currencyIsoCode;
    }

    public void setCurrencyIsoCode(MiraklIsoCurrencyCode currencyIsoCode) {
        this.currencyIsoCode = currencyIsoCode;
    }

    public MiraklShopQuoteRequestState getState() {
        return state;
    }

    public void setState(MiraklShopQuoteRequestState state) {
        this.state = state;
    }

    public List<MiraklQuoteRequestMessage> getMessages() {
        return unmodifiableList(messages);
    }

    public void setMessages(List<MiraklQuoteRequestMessage> messages) {
        this.messages.addAll(messages);
    }

    public List<MiraklQuote> getQuotes() {
        return unmodifiableList(quotes);
    }

    public void setQuotes(List<MiraklQuote> quotes) {
        this.quotes.addAll(quotes);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MiraklShopQuoteRequest that = (MiraklShopQuoteRequest) o;

        return id != null ? id.equals(that.id) : that.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
