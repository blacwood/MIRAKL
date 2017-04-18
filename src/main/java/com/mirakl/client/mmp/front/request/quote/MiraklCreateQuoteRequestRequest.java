/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.front.request.quote;


import com.mirakl.client.core.internal.MiraklApiEndpoint;
import com.mirakl.client.mmp.front.core.internal.MiraklFrontApiEndpoint;
import com.mirakl.client.mmp.front.domain.quote.create.MiraklCreateQuoteRequests;
import com.mirakl.client.mmp.front.request.quote.message.MiraklQuoteRequestMessageDocumentRequest;
import com.mirakl.client.request.AbstractMiraklApiRequest;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;

public class MiraklCreateQuoteRequestRequest extends AbstractMiraklApiRequest {

    private MiraklCreateQuoteRequests createQuoteRequests;
    private List<MiraklQuoteRequestMessageDocumentRequest> documents = new ArrayList<MiraklQuoteRequestMessageDocumentRequest>();


    public MiraklCreateQuoteRequestRequest(MiraklCreateQuoteRequests createQuoteRequests) {
        this.createQuoteRequests = createQuoteRequests;
    }

    public MiraklCreateQuoteRequests getCreateQuoteRequests() {
        return createQuoteRequests;
    }

    public void setCreateQuoteRequests(MiraklCreateQuoteRequests createQuoteRequests) {
        this.createQuoteRequests = createQuoteRequests;
    }


    public List<MiraklQuoteRequestMessageDocumentRequest> getDocuments() {
        return unmodifiableList(documents);
    }

    public boolean addDocument(MiraklQuoteRequestMessageDocumentRequest document) {
        return documents.add(document);
    }

    public boolean addAllDocuments(List<MiraklQuoteRequestMessageDocumentRequest> documents) {
        return this.documents.addAll(documents);
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

        MiraklCreateQuoteRequestRequest that = (MiraklCreateQuoteRequestRequest) o;

        if (createQuoteRequests != null ? !createQuoteRequests.equals(that.createQuoteRequests) : that.createQuoteRequests != null) {
            return false;
        }
        return documents != null ? documents.equals(that.documents) : that.documents == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (createQuoteRequests != null ? createQuoteRequests.hashCode() : 0);
        result = 31 * result + (documents != null ? documents.hashCode() : 0);
        return result;
    }

    @Override
    public MiraklApiEndpoint getEndpoint() {
        return MiraklFrontApiEndpoint.Q01;
    }
}
