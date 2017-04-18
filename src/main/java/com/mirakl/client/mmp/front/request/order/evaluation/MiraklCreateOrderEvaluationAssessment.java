/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.front.request.order.evaluation;

import com.mirakl.client.domain.common.Unicity;

@Unicity(includeAll = true)
public class MiraklCreateOrderEvaluationAssessment {

    private String code;
    private String response;

    public MiraklCreateOrderEvaluationAssessment(String code, String response) {
        this.code = code;
        this.response = response;
    }

    public String getCode() {
        return code;
    }

    /**
     * Code of the assesment
     */
    public void setCode(String code) {
        this.code = code;
    }

    public String getResponse() {
        return response;
    }

    /**
     * Value of the assesment<br/>
     * It could be a grade from 0 to 5 or a true/false anwser.
     */
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

        MiraklCreateOrderEvaluationAssessment that = (MiraklCreateOrderEvaluationAssessment) o;

        if (code != null ? !code.equals(that.code) : that.code != null) {
            return false;
        }
        return response != null ? response.equals(that.response) : that.response == null;

    }

    @Override
    public int hashCode() {
        int result = code != null ? code.hashCode() : 0;
        result = 31 * result + (response != null ? response.hashCode() : 0);
        return result;
    }
}
