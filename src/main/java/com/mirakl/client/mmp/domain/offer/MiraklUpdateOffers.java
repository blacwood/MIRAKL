/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.offer;

import com.mirakl.client.domain.common.Unicity;

import java.util.List;

@Unicity(includeAll = true)
public class MiraklUpdateOffers {

    private List<MiraklUpdateOffer> offers;

    public MiraklUpdateOffers(List<MiraklUpdateOffer> offers) {
        this.offers = offers;
    }

    public List<MiraklUpdateOffer> getOffers() {
        return offers;
    }

    public void setOffers(List<MiraklUpdateOffer> offers) {
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

        MiraklUpdateOffers that = (MiraklUpdateOffers) o;

        return offers != null ? offers.equals(that.offers) : that.offers == null;

    }

    @Override
    public int hashCode() {
        return offers != null ? offers.hashCode() : 0;
    }
}
