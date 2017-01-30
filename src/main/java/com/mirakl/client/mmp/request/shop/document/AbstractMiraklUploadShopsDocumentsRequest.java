/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.request.shop.document;

import com.mirakl.client.core.internal.MiraklApiEndpoint;
import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.core.internal.MiraklMarketplacePlatformCommonApiEndpoint;
import com.mirakl.client.mmp.request.common.document.MiraklUploadDocument;
import com.mirakl.client.request.AbstractMiraklApiRequest;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Unicity(includeAll = true)
public abstract class AbstractMiraklUploadShopsDocumentsRequest extends AbstractMiraklApiRequest {

    private List<MiraklUploadDocument> documents;

    @Override
    public MiraklApiEndpoint getEndpoint() {
        return MiraklMarketplacePlatformCommonApiEndpoint.S32;
    }

    public List<File> getFiles() {
        List<File> result = new ArrayList<File>(documents.size());
        for (MiraklUploadDocument document : documents) {
            result.add(document.getFile());
        }
        return result;
    }

    public void setDocuments(List<MiraklUploadDocument> documents) {
        checkRequiredArgument(documents, "documents");
        this.documents = documents;
    }

    public List<MiraklUploadDocument> getDocuments() {
        return documents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AbstractMiraklUploadShopsDocumentsRequest that = (AbstractMiraklUploadShopsDocumentsRequest) o;

        return documents != null ? documents.equals(that.documents) : that.documents == null;

    }

    @Override
    public int hashCode() {
        return documents != null ? documents.hashCode() : 0;
    }
}
