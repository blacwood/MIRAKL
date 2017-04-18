/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.front.request.payment;

import com.mirakl.client.core.internal.MiraklApiEndpoint;
import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.front.core.internal.MiraklFrontApiEndpoint;
import com.mirakl.client.mmp.front.domain.payment.MiraklTransactionLogState;
import com.mirakl.client.mmp.front.domain.payment.MiraklTransactionType;
import com.mirakl.client.request.common.AbstractMiraklPaginationRequest;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

import static com.mirakl.client.core.internal.util.DateFormatter.formatDate;
import static com.mirakl.client.core.internal.util.MiraklApiUtils.convertCollectionToStringParam;

@Unicity(includeAll = true)
public class MiraklGetTransactionLogsRequest extends AbstractMiraklPaginationRequest {

    private String shopId;
    private Date startDate;
    private Date endDate;
    private Date startTransactionDate;
    private Date endTransactionDate;
    private Date updatedSince;
    private String paymentVoucherNumber;
    private Collection<MiraklTransactionLogState> paymentStates;
    private Collection<MiraklTransactionType> transactionTypes;
    private String accountingDocumentNumber;
    private Collection<String> orderIds;
    private Collection<String> orderLineIds;

    @Override
    public Map<String, String> getQueryParams() {
        Map<String, String> params = super.getQueryParams();

        if (shopId != null) {
            params.put("shop_id", shopId);
        }
        if (startDate != null) {
            params.put("start_date", formatDate(startDate));
        }
        if (endDate != null) {
            params.put("end_date", formatDate(endDate));
        }
        if (startTransactionDate != null) {
            params.put("start_transaction_date", formatDate(startTransactionDate));
        }
        if (endTransactionDate != null) {
            params.put("end_transaction_date", formatDate(endTransactionDate));
        }
        if (updatedSince != null) {
            params.put("updated_since", formatDate(updatedSince));
        }
        if (paymentVoucherNumber != null) {
            params.put("payment_voucher", paymentVoucherNumber);
        }
        if (paymentStates != null) {
            params.put("payment_states", convertCollectionToStringParam(paymentStates));
        }
        if (transactionTypes != null) {
            params.put("transaction_types", convertCollectionToStringParam(transactionTypes));
        }
        if (accountingDocumentNumber != null) {
            params.put("accounting_document_number", accountingDocumentNumber);
        }
        if (orderIds != null) {
            params.put("order_ids", convertCollectionToStringParam(orderIds));
        }
        if (orderLineIds != null) {
            params.put("order_line_ids", convertCollectionToStringParam(orderLineIds));
        }

        return params;
    }

    @Override
    public MiraklApiEndpoint getEndpoint() {
        return MiraklFrontApiEndpoint.TL01;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartTransactionDate() {
        return startTransactionDate;
    }

    public void setStartTransactionDate(Date startTransactionDate) {
        this.startTransactionDate = startTransactionDate;
    }

    public Date getEndTransactionDate() {
        return endTransactionDate;
    }

    public void setEndTransactionDate(Date endTransactionDate) {
        this.endTransactionDate = endTransactionDate;
    }

    public Date getUpdatedSince() {
        return updatedSince;
    }

    public void setUpdatedSince(Date updatedSince) {
        this.updatedSince = updatedSince;
    }

    public String getPaymentVoucherNumber() {
        return paymentVoucherNumber;
    }

    public void setPaymentVoucherNumber(String paymentVoucherNumber) {
        this.paymentVoucherNumber = paymentVoucherNumber;
    }

    public Collection<MiraklTransactionLogState> getPaymentStates() {
        return paymentStates;
    }

    public void setPaymentStates(Collection<MiraklTransactionLogState> paymentStates) {
        this.paymentStates = paymentStates;
    }

    public Collection<MiraklTransactionType> getTransactionTypes() {
        return transactionTypes;
    }

    public void setTransactionTypes(Collection<MiraklTransactionType> transactionTypes) {
        this.transactionTypes = transactionTypes;
    }

    public String getAccountingDocumentNumber() {
        return accountingDocumentNumber;
    }

    public void setAccountingDocumentNumber(String accountingDocumentNumber) {
        this.accountingDocumentNumber = accountingDocumentNumber;
    }

    public Collection<String> getOrderIds() {
        return orderIds;
    }

    public void setOrderIds(Collection<String> orderIds) {
        this.orderIds = orderIds;
    }

    public Collection<String> getOrderLineIds() {
        return orderLineIds;
    }

    public void setOrderLineIds(Collection<String> orderLineIds) {
        this.orderLineIds = orderLineIds;
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

        MiraklGetTransactionLogsRequest that = (MiraklGetTransactionLogsRequest) o;

        if (shopId != null ? !shopId.equals(that.shopId) : that.shopId != null) {
            return false;
        }
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) {
            return false;
        }
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) {
            return false;
        }
        if (startTransactionDate != null ? !startTransactionDate.equals(that.startTransactionDate) : that.startTransactionDate != null) {
            return false;
        }
        if (endTransactionDate != null ? !endTransactionDate.equals(that.endTransactionDate) : that.endTransactionDate != null) {
            return false;
        }
        if (updatedSince != null ? !updatedSince.equals(that.updatedSince) : that.updatedSince != null) {
            return false;
        }
        if (paymentVoucherNumber != null ? !paymentVoucherNumber.equals(that.paymentVoucherNumber) : that.paymentVoucherNumber != null) {
            return false;
        }
        if (paymentStates != null ? !paymentStates.equals(that.paymentStates) : that.paymentStates != null) {
            return false;
        }
        if (transactionTypes != null ? !transactionTypes.equals(that.transactionTypes) : that.transactionTypes != null) {
            return false;
        }
        if (accountingDocumentNumber != null ? !accountingDocumentNumber.equals(that.accountingDocumentNumber) : that.accountingDocumentNumber != null) {
            return false;
        }
        if (orderIds != null ? !orderIds.equals(that.orderIds) : that.orderIds != null) {
            return false;
        }
        return orderLineIds != null ? orderLineIds.equals(that.orderLineIds) : that.orderLineIds == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (shopId != null ? shopId.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (startTransactionDate != null ? startTransactionDate.hashCode() : 0);
        result = 31 * result + (endTransactionDate != null ? endTransactionDate.hashCode() : 0);
        result = 31 * result + (updatedSince != null ? updatedSince.hashCode() : 0);
        result = 31 * result + (paymentVoucherNumber != null ? paymentVoucherNumber.hashCode() : 0);
        result = 31 * result + (paymentStates != null ? paymentStates.hashCode() : 0);
        result = 31 * result + (transactionTypes != null ? transactionTypes.hashCode() : 0);
        result = 31 * result + (accountingDocumentNumber != null ? accountingDocumentNumber.hashCode() : 0);
        result = 31 * result + (orderIds != null ? orderIds.hashCode() : 0);
        result = 31 * result + (orderLineIds != null ? orderLineIds.hashCode() : 0);
        return result;
    }
}
