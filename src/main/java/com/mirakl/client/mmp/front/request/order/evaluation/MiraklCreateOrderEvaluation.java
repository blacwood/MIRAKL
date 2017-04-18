/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.front.request.order.evaluation;

import com.mirakl.client.domain.common.Unicity;

import java.util.List;

@Unicity(includeAll = true)
public class MiraklCreateOrderEvaluation {

    private List<MiraklCreateOrderEvaluationAssessment> assessments;
    private String comment;
    private int grade;
    private boolean visible = true;

    public List<MiraklCreateOrderEvaluationAssessment> getAssessments() {
        return assessments;
    }

    /**
     * List of evaluation criterias
     */
    public void setAssessments(List<MiraklCreateOrderEvaluationAssessment> assessments) {
        this.assessments = assessments;
    }

    public String getComment() {
        return comment;
    }

    /**
     * Comment on the evaluation
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getGrade() {
        return grade;
    }

    /**
     * Value of the grade, must be between 0 à 5
     */
    public void setGrade(int grade) {
        this.grade = grade;
    }

    public boolean isVisible() {
        return visible;
    }

    /**
     * Evaluation visibility
     */
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklCreateOrderEvaluation that = (MiraklCreateOrderEvaluation) o;

        if (grade != that.grade) {
            return false;
        }
        if (visible != that.visible) {
            return false;
        }
        if (assessments != null ? !assessments.equals(that.assessments) : that.assessments != null) {
            return false;
        }
        return comment != null ? comment.equals(that.comment) : that.comment == null;

    }

    @Override
    public int hashCode() {
        int result = assessments != null ? assessments.hashCode() : 0;
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + grade;
        result = 31 * result + (visible ? 1 : 0);
        return result;
    }
}
