/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.request.order.document;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.request.common.document.MiraklUploadDocument;

import java.util.List;

@Unicity(includeAll = true)
public class MiraklUploadOrderDocumentWrapper {

    private List<MiraklUploadDocument> orderDocuments;

    public MiraklUploadOrderDocumentWrapper(List<MiraklUploadDocument> orderDocuments) {
        this.orderDocuments = orderDocuments;
    }

    public List<MiraklUploadDocument> getOrderDocuments() {
        return orderDocuments;
    }

    public void setOrderDocuments(List<MiraklUploadDocument> orderDocuments) {
        this.orderDocuments = orderDocuments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklUploadOrderDocumentWrapper that = (MiraklUploadOrderDocumentWrapper) o;

        return orderDocuments != null ? orderDocuments.equals(that.orderDocuments) : that.orderDocuments == null;

    }

    @Override
    public int hashCode() {
        return orderDocuments != null ? orderDocuments.hashCode() : 0;
    }
}
