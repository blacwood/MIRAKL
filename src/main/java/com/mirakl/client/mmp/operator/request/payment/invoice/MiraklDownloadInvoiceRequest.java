/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.operator.request.payment.invoice;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.request.payment.invoice.AbstractMiraklDownloadInvoiceRequest;

@Unicity(includeAll = true)
public class MiraklDownloadInvoiceRequest extends AbstractMiraklDownloadInvoiceRequest {

    public MiraklDownloadInvoiceRequest(String invoiceId) {
        super(invoiceId);
    }

}
