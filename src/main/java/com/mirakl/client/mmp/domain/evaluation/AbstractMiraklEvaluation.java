/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.evaluation;

import com.mirakl.client.domain.common.Unicity;

import java.util.Date;
import java.util.List;

@Unicity(includeAll = true)
public abstract class AbstractMiraklEvaluation {

    private String firstname;
    private String lastname;
    private String customerId;
    private String comment;
    private int grade;
    private Date date;
    private List<MiraklAssessmentResponse> assessments;

    /**
     * Customer first name
     */
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Customer last name
     */
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Customer ID
     */
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * Evaluation comment
     */
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * Evaluation grave (within 0 and 5)
     */
    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    /**
     * Evaluation creation date
     */
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Assessments list for this evaluation
     */
    public List<MiraklAssessmentResponse> getAssessments() {
        return assessments;
    }

    public void setAssessments(List<MiraklAssessmentResponse> assessments) {
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

        AbstractMiraklEvaluation that = (AbstractMiraklEvaluation) o;

        if (grade != that.grade) {
            return false;
        }
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) {
            return false;
        }
        if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) {
            return false;
        }
        if (customerId != null ? !customerId.equals(that.customerId) : that.customerId != null) {
            return false;
        }
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) {
            return false;
        }
        if (date != null ? !date.equals(that.date) : that.date != null) {
            return false;
        }
        return assessments != null ? assessments.equals(that.assessments) : that.assessments == null;

    }

    @Override
    public int hashCode() {
        int result = firstname != null ? firstname.hashCode() : 0;
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + grade;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (assessments != null ? assessments.hashCode() : 0);
        return result;
    }
}
