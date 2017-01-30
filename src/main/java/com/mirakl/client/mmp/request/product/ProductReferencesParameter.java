/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.request.product;

import com.mirakl.client.domain.common.Unicity;
import jersey.repackaged.com.google.common.base.Joiner;

import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Unicity(includeAll = true)
public class ProductReferencesParameter {

    public static final String ID_SEPARATOR = "|";
    public static final String PRODUCT_SEPARATOR = ",";

    private MultivaluedMap<String, String> productReferences;

    public ProductReferencesParameter() {
        this.productReferences = new MultivaluedHashMap<String, String>();
    }

    public void addProductReference(String typeId, String productId) {
        productReferences.add(typeId, productId);
    }

    public String toQueryParam() {
        List<String> references = new ArrayList<String>();

        for (Map.Entry<String, List<String>> entry : productReferences.entrySet()) {
            String key = entry.getKey();
            for (String value : entry.getValue()) {
                references.add(buildQueryParamEntry(key, value));
            }
        }

        return Joiner.on(PRODUCT_SEPARATOR).join(references);
    }

    private String buildQueryParamEntry(String key, String value) {
        return key + ID_SEPARATOR + value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ProductReferencesParameter that = (ProductReferencesParameter) o;

        return productReferences != null ? productReferences.equals(that.productReferences) : that.productReferences == null;

    }

    @Override
    public int hashCode() {
        return productReferences != null ? productReferences.hashCode() : 0;
    }
}
