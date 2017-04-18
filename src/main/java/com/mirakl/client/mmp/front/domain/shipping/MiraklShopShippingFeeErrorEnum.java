/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.front.domain.shipping;

public enum MiraklShopShippingFeeErrorEnum {
    /**
     * If shop is not allowed for the shipping zone
     */
    SHIPPING_ZONE_NOT_ALLOWED,
    /**
     * If the shipping type, defined in the query param, is not allowed for the shop
     */
    SHIPPING_TYPE_NOT_ALLOWED,
}
