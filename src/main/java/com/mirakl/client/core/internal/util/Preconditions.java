/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.core.internal.util;

import com.mirakl.client.core.exception.MiraklRequestValidationException;

public class Preconditions {

    public static void checkNotNull(Object argument) {
        checkNotNull(argument, "argument cannot be null");
    }

    public static void checkNotNull(Object argument, String message) {
        if (argument == null) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void checkArgument(boolean argument, String message){
        if (!argument) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void checkRequiredRequestArgument(Object argument, String argumentName){
        if (argument == null) {
            throw new MiraklRequestValidationException(String.format("%s is required", argumentName));
        }
    }

    public static void checkRequestExpression(boolean expression, String errorMessage){
        if (!expression) {
            throw new MiraklRequestValidationException(String.valueOf(errorMessage));
        }
    }
}
