/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.front.domain.order.create;

import com.mirakl.client.domain.common.Unicity;
import org.codehaus.jackson.annotate.JsonProperty;

@Unicity(includeAll = true)
public class MiraklOfferNotShippable {

    @JsonProperty("offer_id")
    private String id;
    @JsonProperty("error_code")
    private MiraklOfferNotShippableReason reason;

    /**
     * ID of the non shippable offer
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public MiraklOfferNotShippableReason getReason() {
        return reason;
    }

    public void setReason(MiraklOfferNotShippableReason reason) {
        this.reason = reason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklOfferNotShippable that = (MiraklOfferNotShippable) o;

        if (id != null ? !id.equals(that.id) : that.id != null) {
            return false;
        }
        return reason == that.reason;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (reason != null ? reason.hashCode() : 0);
        return result;
    }
}
