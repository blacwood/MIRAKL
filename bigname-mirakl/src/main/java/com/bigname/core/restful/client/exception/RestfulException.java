package com.bigname.core.restful.client.exception;

/**
 * Created by Manu on 1/30/2017.
 */
public class RestfulException extends RuntimeException {
    public RestfulException(String message) {
        super(message);
    }

    public RestfulException(String message, Throwable cause) {
        super(message, cause);
    }

    public RestfulException(Throwable cause) {
        super(cause);
    }
}
