/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.front.domain.quote.get;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.front.domain.quote.message.MiraklQuoteRequestDocument;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.unmodifiableList;

@Unicity(includeAll = true)
public class MiraklQuoteInitialRequest {

    private String body;
    private String subject;
    private String messageId;
    private List<MiraklQuoteRequestDocument> documents = new ArrayList<MiraklQuoteRequestDocument>();
    private List<MiraklQuoteLine> lines = new ArrayList<MiraklQuoteLine>();

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public List<MiraklQuoteLine> getLines() {
        return unmodifiableList(lines);
    }

    public void setLines(List<MiraklQuoteLine> lines) {
        this.lines.addAll(lines);
    }

    public List<MiraklQuoteRequestDocument> getDocuments() {
        return unmodifiableList(documents);
    }

    public boolean addDocument(MiraklQuoteRequestDocument document) {
        return documents.add(document);
    }

    public boolean addAllDocuments(List<MiraklQuoteRequestDocument> documents) {
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

        MiraklQuoteInitialRequest that = (MiraklQuoteInitialRequest) o;

        if (body != null ? !body.equals(that.body) : that.body != null) {
            return false;
        }
        if (subject != null ? !subject.equals(that.subject) : that.subject != null) {
            return false;
        }
        return lines != null ? lines.equals(that.lines) : that.lines == null;

    }

    @Override
    public int hashCode() {
        int result = body != null ? body.hashCode() : 0;
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (lines != null ? lines.hashCode() : 0);
        return result;
    }
}
