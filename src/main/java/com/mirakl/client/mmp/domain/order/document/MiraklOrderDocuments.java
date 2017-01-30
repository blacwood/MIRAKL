/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.order.document;

import com.mirakl.client.domain.common.Unicity;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties("total_count")
@Unicity(includeAll = true)
public class MiraklOrderDocuments {

    private List<MiraklOrderDocument> orderDocuments;

    public List<MiraklOrderDocument> getOrderDocuments() {
        return orderDocuments;
    }

    public void setOrderDocuments(List<MiraklOrderDocument> orderDocuments) {
        this.orderDocuments = orderDocuments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklOrderDocuments that = (MiraklOrderDocuments) o;

        return orderDocuments != null ? orderDocuments.equals(that.orderDocuments) : that.orderDocuments == null;

    }

    @Override
    public int hashCode() {
        return orderDocuments != null ? orderDocuments.hashCode() : 0;
    }
}
