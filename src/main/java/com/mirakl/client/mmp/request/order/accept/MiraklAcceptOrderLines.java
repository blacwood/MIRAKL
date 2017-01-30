/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.request.order.accept;

import com.mirakl.client.domain.common.Unicity;

import java.util.List;

@Unicity(includeAll = true)
public class MiraklAcceptOrderLines {

    private List<MiraklAcceptOrderLine> orderLines;

    public MiraklAcceptOrderLines(List<MiraklAcceptOrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public List<MiraklAcceptOrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<MiraklAcceptOrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklAcceptOrderLines that = (MiraklAcceptOrderLines) o;

        return orderLines != null ? orderLines.equals(that.orderLines) : that.orderLines == null;

    }

    @Override
    public int hashCode() {
        return orderLines != null ? orderLines.hashCode() : 0;
    }
}
