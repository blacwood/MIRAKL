/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.evaluation;

import com.mirakl.client.domain.common.Unicity;

/**
 * Evaluation criteria
 */
@Unicity(includeAll = true)
public class MiraklAssessment {

    private String code;
    private String label;
    private MiraklAssessmentType type;

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
     * Type of the criteria
     */
    public MiraklAssessmentType getType() {
        return type;
    }

    public void setType(MiraklAssessmentType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklAssessment that = (MiraklAssessment) o;

        if (code != null ? !code.equals(that.code) : that.code != null) {
            return false;
        }
        if (label != null ? !label.equals(that.label) : that.label != null) {
            return false;
        }
        return type == that.type;

    }

    @Override
    public int hashCode() {
        int result = code != null ? code.hashCode() : 0;
        result = 31 * result + (label != null ? label.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
