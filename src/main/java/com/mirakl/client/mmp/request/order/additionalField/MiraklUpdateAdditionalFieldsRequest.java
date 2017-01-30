/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.request.order.additionalField;

import com.mirakl.client.core.internal.MiraklApiEndpoint;
import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.domain.order.additionalfield.MiraklUpdateAdditionalFields;
import com.mirakl.client.request.AbstractMiraklApiRequest;

import java.util.Map;

import static com.mirakl.client.mmp.core.internal.MiraklMarketplacePlatformCommonApiEndpoint.OR31;

@Unicity(includeAll = true)
public class MiraklUpdateAdditionalFieldsRequest extends AbstractMiraklApiRequest {

    private String orderId;
    private MiraklUpdateAdditionalFields miraklUpdateAdditionalFields;

    public MiraklUpdateAdditionalFieldsRequest(String orderId, MiraklUpdateAdditionalFields miraklUpdateAdditionalFields) {
        setOrderId(orderId);
        setMiraklUpdateAdditionalFields(miraklUpdateAdditionalFields);
    }

    @Override
    public MiraklApiEndpoint getEndpoint() {
        return OR31;
    }

    @Override
    public Map<String, String> getRequestTemplates() {
        Map<String, String> templates = super.getRequestTemplates();
        templates.put("order_id", orderId);
        return templates;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        checkRequiredArgument(orderId, "orderId");
        this.orderId = orderId;
    }

    public MiraklUpdateAdditionalFields getMiraklUpdateAdditionalFields() {
        return miraklUpdateAdditionalFields;
    }

    public void setMiraklUpdateAdditionalFields(MiraklUpdateAdditionalFields miraklUpdateAdditionalFields) {
        checkRequiredArgument(miraklUpdateAdditionalFields, "miraklUpdateAdditionalFields");
        this.miraklUpdateAdditionalFields = miraklUpdateAdditionalFields;
    }
}
