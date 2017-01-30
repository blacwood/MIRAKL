/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.common.synchro;

import com.mirakl.client.domain.common.Unicity;
import org.codehaus.jackson.annotate.JsonProperty;
import com.mirakl.client.domain.common.MiraklProcessTrackingStatus;

import java.util.Date;

@Unicity(props = "synchroId")
public abstract class AbstractMiraklSynchroResult {

    private String synchroId;
    private Date dateCreated;
    private MiraklProcessTrackingStatus status;

    private Integer linesRead;
    private Integer linesInSuccess;
    private Integer linesInError;

    @JsonProperty("has_error_report")
    private boolean errorReport;

    /**
     * Unique identifier of the synchro
     */
    public String getSynchroId() {
        return synchroId;
    }

    /**
     * Creation date of the synchro
     */
    public Date getDateCreated() {
        return dateCreated;
    }

    /**
     * Status of the synchro
     */
    public MiraklProcessTrackingStatus getStatus() {
        return status;
    }

    /**
     * Number of lines read in the input file
     */
    public Integer getLinesRead() {
        return linesRead;
    }

    /**
     * Number of lines treated as success in the input file
     */
    public Integer getLinesInSuccess() {
        return linesInSuccess;
    }

    /**
     * Number of lines in error in the input file
     */
    public Integer getLinesInError() {
        return linesInError;
    }

    /**
     * Does the synchro has an error report
     */
    public boolean hasErrorReport() {
        return errorReport;
    }

    public void setSynchroId(String synchroId) {
        this.synchroId = synchroId;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setStatus(MiraklProcessTrackingStatus status) {
        this.status = status;
    }

    public void setLinesRead(Integer linesRead) {
        this.linesRead = linesRead;
    }

    public void setLinesInSuccess(Integer linesInSuccess) {
        this.linesInSuccess = linesInSuccess;
    }

    public void setLinesInError(Integer linesInError) {
        this.linesInError = linesInError;
    }

    public void setErrorReport(boolean errorReport) {
        this.errorReport = errorReport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AbstractMiraklSynchroResult that = (AbstractMiraklSynchroResult) o;

        return synchroId != null ? synchroId.equals(that.synchroId) : that.synchroId == null;

    }

    @Override
    public int hashCode() {
        return synchroId != null ? synchroId.hashCode() : 0;
    }
}
