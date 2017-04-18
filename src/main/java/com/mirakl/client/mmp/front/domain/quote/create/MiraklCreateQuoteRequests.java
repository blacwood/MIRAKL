/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */

package com.mirakl.client.mmp.front.domain.quote.create;

import com.mirakl.client.domain.common.Unicity;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.*;

@Unicity(includeAll = true)
public class MiraklCreateQuoteRequests {

    private List<MiraklCreateQuoteRequest> quoteRequests = new ArrayList<MiraklCreateQuoteRequest>();

    public MiraklCreateQuoteRequests(List<MiraklCreateQuoteRequest> quoteRequests) {
        this.quoteRequests.addAll(quoteRequests);
    }

    public List<MiraklCreateQuoteRequest> getQuoteRequests() {
        return unmodifiableList(quoteRequests);
    }

    public boolean addQuoteRequest(MiraklCreateQuoteRequest quoteRequest) {
        return this.quoteRequests.add(quoteRequest);
    }

    public boolean addAllQuoteRequests(List<MiraklCreateQuoteRequest> quoteRequests) {
        return this.quoteRequests.addAll(quoteRequests);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklCreateQuoteRequests that = (MiraklCreateQuoteRequests) o;

        return quoteRequests != null ? quoteRequests.equals(that.quoteRequests) : that.quoteRequests == null;

    }

    @Override
    public int hashCode() {
        return quoteRequests != null ? quoteRequests.hashCode() : 0;
    }
}
