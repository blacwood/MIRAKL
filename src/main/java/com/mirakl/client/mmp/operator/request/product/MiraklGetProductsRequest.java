/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.operator.request.product;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.request.product.AbstractMiraklGetProductsRequest;
import com.mirakl.client.mmp.request.product.ProductReferencesParameter;

@Unicity(includeAll = true)
public class MiraklGetProductsRequest extends AbstractMiraklGetProductsRequest {

    public MiraklGetProductsRequest(ProductReferencesParameter productReferencesByType) {
        super(productReferencesByType);
    }
}
