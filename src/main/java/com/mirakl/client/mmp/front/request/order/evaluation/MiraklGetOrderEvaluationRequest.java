/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.front.request.order.evaluation;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.request.order.evaluation.AbstractMiraklGetOrderEvaluationRequest;

@Unicity(includeAll = true)
public class MiraklGetOrderEvaluationRequest extends AbstractMiraklGetOrderEvaluationRequest {

    public MiraklGetOrderEvaluationRequest(String orderId) {
        super(orderId);
    }

}
