/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.request.order.accept;

import com.mirakl.client.domain.common.Unicity;

import java.util.List;

/**
 * @deprecated Please use {@code com.mirakl.client.mmp.front.request.order.accept.MiraklAcceptOrderRequest},
 * {@code com.mirakl.client.mmp.shop.request.order.accept.MiraklAcceptOrderRequest} or {@code com.mirakl.client.mmp.operator.request.order.accept.MiraklAcceptOrderRequest}
 * instead.
 */
@Deprecated
@Unicity(includeAll = true)
public class MiraklAcceptOrderRequest extends AbstractMiraklAcceptOrderRequest {

    public MiraklAcceptOrderRequest(String orderId, List<MiraklAcceptOrderLine> orderLines) {
        super(orderId, orderLines);
    }

}
