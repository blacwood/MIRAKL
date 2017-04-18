/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.front.domain.quote.message;

import com.mirakl.client.domain.common.Unicity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Unicity(props = "id")
public class MiraklCreatedQuoteRequestMessage {

    private String id;

    private List<MiraklQuoteRequestDocument> documents = new ArrayList<MiraklQuoteRequestDocument>();

    /**
     * The id of the message created
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    /**
     * Message's documents
     */
    public List<MiraklQuoteRequestDocument> getDocuments() {
        return Collections.unmodifiableList(documents);
    }

    public void setDocuments(List<MiraklQuoteRequestDocument> documents) {
        this.documents.addAll(documents);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklCreatedQuoteRequestMessage that = (MiraklCreatedQuoteRequestMessage) o;

        return id != null ? id.equals(that.id) : that.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
