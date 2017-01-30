/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.order.state;

import com.mirakl.client.domain.common.Unicity;
import org.codehaus.jackson.annotate.JsonProperty;

@Unicity(props = "code")
public class MiraklOrderLineStateReason extends AbstractMiraklOrderStateReason {

    @Override
    @JsonProperty("order_line_state_reason_code")
    public String getCode() {
        return super.getCode();
    }

    @Override
    @JsonProperty("order_line_state_reason_label")
    public String getLabel() {
        return super.getLabel();
    }
}
