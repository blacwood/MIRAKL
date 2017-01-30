/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.request.order.document;

import java.util.Collection;

import com.mirakl.client.domain.common.Unicity;

/**
 * @deprecated Please use {@code com.mirakl.client.mmp.front.request.order.document.MiraklGetOrderDocumentsRequest},
 * {@code com.mirakl.client.mmp.shop.request.order.document.MiraklGetOrderDocumentsRequest} or {@code com.mirakl.client.mmp.operator.request.order.document.MiraklGetOrderDocumentsRequest}
 * instead.
 */
@Deprecated
@Unicity(includeAll = true)
public class MiraklGetOrderDocumentsRequest extends AbstractMiraklGetOrderDocumentsRequest {

    public MiraklGetOrderDocumentsRequest(Collection<String> orderIds) {
        super(orderIds);
    }

}
