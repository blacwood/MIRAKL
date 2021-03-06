/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.order.state;

import com.mirakl.client.domain.common.Unicity;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonUnwrapped;

@Unicity(includeAll = true)
public class MiraklOrderStatus extends AbstractMiraklOrderStatus {

    @JsonUnwrapped
    private MiraklOrderStateReason reason;

    @Override
    @JsonProperty("order_state")
    public State getState() {
        return super.getState();
    }

    public MiraklOrderStateReason getReason() {
        return reason;
    }

    public void setReason(MiraklOrderStateReason reason) {
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
        if (!super.equals(o)) {
            return false;
        }

        MiraklOrderStatus that = (MiraklOrderStatus) o;

        return reason != null ? reason.equals(that.reason) : that.reason == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (reason != null ? reason.hashCode() : 0);
        return result;
    }
}
