/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.request.offer.importer;

import com.mirakl.client.core.internal.MiraklApiEndpoint;
import com.mirakl.client.core.internal.MiraklOperatorShopApiEndpoint;
import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.request.AbstractMiraklApiRequest;

import java.util.Map;

@Unicity(includeAll = true)
public abstract class AbstractMiraklOfferImportReportRequest extends AbstractMiraklApiRequest {

    private String importId;

    public AbstractMiraklOfferImportReportRequest(String importId) {
        setImportId(importId);
    }

    public String getImportId() {
        return importId;
    }

    /**
     * Import ID
     */
    public void setImportId(String importId) {
        checkRequiredArgument(importId, "importId");
        this.importId = importId;
    }

    @Override
    public Map<String, String> getRequestTemplates() {
        Map<String, String> templates = super.getRequestTemplates();
        templates.put("import", importId);
        return templates;
    }

    @Override
    public MiraklApiEndpoint getEndpoint() {
        return MiraklOperatorShopApiEndpoint.OF02;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        AbstractMiraklOfferImportReportRequest that = (AbstractMiraklOfferImportReportRequest) o;

        return importId != null ? importId.equals(that.importId) : that.importId == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (importId != null ? importId.hashCode() : 0);
        return result;
    }
}
