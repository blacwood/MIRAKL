/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.core.exception;

public class MiraklException extends RuntimeException {

    public MiraklException(String message) {
        super(message);
    }

    public MiraklException(Throwable cause) {
        super(cause);
    }

    public MiraklException(String message, Throwable cause) {
        super(message, cause);
    }

}
