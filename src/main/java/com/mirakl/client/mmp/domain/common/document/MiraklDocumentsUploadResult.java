/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.common.document;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.domain.order.document.MiraklUploadDocumentWithErrors;

import java.util.List;

/**
 * The errors report. This bean only includes documents with errors. All other documents are successfully uploaded.
 */
@Unicity(includeAll = true)
public class MiraklDocumentsUploadResult {

    private List<MiraklUploadDocumentWithErrors> documents;
    private int errorsCount;

    public List<MiraklUploadDocumentWithErrors> getDocuments() {
        return documents;
    }

    protected void setDocuments(List<MiraklUploadDocumentWithErrors> documents) {
        this.documents = documents;
    }

    public int getErrorsCount() {
        return errorsCount;
    }

    public void setErrorsCount(int errorsCount) {
        this.errorsCount = errorsCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklDocumentsUploadResult that = (MiraklDocumentsUploadResult) o;

        if (errorsCount != that.errorsCount) {
            return false;
        }
        return documents != null ? documents.equals(that.documents) : that.documents == null;

    }

    @Override
    public int hashCode() {
        int result = documents != null ? documents.hashCode() : 0;
        result = 31 * result + errorsCount;
        return result;
    }
}
