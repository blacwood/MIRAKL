/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.front.request.order.evaluation;

import com.mirakl.client.core.internal.MiraklApiEndpoint;
import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.front.core.internal.MiraklFrontApiEndpoint;
import com.mirakl.client.request.AbstractMiraklApiRequest;

import java.util.Map;

@Unicity(includeAll = true)
public class MiraklCreateOrderEvaluationRequest extends AbstractMiraklApiRequest {

    private String orderId;
    private MiraklCreateOrderEvaluation evaluation;

    public MiraklCreateOrderEvaluationRequest(String orderId, MiraklCreateOrderEvaluation evaluation) {
        setOrderId(orderId);
        setEvaluation(evaluation);
    }

    @Override
    public MiraklApiEndpoint getEndpoint() {
        return MiraklFrontApiEndpoint.OR52;
    }

    @Override
    public Map<String, String> getRequestTemplates() {
        Map<String, String> templates = super.getRequestTemplates();
        templates.put("order", orderId);
        return templates;
    }

    public String getOrderId() {
        return orderId;
    }

    /**
     * Order ID
     */
    public void setOrderId(String orderId) {
        checkRequiredArgument(orderId, "orderId");
        this.orderId = orderId;
    }

    /**
     * Evaluation content
     */
    public MiraklCreateOrderEvaluation getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(MiraklCreateOrderEvaluation evaluation) {
        checkRequiredArgument(evaluation, "evaluation");
        this.evaluation = evaluation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklCreateOrderEvaluationRequest that = (MiraklCreateOrderEvaluationRequest) o;

        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) {
            return false;
        }
        return evaluation != null ? evaluation.equals(that.evaluation) : that.evaluation == null;

    }

    @Override
    public int hashCode() {
        int result = orderId != null ? orderId.hashCode() : 0;
        result = 31 * result + (evaluation != null ? evaluation.hashCode() : 0);
        return result;
    }
}
