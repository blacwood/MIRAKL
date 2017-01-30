/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.core.internal;

import com.mirakl.client.core.internal.MiraklApiEndpoint;

public enum MiraklFrontOperatorApiEndpoint implements MiraklApiEndpoint {

    CA01("categories", "synchros"),
    CA02("categories", "synchros", "{synchro}"),
    CA03("categories", "synchros", "{synchro}", "error_report"),

    EV01("evaluations", "assessments"),

    L01("locales"),

    OF51("offers", "export"),

    OR25("orders", "{order}", "receive"),
    OR27("orders", "{order}", "to_collect"),
    OR29("orders", "{order}", "cancel"),
    OR30("orders", "cancel"),
    OR62("orders", "{order}", "lines", "{line}", "open_incident"),
    OR63("orders", "{order}", "lines", "{line}", "close_incident"),

    P21("products", "synchros"),
    P22("products", "synchros", "{synchro}"),
    P23("products", "synchros", "{synchro}", "error_report"),

    PA01("payment", "debit"),
    PA02("payment", "refund"),

    RE01("reasons"),

    S03("shops", "{shop}", "evaluations"),
    S04("shops", "{shop}", "offers"),
    S06("shops"),
    S07("shops"),
    S20("shops"),
    ;

    private final String[] paths;

    MiraklFrontOperatorApiEndpoint(String... paths) {
        this.paths = paths;
    }

    @Override
    public String[] getPaths() {
        return paths;
    }

}
