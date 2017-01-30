/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.request.payment.invoice;

/**
 * @deprecated Please use {@code com.mirakl.client.mmp.shop.payment.invoice.MiraklDownloadInvoiceRequest} or
 * {@code com.mirakl.client.mmp.operator.payment.invoice.MiraklDownloadInvoiceRequest} instead.
 */
@Deprecated
public class MiraklDownloadInvoiceRequest extends AbstractMiraklDownloadInvoiceRequest {

    public MiraklDownloadInvoiceRequest(String invoiceId) {
        super(invoiceId);
    }

}
