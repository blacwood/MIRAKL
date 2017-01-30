/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.request.order;

import com.mirakl.client.core.internal.MiraklApiEndpoint;
import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.core.internal.MiraklMarketplacePlatformCommonApiEndpoint;
import com.mirakl.client.mmp.domain.order.state.MiraklOrderStatus;
import com.mirakl.client.mmp.domain.payment.MiraklPaymentWorkflow;
import com.mirakl.client.request.common.AbstractMiraklPaginationRequest;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

import static com.mirakl.client.core.internal.util.DateFormatter.formatDate;
import static com.mirakl.client.core.internal.util.MiraklApiUtils.convertCollectionToStringParam;

@Unicity(includeAll = true)
public class AbstractMiraklGetOrdersRequest extends AbstractMiraklPaginationRequest {

    private Collection<String> orderIds;
    private Collection<MiraklOrderStatus.State> orderStates;
    private Collection<String> channelCodes;
    private Date startDate;
    private Date endDate;
    private Date startUpdateDate;
    private Date endUpdateDate;
    private MiraklPaymentWorkflow paymentWorkflow;
    private Boolean customerDebited;

    public Collection<MiraklOrderStatus.State> getOrderStates() {
        return orderStates;
    }

    /**
     * Filter by order states
     */
    public void setOrderStates(Collection<MiraklOrderStatus.State> orderStates) {
        this.orderStates = orderStates;
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

    public Date getStartUpdateDate() {
        return startUpdateDate;
    }

    /**
     * Filter by update date
     */
    public void setStartUpdateDate(Date startUpdateDate) {
        this.startUpdateDate = startUpdateDate;
    }

    public Date getEndUpdateDate() {
        return endUpdateDate;
    }

    /**
     * Filter by update date
     */
    public void setEndUpdateDate(Date endUpdateDate) {
        this.endUpdateDate = endUpdateDate;
    }

    public Collection<String> getOrderIds() {
        return orderIds;
    }

    /**
     * Filter by order IDs
     */
    public void setOrderIds(Collection<String> orderIds) {
        this.orderIds = orderIds;
    }

    public Collection<String> getChannelCodes() {
        return channelCodes;
    }

    /**
     * Filter by channel codes
     */
    public void setChannelCodes(Collection<String> channelCodes) {
        this.channelCodes = channelCodes;
    }

    public MiraklPaymentWorkflow getPaymentWorkflow() {
        return paymentWorkflow;
    }

    /**
     * Filter by payment workflow
     */
    public void setPaymentWorkflow(MiraklPaymentWorkflow paymentWorkflow) {
        this.paymentWorkflow = paymentWorkflow;
    }

    /**
     * Filter by paid, unpaid orders
     * Default value is null, no filtering is done.
     * If set to true, only orders paid will be returned
     * If set to false, only orders unpaid will be returned
     */
    public Boolean getCustomerDebited() {
        return customerDebited;
    }

    public void setCustomerDebited(Boolean customerDebited) {
        this.customerDebited = customerDebited;
    }

    @Override
    public MiraklApiEndpoint getEndpoint() {
        return MiraklMarketplacePlatformCommonApiEndpoint.OR11;
    }

    @Override
    public Map<String, String> getQueryParams() {
        Map<String, String> result = super.getQueryParams();

        if (orderStates != null) {
            result.put("order_state_codes", convertCollectionToStringParam(orderStates));
        }
        if (orderIds != null) {
            result.put("order_ids", convertCollectionToStringParam(orderIds));
        }
        if (channelCodes != null) {
            result.put("channel_codes", convertCollectionToStringParam(channelCodes));
        }
        if (startDate != null) {
            result.put("start_date", formatDate(startDate));
        }
        if (endDate != null) {
            result.put("end_date", formatDate(endDate));
        }
        if (startUpdateDate != null) {
            result.put("start_update_date", formatDate(startUpdateDate));
        }
        if (endUpdateDate != null) {
            result.put("end_update_date", formatDate(endUpdateDate));
        }

        if (paymentWorkflow != null) {
            result.put("payment_workflow", paymentWorkflow.toString());
        }

        if (customerDebited != null) {
            result.put("customer_debited", String.valueOf(customerDebited));
        }

        return result;
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

        AbstractMiraklGetOrdersRequest that = (AbstractMiraklGetOrdersRequest) o;

        if (orderIds != null ? !orderIds.equals(that.orderIds) : that.orderIds != null) {
            return false;
        }
        if (orderStates != null ? !orderStates.equals(that.orderStates) : that.orderStates != null) {
            return false;
        }
        if (channelCodes != null ? !channelCodes.equals(that.channelCodes) : that.channelCodes != null) {
            return false;
        }
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) {
            return false;
        }
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) {
            return false;
        }
        if (startUpdateDate != null ? !startUpdateDate.equals(that.startUpdateDate) : that.startUpdateDate != null) {
            return false;
        }
        return endUpdateDate != null ? endUpdateDate.equals(that.endUpdateDate) : that.endUpdateDate == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (orderIds != null ? orderIds.hashCode() : 0);
        result = 31 * result + (orderStates != null ? orderStates.hashCode() : 0);
        result = 31 * result + (channelCodes != null ? channelCodes.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (startUpdateDate != null ? startUpdateDate.hashCode() : 0);
        result = 31 * result + (endUpdateDate != null ? endUpdateDate.hashCode() : 0);
        return result;
    }
}
