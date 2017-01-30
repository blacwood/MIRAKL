/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.request.payment.invoice;

import com.mirakl.client.core.internal.MiraklApiEndpoint;
import com.mirakl.client.core.internal.MiraklOperatorShopApiEndpoint;
import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.request.AbstractMiraklApiRequest;

import java.util.Date;
import java.util.Map;

import static com.mirakl.client.core.internal.util.DateFormatter.formatDate;

@Unicity(includeAll = true)
public class AbstractMiraklGetInvoicesRequest extends AbstractMiraklApiRequest {

    private Date startDate;
    private Date endDate;

    @Override
    public MiraklApiEndpoint getEndpoint() {
        return MiraklOperatorShopApiEndpoint.IV01;
    }

    @Override
    public Map<String, String> getQueryParams() {
        Map<String, String> params = super.getQueryParams();

        if (startDate != null) {
            params.put("start_date", formatDate(startDate));
        }
        if (endDate != null) {
            params.put("end_date", formatDate(endDate));
        }

        return params;
    }

    public Date getStartDate() {
        return startDate;
    }

    /**
     * Filter by creation date
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    /**
     * Filter by creation date
     */
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
        if (!super.equals(o)) {
            return false;
        }

        AbstractMiraklGetInvoicesRequest that = (AbstractMiraklGetInvoicesRequest) o;

        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) {
            return false;
        }
        return endDate != null ? endDate.equals(that.endDate) : that.endDate == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        return result;
    }
}
