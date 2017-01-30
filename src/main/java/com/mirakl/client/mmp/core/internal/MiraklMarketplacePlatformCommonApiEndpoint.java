/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.core.internal;

import com.mirakl.client.core.internal.MiraklApiEndpoint;

public enum MiraklMarketplacePlatformCommonApiEndpoint implements MiraklApiEndpoint {

    AF01("additional_fields"),

    M01("messages"),

    OF22("offers", "{offer}"),

    OF61("offers", "states"),

    OR11("orders"),
    OR21("orders", "{order}", "accept"),
    OR23("orders", "{order_id}", "tracking"),
    OR31("orders", "{order_id}", "additional_fields"),
    OR24("orders", "{order}", "ship"),
    OR42("orders", "{order}", "messages"),

    OR72("orders", "documents"),
    OR73("orders", "documents", "download"),
    OR74("orders", "{order}", "documents"),
    OR75("orders", "taxes"),

    P11("products", "offers"),
    P31("products"),

    SH21("shipping", "carriers"),

    S30("shops", "documents"),
    S31("shops", "documents", "download"),
    S32("shops", "documents"),

    V01("version"),
    ;

    private final String[] paths;

    MiraklMarketplacePlatformCommonApiEndpoint(String... paths) {
        this.paths = paths;
    }

    @Override
    public String[] getPaths() {
        return paths;
    }
}
