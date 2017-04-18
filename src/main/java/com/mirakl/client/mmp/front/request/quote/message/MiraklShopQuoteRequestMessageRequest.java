/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.front.request.quote.message;

import com.mirakl.client.core.internal.MiraklApiEndpoint;
import com.mirakl.client.mmp.domain.common.MiraklUserType;
import com.mirakl.client.mmp.front.core.internal.MiraklFrontApiEndpoint;
import com.mirakl.client.request.AbstractMiraklApiRequest;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;


public class MiraklShopQuoteRequestMessageRequest extends AbstractMiraklApiRequest {

    private String shopQuoteRequestId;

    private String messageBody;

    private MiraklUserType toType;

    private List<MiraklQuoteRequestMessageDocumentRequest> documents = new ArrayList<MiraklQuoteRequestMessageDocumentRequest>();

    public MiraklShopQuoteRequestMessageRequest(String shopQuoteRequestId, String messageBody, MiraklUserType toType) {
        this.shopQuoteRequestId = shopQuoteRequestId;
        this.messageBody = messageBody;
        this.toType = toType;
    }

    public String getShopQuoteRequestId() {
        return shopQuoteRequestId;
    }

    public void setShopQuoteRequestId(String shopQuoteRequestId) {
        this.shopQuoteRequestId = shopQuoteRequestId;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public MiraklUserType getToType() {
        return toType;
    }

    public void setToType(MiraklUserType toType) {
        this.toType = toType;
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
    public MiraklApiEndpoint getEndpoint() {
        return MiraklFrontApiEndpoint.Q05;
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

        MiraklShopQuoteRequestMessageRequest that = (MiraklShopQuoteRequestMessageRequest) o;

        if (shopQuoteRequestId != null ? !shopQuoteRequestId.equals(that.shopQuoteRequestId) : that.shopQuoteRequestId != null) {
            return false;
        }
        if (messageBody != null ? !messageBody.equals(that.messageBody) : that.messageBody != null) {
            return false;
        }
        if (toType != that.toType) {
            return false;
        }
        return documents != null ? documents.equals(that.documents) : that.documents == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (shopQuoteRequestId != null ? shopQuoteRequestId.hashCode() : 0);
        result = 31 * result + (messageBody != null ? messageBody.hashCode() : 0);
        result = 31 * result + (toType != null ? toType.hashCode() : 0);
        result = 31 * result + (documents != null ? documents.hashCode() : 0);
        return result;
    }
}
