/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.request.product;

import com.mirakl.client.domain.common.Unicity;

import java.util.Map;

/**
 * @deprecated Please use {@code com.mirakl.client.mmp.front.request.product.MiraklGetProductsRequest},
 * {@code com.mirakl.client.mmp.shop.request.product.MiraklGetProductsRequest} or {@code com.mirakl.client.mmp.operator.request.product.MiraklGetProductsRequest}
 * instead.
 */
@Deprecated
@Unicity(includeAll = true)
public class MiraklGetProductsRequest extends AbstractMiraklGetProductsRequest {

    public MiraklGetProductsRequest(Map<String, String> productReferences) {
        super(productReferences);
    }
}
