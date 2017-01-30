/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.domain.common.error;

import com.mirakl.client.domain.common.Unicity;

import java.util.HashSet;
import java.util.Set;

@Unicity(includeAll = true)
public abstract class InputWithErrors<T> {

    private T input;
    private Set<ErrorBean> errors = new HashSet<ErrorBean>();

    public T getInput() {
        return input;
    }

    public void setInput(T input) {
        this.input = input;
    }

    public Set<ErrorBean> getErrors() {
        return errors;
    }

    public void setErrors(Set<ErrorBean> errors) {
        this.errors = errors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        InputWithErrors<?> that = (InputWithErrors<?>) o;

        if (input != null ? !input.equals(that.input) : that.input != null) {
            return false;
        }
        return errors != null ? errors.equals(that.errors) : that.errors == null;

    }

    @Override
    public int hashCode() {
        int result = input != null ? input.hashCode() : 0;
        result = 31 * result + (errors != null ? errors.hashCode() : 0);
        return result;
    }
}