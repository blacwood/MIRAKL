/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.additionalfield;

import com.mirakl.client.domain.common.Unicity;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.List;

/**
 * Only used to wrap AF01 result
 */
@JsonIgnoreProperties("total_count")
@Unicity(props = "additionalFields")
public abstract class AbstractMiraklAdditionalFields<T extends AbstractMiraklAdditionalField> {

    private List<T> additionalFields;

    public List<T> getAdditionalFields() {
        return additionalFields;
    }

    public void setAdditionalFields(List<T> additionalFields) {
        this.additionalFields = additionalFields;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AbstractMiraklAdditionalFields that = (AbstractMiraklAdditionalFields) o;

        return additionalFields != null ? additionalFields.equals(that.additionalFields) : that.additionalFields == null;

    }

    @Override
    public int hashCode() {
        return additionalFields != null ? additionalFields.hashCode() : 0;
    }
}
