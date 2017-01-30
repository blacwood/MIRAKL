/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.request.product;

import com.mirakl.client.core.internal.MiraklApiEndpoint;
import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.core.internal.MiraklMarketplacePlatformCommonApiEndpoint;
import com.mirakl.client.core.internal.util.MiraklApiUtils;
import com.mirakl.client.request.common.AbstractMiraklPaginationRequest;

import java.util.Map;

@Unicity(includeAll = true)
public abstract class AbstractMiraklGetProductsRequest extends AbstractMiraklPaginationRequest {

    private Map<String, String> productReferences;
    private ProductReferencesParameter productReferencesByType;

    public AbstractMiraklGetProductsRequest(ProductReferencesParameter productReferencesByType) {
        this.productReferencesByType = productReferencesByType;
    }

    @Deprecated
    public AbstractMiraklGetProductsRequest(Map<String, String> productReferences) {
        setProductReferences(productReferences);
    }

    @Override
    public MiraklApiEndpoint getEndpoint() {
        return MiraklMarketplacePlatformCommonApiEndpoint.P31;
    }

    public Map<String, String> getProductReferences() {
        return productReferences;
    }

    /**
     * REQUIRED - Filter products by product references by using a map with the product ID as key and the product ID type as value.
     * For instance {@code productReferences.put("3120201243238", "EAN");}<br/>
     * The map cannot have more than 100 entries.
     */
    public void setProductReferences(Map<String, String> productReferences) {
        checkRequiredArgument(productReferences, "productReferences");
        this.productReferences = productReferences;
    }

    @Override
    public Map<String, String> getQueryParams() {
        Map<String, String> params = super.getQueryParams();

        if (productReferences != null) {
            params.put("products", MiraklApiUtils.convertMapToStringParam(productReferences));
        }

        if (productReferencesByType != null) {
            params.put("product_references", productReferencesByType.toQueryParam());
        }

        return params;
    }

    public ProductReferencesParameter getProductReferencesByType() {
        return productReferencesByType;
    }

    /**
     * REQUIRED - Filter products by product references by using a map with the product ID type as key and the product ID as value.
     * For instance {@code productReferences.put("EAN", "3120201243238");}<br/>
     * The map cannot have more than 100 entries.
     */
    public void setProductReferencesByType(ProductReferencesParameter productReferencesByType) {
        checkRequiredArgument(productReferencesByType, "productReferencesByType");
        this.productReferencesByType = productReferencesByType;
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

        AbstractMiraklGetProductsRequest that = (AbstractMiraklGetProductsRequest) o;

        if (productReferences != null ? !productReferences.equals(that.productReferences) : that.productReferences != null) {
            return false;
        }
        return productReferencesByType != null ? productReferencesByType.equals(that.productReferencesByType) : that.productReferencesByType == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (productReferences != null ? productReferences.hashCode() : 0);
        result = 31 * result + (productReferencesByType != null ? productReferencesByType.hashCode() : 0);
        return result;
    }
}
