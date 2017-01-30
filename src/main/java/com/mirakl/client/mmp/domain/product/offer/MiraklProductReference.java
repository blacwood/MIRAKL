/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.product.offer;

import com.mirakl.client.domain.common.Unicity;
import org.codehaus.jackson.annotate.JsonProperty;

@Unicity(includeAll = true)
public class MiraklProductReference {

    @JsonProperty("reference_type")
    private String type;
    @JsonProperty("reference")
    private String value;

    public MiraklProductReference() {
    }

    public MiraklProductReference(String type, String value) {
        this.type = type;
        this.value = value;
    }

    /**
     * Product reference type. ie: ISBN, EAN...
     */
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
     * Product reference value
     */
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklProductReference that = (MiraklProductReference) o;

        if (type != null ? !type.equals(that.type) : that.type != null) {
            return false;
        }
        return value != null ? value.equals(that.value) : that.value == null;

    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
}
