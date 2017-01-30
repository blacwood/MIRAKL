/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.offer.importer;

import com.mirakl.client.domain.common.Unicity;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import com.mirakl.client.mmp.domain.common.OfferImportStatus;

import java.util.Date;

@JsonIgnoreProperties("type")
@Unicity(includeAll = true)
public class MiraklOfferImportResult {

    private ImportMode mode;
    private Integer offerDeleted;
    private Integer offerInserted;
    private Integer offerUpdated;
    private String importId;
    private Date dateCreated;
    private OfferImportStatus status;
    private Integer linesRead;
    private Integer linesInSuccess;
    private Integer linesInError;
    @JsonProperty("has_error_report")
    private boolean errorReport;
    private String reasonStatus;

    /**
     * Unique identifier of the import
     */
    public String getImportId() {
        return importId;
    }

    /**
     * Creation date of the import
     */
    public Date getDateCreated() {
        return dateCreated;
    }

    /**
     * Status of the import
     */
    public OfferImportStatus getStatus() {
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
     * Does the import has an error report
     */
    public boolean hasErrorReport() {
        return errorReport;
    }

    /**
     * Import Mode
     */
    public ImportMode getMode() {
        return mode;
    }

    /**
     * Number of offers deleted
     */
    public Integer getOfferDeleted() {
        return offerDeleted;
    }

    /**
     * Number of offers inserted
     */
    public Integer getOfferInserted() {
        return offerInserted;
    }

    /**
     * Numver of offers updated
     */
    public Integer getOfferUpdated() {
        return offerUpdated;
    }

    public void setMode(ImportMode mode) {
        this.mode = mode;
    }

    public void setOfferDeleted(Integer offerDeleted) {
        this.offerDeleted = offerDeleted;
    }

    public void setOfferInserted(Integer offerInserted) {
        this.offerInserted = offerInserted;
    }

    public void setOfferUpdated(Integer offerUpdated) {
        this.offerUpdated = offerUpdated;
    }

    public void setImportId(String importId) {
        this.importId = importId;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setStatus(OfferImportStatus status) {
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

    /**
     * A message explaining the reason of the import status, if relevant
     */
    public String getReasonStatus() {
        return reasonStatus;
    }

    public void setReasonStatus(String reasonStatus) {
        this.reasonStatus = reasonStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklOfferImportResult that = (MiraklOfferImportResult) o;

        if (errorReport != that.errorReport) {
            return false;
        }
        if (mode != that.mode) {
            return false;
        }
        if (offerDeleted != null ? !offerDeleted.equals(that.offerDeleted) : that.offerDeleted != null) {
            return false;
        }
        if (offerInserted != null ? !offerInserted.equals(that.offerInserted) : that.offerInserted != null) {
            return false;
        }
        if (offerUpdated != null ? !offerUpdated.equals(that.offerUpdated) : that.offerUpdated != null) {
            return false;
        }
        if (importId != null ? !importId.equals(that.importId) : that.importId != null) {
            return false;
        }
        if (dateCreated != null ? !dateCreated.equals(that.dateCreated) : that.dateCreated != null) {
            return false;
        }
        if (status != that.status) {
            return false;
        }
        if (linesRead != null ? !linesRead.equals(that.linesRead) : that.linesRead != null) {
            return false;
        }
        if (linesInSuccess != null ? !linesInSuccess.equals(that.linesInSuccess) : that.linesInSuccess != null) {
            return false;
        }
        if (linesInError != null ? !linesInError.equals(that.linesInError) : that.linesInError != null) {
            return false;
        }
        return reasonStatus != null ? reasonStatus.equals(that.reasonStatus) : that.reasonStatus == null;

    }

    @Override
    public int hashCode() {
        int result = mode != null ? mode.hashCode() : 0;
        result = 31 * result + (offerDeleted != null ? offerDeleted.hashCode() : 0);
        result = 31 * result + (offerInserted != null ? offerInserted.hashCode() : 0);
        result = 31 * result + (offerUpdated != null ? offerUpdated.hashCode() : 0);
        result = 31 * result + (importId != null ? importId.hashCode() : 0);
        result = 31 * result + (dateCreated != null ? dateCreated.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (linesRead != null ? linesRead.hashCode() : 0);
        result = 31 * result + (linesInSuccess != null ? linesInSuccess.hashCode() : 0);
        result = 31 * result + (linesInError != null ? linesInError.hashCode() : 0);
        result = 31 * result + (errorReport ? 1 : 0);
        result = 31 * result + (reasonStatus != null ? reasonStatus.hashCode() : 0);
        return result;
    }
}
