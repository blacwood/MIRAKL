/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.category;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.domain.enums.CategoryType;
import org.codehaus.jackson.annotate.JsonProperty;

@Unicity(props = "code")
public class MiraklCategoryInformation {

    @JsonProperty("category_code")
    private String code;

    @JsonProperty("category_label")
    private String label;

    @JsonProperty("category_type")
    private CategoryType categoryType;

    /**
     * Category code of the product on the offer
     */
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Category label of the product on the offer
     */
    public String getLabel() {
        return label;
    }

    public void setCategoryLabel(String label) {
        this.label = label;
    }

    public CategoryType getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(CategoryType categoryType) {
        this.categoryType = categoryType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklCategoryInformation that = (MiraklCategoryInformation) o;

        return code != null ? code.equals(that.code) : that.code == null;

    }

    @Override
    public int hashCode() {
        return code != null ? code.hashCode() : 0;
    }
}
