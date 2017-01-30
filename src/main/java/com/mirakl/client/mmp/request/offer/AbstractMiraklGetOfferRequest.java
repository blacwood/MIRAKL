/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.request.offer;

import com.mirakl.client.core.internal.MiraklApiEndpoint;
import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.core.internal.MiraklMarketplacePlatformCommonApiEndpoint;
import com.mirakl.client.request.AbstractMiraklApiRequest;

import java.util.Map;

@Unicity(includeAll = true)
public abstract class AbstractMiraklGetOfferRequest extends AbstractMiraklApiRequest {

    private String offerId;

    public AbstractMiraklGetOfferRequest(String offerId) {
        setOfferId(offerId);
    }

    @Override
    public MiraklApiEndpoint getEndpoint() {
        return MiraklMarketplacePlatformCommonApiEndpoint.OF22;
    }

    @Override
    public Map<String, String> getRequestTemplates() {
        Map<String, String> templates = super.getRequestTemplates();
        templates.put("offer", offerId);
        return templates;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AbstractMiraklGetOfferRequest that = (AbstractMiraklGetOfferRequest) o;

        return offerId != null ? offerId.equals(that.offerId) : that.offerId == null;

    }

    @Override
    public int hashCode() {
        return offerId != null ? offerId.hashCode() : 0;
    }
}
