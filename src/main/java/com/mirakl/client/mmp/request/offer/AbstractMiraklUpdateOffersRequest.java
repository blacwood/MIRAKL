/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.request.offer;

import com.mirakl.client.core.internal.MiraklApiEndpoint;
import com.mirakl.client.core.internal.MiraklOperatorShopApiEndpoint;
import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.domain.offer.MiraklUpdateOffer;
import com.mirakl.client.request.AbstractMiraklApiRequest;

import java.util.List;

@Unicity(includeAll = true)
public abstract class AbstractMiraklUpdateOffersRequest extends AbstractMiraklApiRequest {

    private List<MiraklUpdateOffer> offers;

    @Override
    public MiraklApiEndpoint getEndpoint() {
        return MiraklOperatorShopApiEndpoint.OF24;
    }

    public List<MiraklUpdateOffer> getOffers() {
        return offers;
    }

    public void setOffers(List<MiraklUpdateOffer> offers) {
        checkRequiredArgument(offers, "offers");
        this.offers = offers;
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

        AbstractMiraklUpdateOffersRequest that = (AbstractMiraklUpdateOffersRequest) o;

        return offers != null ? offers.equals(that.offers) : that.offers == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (offers != null ? offers.hashCode() : 0);
        return result;
    }
}
