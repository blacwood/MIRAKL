/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.front.domain.quote.message;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.domain.common.MiraklUserType;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Unicity(props = "id")
public class MiraklQuoteRequestMessage {

    private String id;
    private String body;
    @JsonProperty("from")
    private MiraklUserType fromType;
    @JsonProperty("to")
    private MiraklUserType toType;
    private Date dateCreated;
    private List<MiraklQuoteRequestDocument> documents = new ArrayList<MiraklQuoteRequestDocument>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public MiraklUserType getFromType() {
        return fromType;
    }

    public void setFromType(MiraklUserType fromType) {
        this.fromType = fromType;
    }

    public MiraklUserType getToType() {
        return toType;
    }

    public void setToType(MiraklUserType toType) {
        this.toType = toType;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

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

        MiraklQuoteRequestMessage that = (MiraklQuoteRequestMessage) o;

        return id != null ? id.equals(that.id) : that.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}


