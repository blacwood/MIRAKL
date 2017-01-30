/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.evaluation;

import com.mirakl.client.domain.common.Unicity;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties("total_count")
@Unicity(includeAll = true)
public class MiraklAssessments {

    private List<MiraklAssessment> assessments;

    public List<MiraklAssessment> getAssessments() {
        return assessments;
    }

    public void setAssessments(List<MiraklAssessment> assessments) {
        this.assessments = assessments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklAssessments that = (MiraklAssessments) o;

        return assessments != null ? assessments.equals(that.assessments) : that.assessments == null;

    }

    @Override
    public int hashCode() {
        return assessments != null ? assessments.hashCode() : 0;
    }
}
