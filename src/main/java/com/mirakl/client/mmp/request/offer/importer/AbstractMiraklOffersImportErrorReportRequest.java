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
public abstract class AbstractMiraklOffersImportErrorReportRequest extends AbstractMiraklApiRequest {

    private String importId;

    public AbstractMiraklOffersImportErrorReportRequest(String importId) {
        this.importId = importId;
    }

    @Override
    public MiraklApiEndpoint getEndpoint() {
        return MiraklOperatorShopApiEndpoint.OF03;
    }

    @Override
    public Map<String, String> getRequestTemplates() {
        Map<String, String> templates = super.getRequestTemplates();
        templates.put("import", importId);
        return templates;
    }

    public String getImportId() {
        return importId;
    }

    /**
     * Offer Import ID
     */
    public void setImportId(String importId) {
        checkRequiredArgument(importId, "importId");
        this.importId = importId;
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

        AbstractMiraklOffersImportErrorReportRequest that = (AbstractMiraklOffersImportErrorReportRequest) o;

        return importId != null ? importId.equals(that.importId) : that.importId == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (importId != null ? importId.hashCode() : 0);
        return result;
    }
}
