/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.front.domain.quote.create;

import com.mirakl.client.domain.common.Unicity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.*;

@Unicity(includeAll = true)
public class MiraklQuoteRequestReturns {

    private List<MiraklQuoteRequestReturn> quoteRequestReturns = new ArrayList<MiraklQuoteRequestReturn>();

    public List<MiraklQuoteRequestReturn> getQuoteRequestReturns() {
        return unmodifiableList(quoteRequestReturns);
    }

    public void setQuoteRequestReturns(List<MiraklQuoteRequestReturn> quoteRequestReturns) {
        this.quoteRequestReturns.addAll(quoteRequestReturns);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MiraklQuoteRequestReturns that = (MiraklQuoteRequestReturns) o;

        return quoteRequestReturns != null ? quoteRequestReturns.equals(that.quoteRequestReturns) : that.quoteRequestReturns == null;

    }

    @Override
    public int hashCode() {
        return quoteRequestReturns != null ? quoteRequestReturns.hashCode() : 0;
    }
}
