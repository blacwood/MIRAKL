/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.request;

import com.mirakl.client.core.internal.MiraklApiEndpoint;

import java.util.Map;

public interface MiraklApiRequest {

    /**
     * Get the request endpoint to access an API
     *
     * @return MiraklApiEndpoint which represent the URL used to access a specific Mirakl API
     */
    MiraklApiEndpoint getEndpoint();

    /**
     * Get the request endpoint's params
     * IE synchro in CA03 enpoint : categories/synchros/{synchro}/error_report
     *
     * @return Map of params name as key and params value as value
     */
    Map<String, String> getRequestTemplates();

    /**
     * Get the request query params required to access an API
     *
     * @return Map of params name as key and params value as value
     */
    Map<String, String> getQueryParams();

    /**
     * Check the integrity of the request
     * For instance make sure that required parmas are set
     */
//    void validate();

    /**
     * Check that the request has been validated by the client
     */
//    boolean isValidated();
}
