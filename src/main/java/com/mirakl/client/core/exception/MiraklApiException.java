/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.core.exception;


import com.mirakl.client.core.error.MiraklErrorResponseBean;

public class MiraklApiException extends MiraklException {

    private final MiraklErrorResponseBean error;

    public MiraklApiException(MiraklErrorResponseBean error) {
        super(String.format("[%d] %s", error.getStatus(), error.getMessage()));
        this.error = error;
    }

    public MiraklApiException(MiraklErrorResponseBean error, Exception cause) {
        super(String.format("[%d] %s", error.getStatus(), error.getMessage()), cause);
        this.error = error;
    }

    public MiraklErrorResponseBean getError() {
        return error;
    }

}
