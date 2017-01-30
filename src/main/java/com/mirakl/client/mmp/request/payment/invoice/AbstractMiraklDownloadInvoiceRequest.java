/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.request.payment.invoice;

import com.mirakl.client.core.internal.MiraklApiEndpoint;
import com.mirakl.client.core.internal.MiraklOperatorShopApiEndpoint;
import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.request.AbstractMiraklApiRequest;

import java.util.Map;

@Unicity(includeAll = true)
public abstract class AbstractMiraklDownloadInvoiceRequest extends AbstractMiraklApiRequest {

    private String invoiceId;

    public AbstractMiraklDownloadInvoiceRequest(String invoiceId) {
        setInvoiceId(invoiceId);
    }

    @Override
    public MiraklApiEndpoint getEndpoint() {
        return MiraklOperatorShopApiEndpoint.IV02;
    }

    @Override
    public Map<String, String> getRequestTemplates() {
        Map<String, String> templates = super.getRequestTemplates();
        templates.put("invoice", invoiceId);
        return templates;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    /**
     * Invoice ID
     */
    public void setInvoiceId(String invoiceId) {
        checkRequiredArgument(invoiceId, "invoiceId");
        this.invoiceId = invoiceId;
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

        AbstractMiraklDownloadInvoiceRequest that = (AbstractMiraklDownloadInvoiceRequest) o;

        return invoiceId != null ? invoiceId.equals(that.invoiceId) : that.invoiceId == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (invoiceId != null ? invoiceId.hashCode() : 0);
        return result;
    }
}
