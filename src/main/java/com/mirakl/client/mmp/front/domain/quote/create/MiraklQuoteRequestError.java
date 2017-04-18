/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.front.domain.quote.create;

import com.mirakl.client.domain.common.Unicity;

import java.util.List;
@Unicity(props = "input")
public class MiraklQuoteRequestError {

    private MiraklCreateQuoteRequest input;
    private List<MiraklQuoteRequestErrorBean> errors;

    public MiraklCreateQuoteRequest getInput() {
        return input;
    }

    public void setInput(MiraklCreateQuoteRequest input) {
        this.input = input;
    }

    public List<MiraklQuoteRequestErrorBean> getErrors() {
        return errors;
    }

    public void setErrors(List<MiraklQuoteRequestErrorBean> errors) {
        this.errors = errors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MiraklQuoteRequestError that = (MiraklQuoteRequestError) o;

        return input != null ? input.equals(that.input) : that.input == null;

    }

    @Override
    public int hashCode() {
        return input != null ? input.hashCode() : 0;
    }
}
