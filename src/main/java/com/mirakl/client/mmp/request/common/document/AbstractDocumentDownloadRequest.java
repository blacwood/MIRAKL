/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.request.common.document;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.request.AbstractMiraklApiRequest;

import java.util.Collection;

@Unicity(includeAll = true)
public abstract class AbstractDocumentDownloadRequest extends AbstractMiraklApiRequest {

    protected abstract Collection<String> getDocumentIds();

    /**
     * If only one document id is specified the API will return the corresponding document.
     * In all other cases the document(s) will be wrapped in a zip archive.
     */
    public boolean resultWillBeWrappedInAZipArchive() {
        Collection<String> documentIds = getDocumentIds();
        return !(documentIds != null && !documentIds.isEmpty() && documentIds.size() == 1);
    }
}
