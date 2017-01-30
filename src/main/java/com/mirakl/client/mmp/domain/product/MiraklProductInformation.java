/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.product;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.domain.category.MiraklCategoryInformation;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonUnwrapped;

@Unicity(props = "sku")
public class MiraklProductInformation {

    @JsonProperty("product_sku")
    private String sku;

    @JsonProperty("product_title")
    private String title;

    @JsonUnwrapped
    private MiraklCategoryInformation category;

    /**
     * Offer product SKU
     */
    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    /**
     * Offer product title
     */
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MiraklCategoryInformation getCategory() {
        return category;
    }

    public void setCategory(MiraklCategoryInformation category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklProductInformation that = (MiraklProductInformation) o;

        return sku != null ? sku.equals(that.sku) : that.sku == null;

    }

    @Override
    public int hashCode() {
        return sku != null ? sku.hashCode() : 0;
    }
}
