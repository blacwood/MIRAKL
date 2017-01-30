/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.request.common.synchro;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.request.AbstractMiraklApiRequest;
import com.mirakl.client.request.MiraklApiRequest;

import java.util.Map;

@Unicity(includeAll = true)
public abstract class AbstractMiraklSynchroErrorReportRequest extends AbstractMiraklApiRequest implements MiraklApiRequest {

    private String synchroId;

    public AbstractMiraklSynchroErrorReportRequest(String synchroId) {
        setSynchroId(synchroId);
    }

    @Override
    public Map<String, String> getRequestTemplates() {
        Map<String, String> templates = super.getRequestTemplates();
        templates.put("synchro", synchroId);
        return templates;
    }

    /**
     * Set the synchro unique identifier
     */
    public void setSynchroId(String synchroId) {
        checkRequiredArgument(synchroId, "synchroId");
        this.synchroId = synchroId;
    }

    public String getSynchroId() {
        return synchroId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AbstractMiraklSynchroErrorReportRequest that = (AbstractMiraklSynchroErrorReportRequest) o;

        return synchroId != null ? synchroId.equals(that.synchroId) : that.synchroId == null;

    }

    @Override
    public int hashCode() {
        return synchroId != null ? synchroId.hashCode() : 0;
    }
}
