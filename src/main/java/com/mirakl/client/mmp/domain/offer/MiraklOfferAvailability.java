/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.offer;

import com.mirakl.client.domain.common.Unicity;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.Date;

@Unicity(includeAll = true)
public class MiraklOfferAvailability {

    @JsonProperty("available_start_date")
    private Date startDate;

    @JsonProperty("available_end_date")
    private Date endDate;

    /**
     * Availability period start
     */
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Availability period end
     */
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklOfferAvailability that = (MiraklOfferAvailability) o;

        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) {
            return false;
        }
        return endDate != null ? endDate.equals(that.endDate) : that.endDate == null;

    }

    @Override
    public int hashCode() {
        int result = startDate != null ? startDate.hashCode() : 0;
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        return result;
    }
}