/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.request.order.message;

import com.mirakl.client.domain.common.Unicity;

/**
 * @deprecated Please use {@code com.mirakl.client.mmp.front.request.order.message.MiraklCreateOrderMessageRequest},
 * {@code com.mirakl.client.mmp.shop.request.order.message.MiraklCreateOrderMessageRequest} or {@code com.mirakl.client.mmp.operator.request.order.message.MiraklCreateOrderMessageRequest}
 * instead.
 */
@Deprecated
@Unicity(includeAll = true)
public class MiraklCreateOrderMessageRequest extends AbstractMiraklCreateOrderMessageRequest {

    public MiraklCreateOrderMessageRequest(String orderId, MiraklCreateOrderMessage message) {
        super(orderId, message);
    }

}
