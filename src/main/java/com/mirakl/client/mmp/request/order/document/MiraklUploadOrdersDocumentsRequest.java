/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.request.order.document;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.request.common.document.MiraklUploadDocument;

import java.util.List;

/**
 * @deprecated Please use {@code com.mirakl.client.mmp.front.request.order.document.MiraklUploadOrdersDocumentsRequest},
 * {@code com.mirakl.client.mmp.shop.request.order.document.MiraklUploadOrdersDocumentsRequest} or {@code com.mirakl.client.mmp.operator.request.order.document.MiraklUploadOrdersDocumentsRequest}
 * instead.
 */
@Deprecated
@Unicity(includeAll = true)
public class MiraklUploadOrdersDocumentsRequest extends AbstractMiraklUploadOrdersDocumentsRequest {

    public MiraklUploadOrdersDocumentsRequest(String orderId, List<MiraklUploadDocument> documents) {
        super(orderId, documents);
    }

}
