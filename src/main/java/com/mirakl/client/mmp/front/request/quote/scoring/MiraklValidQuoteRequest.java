/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.front.request.quote.scoring;

import com.mirakl.client.core.internal.MiraklApiEndpoint;
import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.front.core.internal.MiraklFrontApiEndpoint;
import com.mirakl.client.request.AbstractMiraklApiRequest;

import java.util.Map;

@Unicity(includeAll = true)
public class MiraklValidQuoteRequest extends AbstractMiraklApiRequest {

    private String quoteRequestId;

    public MiraklValidQuoteRequest(String quoteRequestId) {
        checkRequiredArgument(quoteRequestId, "quoteRequestId");
        this.quoteRequestId = quoteRequestId;
    }

    @Override
    public MiraklApiEndpoint getEndpoint() {
        return MiraklFrontApiEndpoint.Q02;
    }

    @Override
    public Map<String, String> getRequestTemplates() {
        Map<String, String> templates = super.getRequestTemplates();
        templates.put("quote_request_id", quoteRequestId);
        return templates;
    }

    public String getQuoteRequestId() {
        return quoteRequestId;
    }

    public void setQuoteRequestId(String quoteRequestId) {
        this.quoteRequestId = quoteRequestId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklValidQuoteRequest that = (MiraklValidQuoteRequest) o;

        return quoteRequestId != null ? quoteRequestId.equals(that.quoteRequestId) : that.quoteRequestId == null;

    }


    @Override

    public int hashCode() {
        return quoteRequestId != null ? quoteRequestId.hashCode() : 0;
    }
}
