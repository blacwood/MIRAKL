/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.message;

import com.mirakl.client.domain.common.Unicity;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties({
        "order_id", "commercial_id", "read", "archived", "to_shop_archived", "to_customer_archived", "to_operator_archived"
})
@Unicity(props = "id")
public class MiraklOfferMessage extends AbstractMiraklMessage {

    private String offerId;
    private boolean visible;

    /**
     * Offer ID related to the message
     */
    public String getOfferId() {
        return offerId;
    }

    public void setOfferId(String offerId) {
        this.offerId = offerId;
    }

    /**
     * Visibility of the message (should it be displayed on the front?)
     */
    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

}
