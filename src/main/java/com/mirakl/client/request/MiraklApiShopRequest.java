/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.request;

public interface MiraklApiShopRequest {

    /**
     * The id of the shop to be used for the request. This is useful is the user have multiple shops. The specified shop
     * will be used for the API call. If {@code null}, the first shop associated to the user will be used.
     */
    String getShopId();
}
