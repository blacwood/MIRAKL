/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.core.internal;

public enum MiraklOperatorShopApiEndpoint implements MiraklApiEndpoint {

    IV01("invoices"),
    IV02("invoices", "{invoice}"),

    OF01("offers", "imports"),
    OF02("offers", "imports", "{import}"),
    OF03("offers", "imports", "{import}", "error_report"),

    OF24("offers"),

    OR28("orders", "refund");

    private final String[] paths;

    MiraklOperatorShopApiEndpoint(String... paths) {
        this.paths = paths;
    }

    @Override
    public String[] getPaths() {
        return paths;
    }

}
