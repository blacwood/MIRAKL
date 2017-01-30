/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.request.common.message;

import com.mirakl.client.core.internal.MiraklApiEndpoint;
import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.core.internal.MiraklMarketplacePlatformCommonApiEndpoint;
import com.mirakl.client.request.common.AbstractMiraklPaginationRequest;

import java.util.Date;
import java.util.Map;

import static com.mirakl.client.core.internal.util.DateFormatter.formatDate;
import static com.mirakl.client.core.internal.util.MiraklApiUtils.addBooleanOrAllParam;

@Unicity(includeAll = true)
public class AbstractGetMessagesRequest extends AbstractMiraklPaginationRequest {

    private Date startDate;
    private Date endDate;
    private Boolean visible = true;
    private String customerId;

    @Override
    public MiraklApiEndpoint getEndpoint() {
        return MiraklMarketplacePlatformCommonApiEndpoint.M01;
    }

    @Override
    public Map<String, String> getQueryParams() {
        Map<String, String> params = super.getQueryParams();

        addBooleanOrAllParam(params, visible, "visible");

        if (customerId != null) {
            params.put("customer_id", customerId);
        }
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
     * Filter on Creation Date
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    /**
     * Filter on Creation Date
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Boolean getVisible() {
        return visible;
    }

    /**
     * (optional) Default value is true (only visible message will be returned by default)
     * If set to false only messages not visible will be returned.
     * If set to null all messages will be returned.
     */
    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    /**
     * Filter by customer ID
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerId() {
        return customerId;
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

        AbstractGetMessagesRequest that = (AbstractGetMessagesRequest) o;

        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) {
            return false;
        }
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) {
            return false;
        }
        if (visible != null ? !visible.equals(that.visible) : that.visible != null) {
            return false;
        }
        return customerId != null ? customerId.equals(that.customerId) : that.customerId == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (visible != null ? visible.hashCode() : 0);
        result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
        return result;
    }
}
