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
public class MiraklOffers {

    private List<MiraklOffer> offers;
    private long totalCount;

    public List<MiraklOffer> getOffers() {
        return offers;
    }

    public void setOffers(List<MiraklOffer> offers) {
        this.offers = offers;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklOffers that = (MiraklOffers) o;

        if (totalCount != that.totalCount) {
            return false;
        }
        return offers != null ? offers.equals(that.offers) : that.offers == null;

    }

    @Override
    public int hashCode() {
        int result = offers != null ? offers.hashCode() : 0;
        result = 31 * result + (int) (totalCount ^ (totalCount >>> 32));
        return result;
    }
}
