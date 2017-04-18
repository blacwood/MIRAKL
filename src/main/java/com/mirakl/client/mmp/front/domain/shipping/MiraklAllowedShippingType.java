/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.front.domain.shipping;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.domain.shipping.MiraklShippingType;
import org.codehaus.jackson.annotate.JsonProperty;

@Unicity(props = "code")
public class MiraklAllowedShippingType extends MiraklShippingType {

    @Override
    @JsonProperty("code")
    public String getCode() {
        return super.getCode();
    }

    @Override
    @JsonProperty("label")
    public String getLabel() {
        return super.getLabel();
    }
}
