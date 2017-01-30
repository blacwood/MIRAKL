package com.bigname.core.restful.client.exception;

import com.bigname.core.restful.client.error.ErrorResponse;

/**
 * Created by Manu on 1/30/2017.
 */
public class ApiException extends RestfulException {
    private final ErrorResponse error;

    public ApiException(ErrorResponse error) {
        super(String.format("[%d] %s", error.getStatus(), error.getMessage()));
        this.error = error;
    }

    public ApiException(ErrorResponse error, Exception cause) {
        super(String.format("[%d] %s", error.getStatus(), error.getMessage()), cause);
        this.error = error;
    }

    public ErrorResponse getError() {
        return error;
    }
}
