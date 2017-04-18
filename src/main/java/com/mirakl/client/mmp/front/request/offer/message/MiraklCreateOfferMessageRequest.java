/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.front.request.offer.message;

import com.mirakl.client.core.internal.MiraklApiEndpoint;
import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.front.core.internal.MiraklFrontApiEndpoint;
import com.mirakl.client.request.AbstractMiraklApiRequest;

import java.util.Map;

@Unicity(includeAll = true)
public class MiraklCreateOfferMessageRequest extends AbstractMiraklApiRequest {

    private String offerId;
    private MiraklCreateOfferMessage message;

    public MiraklCreateOfferMessageRequest(String offerId, MiraklCreateOfferMessage message) {
        setOfferId(offerId);
        setMessage(message);
    }

    @Override
    public Map<String, String> getRequestTemplates() {
        Map<String, String> templates = super.getRequestTemplates();
        templates.put("offer", offerId);
        return templates;
    }

    @Override
    public MiraklApiEndpoint getEndpoint() {
        return MiraklFrontApiEndpoint.OF42;
    }

    public String getOfferId() {
        return offerId;
    }

    /**
     * Offer ID
     */
    public void setOfferId(String offerId) {
        checkRequiredArgument(offerId, "offerId");
        this.offerId = offerId;
    }

    public MiraklCreateOfferMessage getMessage() {
        return message;
    }

    /**
     * The message on the offer
     */
    public void setMessage(MiraklCreateOfferMessage message) {
        checkRequiredArgument(message, "message");
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklCreateOfferMessageRequest that = (MiraklCreateOfferMessageRequest) o;

        if (offerId != null ? !offerId.equals(that.offerId) : that.offerId != null) {
            return false;
        }
        return message != null ? message.equals(that.message) : that.message == null;

    }

    @Override
    public int hashCode() {
        int result = offerId != null ? offerId.hashCode() : 0;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }
}
