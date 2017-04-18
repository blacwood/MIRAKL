/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.front.core.internal;

import com.mirakl.client.core.internal.MiraklApiEndpoint;

public enum MiraklFrontApiEndpoint implements MiraklApiEndpoint {

    BI01("bi"),

    OF42("offers", "{offer}", "messages"),

    OR01("orders"),
    OR02("orders", "valid", "{commercial_id}"),
    OR03("orders", "invalid", "{commercial_id}"),
    OR52("orders", "{order}", "evaluation"),

    SH01("shipping", "fees"),
    SH02("shipping", "rates"),

    TL01("transactions_logs"),

    Q01("quote_request"),
    Q02("quote_request", "{quote_request_id}", "valid"),
    Q03("quote_request", "{quote_request_id}", "invalid"),
    Q04("quote_request"),
    Q05("quote_request", "message"),
    Q06("quote_request", "message", "{quote_request_message_id}", "documents"),
    Q07("quote_request", "{quote_id}", "place");

    private final String[] paths;

    MiraklFrontApiEndpoint(String... paths) {
        this.paths = paths;
    }

    @Override
    public String[] getPaths() {
        return paths;
    }

}
