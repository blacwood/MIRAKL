/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.operator.request.order.tracking;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.request.order.tracking.AbstractMiraklUpdateOrderTrackingInfoRequest;
import com.mirakl.client.mmp.request.order.tracking.MiraklOrderTrackingInfo;

@Unicity(includeAll = true)
public class MiraklUpdateOrderTrackingInfoRequest extends AbstractMiraklUpdateOrderTrackingInfoRequest {

    public MiraklUpdateOrderTrackingInfoRequest(String orderId, MiraklOrderTrackingInfo trackingOrderInfo) {
        super(orderId, trackingOrderInfo);
    }

}
