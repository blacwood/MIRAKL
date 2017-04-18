/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.front.request.quote.message;

import com.mirakl.client.core.internal.MiraklApiEndpoint;
import com.mirakl.client.mmp.front.core.internal.MiraklFrontApiEndpoint;
import com.mirakl.client.request.AbstractMiraklApiRequest;

import java.util.Map;

/**
 * Copyright (C) 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 */
public class MiraklQuoteRequestMessageDocumentsRequest extends AbstractMiraklApiRequest {

    private String messageId;
    private String documentId;

    public MiraklQuoteRequestMessageDocumentsRequest(String messageId, String documentId) {
        this.messageId = messageId;
        this.documentId = documentId;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    @Override
    public Map<String, String> getRequestTemplates() {
        Map<String, String> templates = super.getRequestTemplates();
        templates.put("quote_request_message_id", messageId);
        return templates;
    }

    @Override
    public Map<String, String> getQueryParams() {
        Map<String, String> result = super.getQueryParams();
        if (documentId != null) {
            result.put("document_id", documentId);
        }
        return result;
    }

    @Override
    public MiraklApiEndpoint getEndpoint() {
        return MiraklFrontApiEndpoint.Q06;
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

        MiraklQuoteRequestMessageDocumentsRequest that = (MiraklQuoteRequestMessageDocumentsRequest) o;

        if (messageId != null ? !messageId.equals(that.messageId) : that.messageId != null) {
            return false;
        }
        return documentId != null ? documentId.equals(that.documentId) : that.documentId == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (messageId != null ? messageId.hashCode() : 0);
        result = 31 * result + (documentId != null ? documentId.hashCode() : 0);
        return result;
    }
}
