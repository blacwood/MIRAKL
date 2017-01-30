/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.order.document;

import com.mirakl.client.domain.common.Unicity;
import org.codehaus.jackson.annotate.JsonProperty;
import com.mirakl.client.mmp.domain.common.document.MiraklDocumentsUploadResult;

import java.util.List;

/**
 * The errors report. This bean only includes documents with errors. All other documents are successfully uploaded.
 */
@Unicity(includeAll = true)
public class MiraklOrderDocumentsUploadResult extends MiraklDocumentsUploadResult {

    @JsonProperty("order_documents")
    public void setDocuments(List<MiraklUploadDocumentWithErrors> documents) {
        super.setDocuments(documents);
    }
}
