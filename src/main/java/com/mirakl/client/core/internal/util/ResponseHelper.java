/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.core.internal.util;

import com.mirakl.client.core.error.MiraklErrorResponseBean;
import com.mirakl.client.core.exception.MiraklApiException;
import com.mirakl.client.core.exception.MiraklException;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import java.util.logging.Logger;

import static com.mirakl.client.core.error.MiraklErrorResponseBeanParser.parseErrorFromResponse;
import static javax.ws.rs.core.Response.Status.CREATED;
import static javax.ws.rs.core.Response.Status.NO_CONTENT;

public class ResponseHelper {

    private static final Logger LOGGER = Logger.getLogger(ResponseHelper.class.getName());

    private ResponseHelper() {
        //should not be instantiated
    }

    /**
     * Checking that the status of the response is 204 - NO_CONTENT
     * @param response response object to check
     * @throws MiraklException if the status of the response does not match the expected status
     */
    public static void checkStatusNoContent(Response response){
        checkStatus(response, NO_CONTENT.getStatusCode());
    }

    /**
     * Checking that the status of the response is 201 - CREATED
     * @param response response object to check
     * @throws MiraklException if the status of the response does not match the expected status
     */
    public static void checkStatusCreated(Response response){
        checkStatus(response, CREATED.getStatusCode());

    }

    private static void checkStatus(Response response, int expectedStatusCode) {
        int responseStatusCode = response.getStatus();

        if(responseStatusCode != expectedStatusCode){
            LOGGER.severe("unexpected status, expecting " + expectedStatusCode + " but was " + responseStatusCode);

            if(responseIsErrorWithBody(response)){
                MiraklErrorResponseBean error = parseErrorFromResponse(response);
                throw new MiraklApiException(error, new WebApplicationException(responseStatusCode));
            } else {
                throw new MiraklException(String.format("Unexpected status, expecting %d but was %d", expectedStatusCode, responseStatusCode));
            }

        }
    }

    private static boolean responseIsErrorWithBody(Response response){
        return response.getStatusInfo().getFamily() != Response.Status.Family.SUCCESSFUL && response.hasEntity();
    }
}
