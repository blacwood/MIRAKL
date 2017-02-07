package com.bigname.core.restful.client.util;

/**
 * Created by Manu on 2/7/2017.
 */
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

    /*public static void checkRequiredRequestArgument(Object argument, String argumentName){
        if (argument == null) {
            throw new MiraklRequestValidationException(String.format("%s is required", argumentName));
        }
    }

    public static void checkRequestExpression(boolean expression, String errorMessage){
        if (!expression) {
            throw new MiraklRequestValidationException(String.valueOf(errorMessage));
        }
    }*/
}
