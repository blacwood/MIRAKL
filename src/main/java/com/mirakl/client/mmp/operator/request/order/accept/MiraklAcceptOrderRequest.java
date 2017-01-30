/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.operator.request.order.accept;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.request.order.accept.AbstractMiraklAcceptOrderRequest;
import com.mirakl.client.mmp.request.order.accept.MiraklAcceptOrderLine;

import java.util.List;

@Unicity(includeAll = true)
public class MiraklAcceptOrderRequest extends AbstractMiraklAcceptOrderRequest {

    public MiraklAcceptOrderRequest(String orderId, List<MiraklAcceptOrderLine> orderLines) {
        super(orderId, orderLines);
    }

}
