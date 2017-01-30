/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.core.http;

import javax.ws.rs.core.Response;

/**
 * Custom enum for http status codes that are not present in the javax.ws.rs.core.Response.Status enum
 */
public enum Status implements Response.StatusType{

    /**
     * 429 TOO MANY REQUESTS
     */
    TOO_MANY_REQUEST(429,"Too many requests");

    private final int code;
    private final String reason;
    private final Response.Status.Family family;

    Status(final int statusCode, final String reasonPhrase) {
        this.code = statusCode;
        this.reason = reasonPhrase;
        this.family = Response.Status.Family.familyOf(statusCode);
    }

    /**
     * Get the class of status code.
     *
     * @return the class of status code.
     */
    @Override
    public Response.Status.Family getFamily() {
        return family;
    }

    /**
     * Get the associated status code.
     *
     * @return the status code.
     */
    @Override
    public int getStatusCode() {
        return code;
    }

    /**
     * Get the reason phrase.
     *
     * @return the reason phrase.
     */
    @Override
    public String getReasonPhrase() {
        return toString();
    }

    /**
     * Get the reason phrase.
     *
     * @return the reason phrase.
     */
    @Override
    public String toString() {
        return reason;
    }

}