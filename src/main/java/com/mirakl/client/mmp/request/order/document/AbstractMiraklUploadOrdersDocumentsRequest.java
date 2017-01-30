/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.request.order.document;

import com.mirakl.client.core.internal.MiraklApiEndpoint;
import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.core.internal.MiraklMarketplacePlatformCommonApiEndpoint;
import com.mirakl.client.mmp.request.common.document.MiraklUploadDocument;
import com.mirakl.client.request.AbstractMiraklApiRequest;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Unicity(includeAll = true)
public abstract class AbstractMiraklUploadOrdersDocumentsRequest extends AbstractMiraklApiRequest {

    private List<MiraklUploadDocument> documents;
    private String orderId;

    public AbstractMiraklUploadOrdersDocumentsRequest(String orderId, List<MiraklUploadDocument> documents) {
        setOrderId(orderId);
        setDocuments(documents);
    }

    @Override
    public MiraklApiEndpoint getEndpoint() {
        return MiraklMarketplacePlatformCommonApiEndpoint.OR74;
    }


    @Override
    public Map<String, String> getRequestTemplates() {
        Map<String, String> templates = super.getRequestTemplates();
        templates.put("order", orderId);
        return templates;
    }

    public List<File> getFiles() {
        List<File> result = new ArrayList<File>(documents.size());
        for (MiraklUploadDocument document : documents) {
            result.add(document.getFile());
        }
        return result;
    }

    public List<MiraklUploadDocument> getDocuments() {
        return documents;
    }

    public void setDocuments(List<MiraklUploadDocument> documents) {
        checkRequiredArgument(documents, "documents");
        this.documents = documents;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        checkRequiredArgument(orderId, "orderId");
        this.orderId = orderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AbstractMiraklUploadOrdersDocumentsRequest that = (AbstractMiraklUploadOrdersDocumentsRequest) o;

        if (documents != null ? !documents.equals(that.documents) : that.documents != null) {
            return false;
        }
        return orderId != null ? orderId.equals(that.orderId) : that.orderId == null;

    }

    @Override
    public int hashCode() {
        int result = documents != null ? documents.hashCode() : 0;
        result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
        return result;
    }
}
