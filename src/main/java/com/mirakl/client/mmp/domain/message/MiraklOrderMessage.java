/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.message;

import com.mirakl.client.domain.common.Unicity;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties({
        "visible", "offer_id", "read", "archived", "to_shop_archived", "to_customer_archived", "to_operator_archived"
})
@Unicity(props = "id")
public class MiraklOrderMessage extends AbstractMiraklMessage {

    private String orderId;
    private String commercialId;


    private List<MiraklMessageDocument> documents;

    /**
     * Order ID related to the message
     */
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * Order commercial ID related to the message
     */
    public String getCommercialId() {
        return commercialId;
    }

    public void setCommercialId(String commercialId) {
        this.commercialId = commercialId;
    }

    /**
     * Documents linked to the message
     */
    public List<MiraklMessageDocument> getDocuments() {
        return documents;
    }

    public void setDocuments(List<MiraklMessageDocument> documents) {
        this.documents = documents;
    }
}
