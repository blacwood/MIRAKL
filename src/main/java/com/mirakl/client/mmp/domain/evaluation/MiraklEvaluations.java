/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.evaluation;

import com.mirakl.client.domain.common.Unicity;

import java.util.List;

@Unicity(includeAll = true)
public class MiraklEvaluations {

    private List<MiraklEvaluation> evaluations;
    private long totalCount;

    public List<MiraklEvaluation> getEvaluations() {
        return evaluations;
    }

    public void setEvaluations(List<MiraklEvaluation> evaluations) {
        this.evaluations = evaluations;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklEvaluations that = (MiraklEvaluations) o;

        if (totalCount != that.totalCount) {
            return false;
        }
        return evaluations != null ? evaluations.equals(that.evaluations) : that.evaluations == null;

    }

    @Override
    public int hashCode() {
        int result = evaluations != null ? evaluations.hashCode() : 0;
        result = 31 * result + (int) (totalCount ^ (totalCount >>> 32));
        return result;
    }
}
