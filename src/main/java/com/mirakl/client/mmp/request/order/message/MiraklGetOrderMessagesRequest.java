/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.request.order.message;

import com.mirakl.client.domain.common.Unicity;

/**
 * @deprecated Please use {@code com.mirakl.client.mmp.front.request.order.message.MiraklGetOrderMessagesRequest},
 * {@code com.mirakl.client.mmp.shop.request.order.message.MiraklGetOrderMessagesRequest} or {@code com.mirakl.client.mmp.operator.request.order.message.MiraklGetOrderMessagesRequest}
 * instead.
 */
@Deprecated
@Unicity(includeAll = true)
public class MiraklGetOrderMessagesRequest extends AbstractMiraklGetOrderMessagesRequest {

    public MiraklGetOrderMessagesRequest(String orderId) {
        super(orderId);
    }

}
