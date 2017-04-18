/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.front.request.order.worflow;

import com.mirakl.client.core.internal.MiraklApiEndpoint;
import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.front.core.internal.MiraklFrontApiEndpoint;
import com.mirakl.client.request.AbstractMiraklApiRequest;

import java.util.Map;

@Unicity(includeAll = true)
public class MiraklValidOrderRequest extends AbstractMiraklApiRequest {

    private String commercialId;

    public MiraklValidOrderRequest(String commercialId) {
        checkRequiredArgument(commercialId, "commercialId");
        this.commercialId = commercialId;
    }

    @Override
    public MiraklApiEndpoint getEndpoint() {
        return MiraklFrontApiEndpoint.OR02;
    }

    @Override
    public Map<String, String> getRequestTemplates() {
        Map<String, String> templates = super.getRequestTemplates();
        templates.put("commercial_id", commercialId);
        return templates;
    }

    public String getCommercialId() {
        return commercialId;
    }

    /**
     * Order commercial ID
     */
    public void setCommercialId(String commercialId) {
        this.commercialId = commercialId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklValidOrderRequest that = (MiraklValidOrderRequest) o;

        return commercialId != null ? commercialId.equals(that.commercialId) : that.commercialId == null;

    }

    @Override
    public int hashCode() {
        return commercialId != null ? commercialId.hashCode() : 0;
    }
}
