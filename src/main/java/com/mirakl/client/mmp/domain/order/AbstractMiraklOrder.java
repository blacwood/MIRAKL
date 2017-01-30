/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.order;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.domain.common.MiraklAdditionalFieldValue;
import com.mirakl.client.mmp.domain.common.currency.MiraklIsoCurrencyCode;
import com.mirakl.client.mmp.domain.order.state.MiraklOrderStatus;
import com.mirakl.client.mmp.domain.payment.MiraklPaymentWorkflow;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonUnwrapped;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@JsonIgnoreProperties({"paymentType"})
@Unicity(props = "id")
public class AbstractMiraklOrder {

    @JsonProperty("order_id")
    private String id;
    private String commercialId;

    private Date createdDate;
    private Date lastUpdatedDate;
    private Date acceptanceDecisionDate;

    private BigDecimal price;
    private BigDecimal totalPrice;
    private BigDecimal totalCommission;

    @JsonUnwrapped
    @JsonProperty("state")
    private MiraklOrderStatus status;

    private String paymentType;
    private boolean hasInvoice;

    @JsonUnwrapped
    private MiraklOrderShipping shipping;

    private boolean hasIncident;
    private boolean hasCustomerMessage;

    private Integer leadtimeToShip;

    private MiraklIsoCurrencyCode currencyIsoCode;

    private List<MiraklAdditionalFieldValue> orderAdditionalFields;

    private MiraklChannel channel;

    private MiraklPaymentWorkflow paymentWorkflow;

    private Date customerDebitedDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCommercialId() {
        return commercialId;
    }

    public void setCommercialId(String commercialId) {
        this.commercialId = commercialId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public Date getAcceptanceDecisionDate() {
        return acceptanceDecisionDate;
    }

    public void setAcceptanceDecisionDate(Date acceptanceDecisionDate) {
        this.acceptanceDecisionDate = acceptanceDecisionDate;
    }

    /**
     * Price of the order (sum of order line price)
     */
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * Total price of the order (sum of the order price and the order shipping price)
     */
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * Total commission of the order (sum of the order line total commission)
     */
    public BigDecimal getTotalCommission() {
        return totalCommission;
    }

    public void setTotalCommission(BigDecimal totalCommission) {
        this.totalCommission = totalCommission;
    }

    public MiraklOrderStatus getStatus() {
        return status;
    }

    public void setStatus(MiraklOrderStatus status) {
        this.status = status;
    }

    /**
     * @deprecated Please use {@link #getStatus()} instead.
     */
    @Deprecated
    public MiraklOrderStatus getState() {
        return status;
    }

    /**
     * @deprecated Please use {@link #setStatus(MiraklOrderStatus)} instead.
     */
    @JsonIgnore
    @Deprecated
    public void setState(MiraklOrderStatus status) {
        this.status = status;
    }

    /**
     * The type of payment used by the customer to pay this order
     */
    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    /**
     * Is an invoice avalaible for this order.
     */
    public boolean getHasInvoice() {
        return hasInvoice;
    }

    public void setHasInvoice(boolean hasInvoice) {
        this.hasInvoice = hasInvoice;
    }

    /**
     * Indicate if order has incident on at least one order line
     */
    public boolean getHasIncident() {
        return hasIncident;
    }

    public void setHasIncident(boolean hasIncident) {
        this.hasIncident = hasIncident;
    }

    /**
     * Indicate if the customer has send a message related to this order
     */
    public boolean getHasCustomerMessage() {
        return hasCustomerMessage;
    }

    public void setHasCustomerMessage(boolean hasCustomerMessage) {
        this.hasCustomerMessage = hasCustomerMessage;
    }

    public MiraklOrderShipping getShipping() {
        return shipping;
    }

    public void setShipping(MiraklOrderShipping shipping) {
        this.shipping = shipping;
    }

    public MiraklIsoCurrencyCode getCurrencyIsoCode() {
        return currencyIsoCode;
    }

    public void setCurrencyIsoCode(MiraklIsoCurrencyCode currencyIsoCode) {
        this.currencyIsoCode = currencyIsoCode;
    }

    public MiraklChannel getChannel() {
        return channel;
    }

    public void setChannel(MiraklChannel channel) {
        this.channel = channel;
    }

    public List<MiraklAdditionalFieldValue> getOrderAdditionalFields() {
        return orderAdditionalFields == null ? null : Collections.unmodifiableList(orderAdditionalFields);
    }

    public void setOrderAdditionalFields(List<MiraklAdditionalFieldValue> orderAdditionalFields) {
        this.orderAdditionalFields = orderAdditionalFields;
    }

    /**
     * The payment workflow followed by the order
     */
    public MiraklPaymentWorkflow getPaymentWorkflow() {
        return paymentWorkflow;
    }

    public void setPaymentWorkflow(MiraklPaymentWorkflow paymentWorkflow) {
        this.paymentWorkflow = paymentWorkflow;
    }

    /**
     * The customer debited date of the order
     */
    public Date getCustomerDebitedDate() {
        return customerDebitedDate;
    }

    public void setCustomerDebitedDate(Date customerDebitedDate) {
        this.customerDebitedDate = customerDebitedDate;
    }

    public Integer getLeadtimeToShip() {
        return leadtimeToShip;
    }

    public void setLeadtimeToShip(Integer leadtimeToShip) {
        this.leadtimeToShip = leadtimeToShip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AbstractMiraklOrder that = (AbstractMiraklOrder) o;

        return id != null ? id.equals(that.id) : that.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
