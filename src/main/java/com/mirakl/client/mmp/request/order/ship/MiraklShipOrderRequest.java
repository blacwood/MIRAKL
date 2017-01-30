/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.request.order.ship;

import com.mirakl.client.domain.common.Unicity;

/**
 * @deprecated Please use {@code com.mirakl.client.mmp.front.request.order.ship.MiraklShipOrderRequest},
 * {@code com.mirakl.client.mmp.shop.request.order.ship.MiraklShipOrderRequest} or {@code com.mirakl.client.mmp.operator.request.order.ship.MiraklShipOrderRequest}
 * instead.
 */
@Deprecated
@Unicity(includeAll = true)
public class MiraklShipOrderRequest extends AbstractMiraklShipOrderRequest {

    public MiraklShipOrderRequest(String orderId) {
        super(orderId);
    }

}
