/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.front.domain.quote.get;

import com.mirakl.client.domain.common.Unicity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.*;

@Unicity(includeAll = true)
public class MiraklQuoteRequests {

    private List<MiraklQuoteRequest> quoteRequests = new ArrayList<MiraklQuoteRequest>();
    private long totalCount;


    public List<MiraklQuoteRequest> getQuoteRequests() {
        return unmodifiableList(quoteRequests);
    }

    public void setQuoteRequests(List<MiraklQuoteRequest> quoteRequests) {
        this.quoteRequests.addAll(quoteRequests);
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MiraklQuoteRequests that = (MiraklQuoteRequests) o;

        if (totalCount != that.totalCount) return false;
        return quoteRequests != null ? quoteRequests.equals(that.quoteRequests) : that.quoteRequests == null;

    }

    @Override
    public int hashCode() {
        int result = quoteRequests != null ? quoteRequests.hashCode() : 0;
        result = 31 * result + (int) (totalCount ^ (totalCount >>> 32));
        return result;
    }
}
