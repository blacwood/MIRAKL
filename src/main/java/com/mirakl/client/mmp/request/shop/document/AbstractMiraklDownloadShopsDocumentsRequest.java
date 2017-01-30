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
import com.mirakl.client.mmp.request.common.document.AbstractDocumentDownloadRequest;

import java.util.Collection;
import java.util.Map;

import static com.mirakl.client.core.internal.util.MiraklApiUtils.convertCollectionToStringParam;

@Unicity(includeAll = true)
public class AbstractMiraklDownloadShopsDocumentsRequest extends AbstractDocumentDownloadRequest {

    private Collection<String> documentIds;
    private Collection<String> documentCodes;

    @Override
    public MiraklApiEndpoint getEndpoint() {
        return MiraklMarketplacePlatformCommonApiEndpoint.S31;
    }

    @Override
    public Map<String, String> getQueryParams() {
        Map<String, String> params = super.getQueryParams();

        if (documentIds != null) {
            params.put("document_ids", convertCollectionToStringParam(documentIds));
        }
        if (documentCodes != null) {
            params.put("type_codes", convertCollectionToStringParam(documentCodes));
        }

        return params;
    }

    @Override
    public Collection<String> getDocumentIds() {
        return documentIds;
    }

    /**
     * Documents ID
     */
    public void setDocumentIds(Collection<String> documentIds) {
        this.documentIds = documentIds;
    }

    public Collection<String> getDocumentCodes() {
        return documentCodes;
    }

    /**
     * Documents code
     */
    public void setDocumentCodes(Collection<String> documentCodes) {
        this.documentCodes = documentCodes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AbstractMiraklDownloadShopsDocumentsRequest that = (AbstractMiraklDownloadShopsDocumentsRequest) o;

        if (documentIds != null ? !documentIds.equals(that.documentIds) : that.documentIds != null) {
            return false;
        }
        return documentCodes != null ? documentCodes.equals(that.documentCodes) : that.documentCodes == null;

    }

    @Override
    public int hashCode() {
        int result = documentIds != null ? documentIds.hashCode() : 0;
        result = 31 * result + (documentCodes != null ? documentCodes.hashCode() : 0);
        return result;
    }
}
