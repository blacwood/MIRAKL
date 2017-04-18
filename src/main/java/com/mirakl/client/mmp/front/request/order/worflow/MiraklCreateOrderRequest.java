/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.front.request.order.worflow;

import com.mirakl.client.core.internal.MiraklApiEndpoint;
import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.front.domain.order.create.MiraklCreateOrder;
import com.mirakl.client.request.AbstractMiraklApiRequest;

import static com.mirakl.client.mmp.front.core.internal.MiraklFrontApiEndpoint.OR01;

@Unicity(includeAll = true)
public class MiraklCreateOrderRequest extends AbstractMiraklApiRequest {

    private MiraklCreateOrder createOrder;

    public MiraklCreateOrderRequest(MiraklCreateOrder createOrder) {
        setCreateOrder(createOrder);
    }

    @Override
    public MiraklApiEndpoint getEndpoint() {
        return OR01;
    }

    public MiraklCreateOrder getCreateOrder() {
        return createOrder;
    }

    public void setCreateOrder(MiraklCreateOrder createOrder) {
        checkRequiredArgument(createOrder, "createOrder");
        this.createOrder = createOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklCreateOrderRequest that = (MiraklCreateOrderRequest) o;

        return createOrder != null ? createOrder.equals(that.createOrder) : that.createOrder == null;

    }

    @Override
    public int hashCode() {
        return createOrder != null ? createOrder.hashCode() : 0;
    }
}
