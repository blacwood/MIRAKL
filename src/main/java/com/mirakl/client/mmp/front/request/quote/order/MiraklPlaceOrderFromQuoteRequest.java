/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.front.request.quote.order;

import com.mirakl.client.core.internal.MiraklApiEndpoint;
import com.mirakl.client.mmp.front.core.internal.MiraklFrontApiEndpoint;
import com.mirakl.client.mmp.front.domain.quote.order.MiraklOrderFromQuote;
import com.mirakl.client.request.AbstractMiraklApiRequest;

import java.util.Map;


public class MiraklPlaceOrderFromQuoteRequest extends AbstractMiraklApiRequest {

    private String quoteId;
    private MiraklOrderFromQuote order;

    public MiraklPlaceOrderFromQuoteRequest(String quoteId, MiraklOrderFromQuote order) {
        setQuoteId(quoteId);
        setOrder(order);
    }

    public String getQuoteId() {
        return quoteId;
    }

    /**
     * The id of the quote to place the order on
     */
    public void setQuoteId(String quoteId) {
        checkRequiredArgument(quoteId, "quoteId");
        this.quoteId = quoteId;
    }

    public MiraklOrderFromQuote getOrder() {
        return order;
    }

    /**
     * The order information
     */
    public void setOrder(MiraklOrderFromQuote order) {
        checkRequiredArgument(order, "order");
        this.order = order;
    }

    @Override
    public MiraklApiEndpoint getEndpoint() {
        return MiraklFrontApiEndpoint.Q07;
    }

    @Override
    public Map<String, String> getRequestTemplates() {
        Map<String, String> requestTemplates = super.getRequestTemplates();
        requestTemplates.put("quote_id", getQuoteId());
        return requestTemplates;
    }
}


