/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.evaluation;

import com.mirakl.client.domain.common.Unicity;

/**
 * Evaluation criteria response
 */
@Unicity(includeAll = true)
public class MiraklAssessmentResponse {

    private String code;
    private String label;
    private String response;

    /**
     * Code of the assesment
     */
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Label of the assesment
     */
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * Value of this criteria input by the customer.
     * It could be a true/false response or a grade from 0 to 5
     */
    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklAssessmentResponse that = (MiraklAssessmentResponse) o;

        if (code != null ? !code.equals(that.code) : that.code != null) {
            return false;
        }
        if (label != null ? !label.equals(that.label) : that.label != null) {
            return false;
        }
        return response != null ? response.equals(that.response) : that.response == null;

    }

    @Override
    public int hashCode() {
        int result = code != null ? code.hashCode() : 0;
        result = 31 * result + (label != null ? label.hashCode() : 0);
        result = 31 * result + (response != null ? response.hashCode() : 0);
        return result;
    }
}
