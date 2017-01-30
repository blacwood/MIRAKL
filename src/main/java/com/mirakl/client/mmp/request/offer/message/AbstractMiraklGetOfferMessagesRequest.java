/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.request.offer.message;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.request.common.message.AbstractGetMessagesRequest;

import java.util.Map;

@Unicity(includeAll = true)
public abstract class AbstractMiraklGetOfferMessagesRequest extends AbstractGetMessagesRequest {

    private String offerId;

    public AbstractMiraklGetOfferMessagesRequest(String offerId) {
        setOfferId(offerId);
    }

    @Override
    public Map<String, String> getQueryParams() {
        Map<String, String> params = super.getQueryParams();

        if (offerId != null) {
            params.put("offer_id", offerId);
        }

        return params;
    }

    public String getOfferId() {
        return offerId;
    }

    /**
     * Filter by Offer ID
     */
    public void setOfferId(String offerId) {
        checkRequiredArgument(offerId, "offerId");
        this.offerId = offerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        AbstractMiraklGetOfferMessagesRequest that = (AbstractMiraklGetOfferMessagesRequest) o;

        return offerId != null ? offerId.equals(that.offerId) : that.offerId == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (offerId != null ? offerId.hashCode() : 0);
        return result;
    }
}
