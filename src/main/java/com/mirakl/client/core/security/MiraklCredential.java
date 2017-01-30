/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.core.security;


import com.mirakl.client.core.internal.util.Preconditions;

public class MiraklCredential {

    private String apiKey;

    public MiraklCredential(String apiKey) {
        Preconditions.checkNotNull(apiKey, "the apiKey cannot be null");
        this.apiKey = apiKey;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

}
