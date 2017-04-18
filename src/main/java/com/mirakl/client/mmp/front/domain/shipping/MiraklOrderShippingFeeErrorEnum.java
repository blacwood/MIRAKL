/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.front.domain.shipping;

public enum MiraklOrderShippingFeeErrorEnum {

    /**
     * If offer is not allowed for the shipping zone
     */
    SHIPPING_ZONE_NOT_ALLOWED,

    /**
     * If offer is not allowed for the shipping type
     */
    SHIPPING_TYPE_NOT_ALLOWED,

    /**
     * If offer is not found
     */
    OFFER_NOT_FOUND;
}
