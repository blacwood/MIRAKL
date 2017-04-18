/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.front.domain.quote.create;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.front.domain.quote.get.MiraklQuoteRequest;

@Unicity(includeAll = true)
public class MiraklQuoteRequestReturn {

    private MiraklQuoteRequest quoteRequestCreated;

    private MiraklQuoteRequestError quoteRequestError;


    public MiraklQuoteRequest getQuoteRequestCreated() {
        return quoteRequestCreated;
    }

    public void setQuoteRequestCreated(MiraklQuoteRequest quoteRequestCreated) {
        this.quoteRequestCreated = quoteRequestCreated;
    }

    public MiraklQuoteRequestError getQuoteRequestError() {
        return quoteRequestError;
    }

    public void setQuoteRequestError(MiraklQuoteRequestError quoteRequestError) {
        this.quoteRequestError = quoteRequestError;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MiraklQuoteRequestReturn that = (MiraklQuoteRequestReturn) o;

        if (quoteRequestCreated != null ? !quoteRequestCreated.equals(that.quoteRequestCreated) : that.quoteRequestCreated != null)
            return false;
        return quoteRequestError != null ? quoteRequestError.equals(that.quoteRequestError) : that.quoteRequestError == null;

    }

    @Override
    public int hashCode() {
        int result = quoteRequestCreated != null ? quoteRequestCreated.hashCode() : 0;
        result = 31 * result + (quoteRequestError != null ? quoteRequestError.hashCode() : 0);
        return result;
    }
}
