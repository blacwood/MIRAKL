/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.request;

import com.mirakl.client.core.internal.util.Preconditions;
import com.mirakl.client.domain.common.Unicity;

import java.util.HashMap;
import java.util.Map;

@Unicity(includeAll = true)
public abstract class AbstractMiraklApiRequest implements MiraklApiRequest {

    /**
     * Get requestTemplates default value
     *
     * @return An empty map instead of null to avoid unnecessary checking
     */
    public Map<String, String> getRequestTemplates() {
        return new HashMap<String, String>();
    }

    /**
     * Get queryParams default value
     *
     * @return An empty map instead of null to avoid unnecessary checking
     */
    @Override
    public Map<String, String> getQueryParams() {
        return new HashMap<String, String>();
    }

    protected void checkExpression(boolean expression, String errorMessage){
        Preconditions.checkRequestExpression(expression,errorMessage);
    }

    protected void checkRequiredArgument(Object argument, String argumentName){
        Preconditions.checkRequiredRequestArgument(argument,argumentName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklApiRequest that = (MiraklApiRequest) o;

        return getEndpoint() != null ? getEndpoint().equals(that.getEndpoint()) : that.getEndpoint() == null;

    }

    @Override
    public int hashCode() {
        return getEndpoint() != null ? getEndpoint().hashCode() : 0;
    }


}
