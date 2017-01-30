/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.operator.request.order.refund;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.domain.order.refund.MiraklCreateRefund;
import com.mirakl.client.mmp.request.order.refund.AbstractMiraklCreateRefundRequest;

import java.util.List;

@Unicity(includeAll = true)
public class MiraklCreateRefundRequest extends AbstractMiraklCreateRefundRequest {

    public MiraklCreateRefundRequest(List<MiraklCreateRefund> refunds) {
        super(refunds);
    }

}
