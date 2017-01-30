/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.shipping;

import com.mirakl.client.mmp.domain.common.MiraklAdditionalFieldValue;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

public class MiraklShippingTypeWithConfiguration extends MiraklShippingType {

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

    @JsonProperty("shipping_additional_fields")
    private List<MiraklAdditionalFieldValue> additionalFieldsValues;

    public List<MiraklAdditionalFieldValue> getAdditionalFieldsValues() {
        return additionalFieldsValues;
    }

    public void setAdditionalFieldsValues(List<MiraklAdditionalFieldValue> additionalFields) {
        this.additionalFieldsValues = additionalFields;
    }
}
