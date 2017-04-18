/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.front.domain.payment;

import com.mirakl.client.core.internal.mapper.BigDecimalRateDeserializer;
import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.domain.common.currency.MiraklIsoCurrencyCode;
import com.mirakl.client.mmp.domain.order.state.MiraklOrderStatus;
import com.mirakl.client.mmp.domain.product.MiraklProductInformation;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonUnwrapped;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import java.math.BigDecimal;
import java.util.Date;

@JsonIgnoreProperties({"invoice_creation_date", "invoice_number", "vat_rate"})
@Unicity(props = {"id"})
public class MiraklTransactionLog {

    private Date dateCreated;
    private Date lastUpdated;
    private String shopName;
    private String shopId;
    private String shopOperatorInternalId;
    private MiraklTransactionType transactionType;
    private String transactionNumber;
    private MiraklOrderStatus.State orderState;
    private String orderCommercialId;
    private String orderId;
    private String orderLineId;
    private String accountingDocumentNumber;
    private Date accountingDocumentCreationDate;
    private String paymentVoucherNumber;
    private String offerSku;
    private String offerState;
    private BigDecimal offerPriceUnit;
    private Integer quantity;
    @JsonUnwrapped
    private MiraklProductInformation productInformation;
    private String shippingTypeCode;
    private String shippingZoneCode;
    private MiraklTransactionLogState paymentState;
    private BigDecimal amountCredited;
    private BigDecimal amountDebited;
    private BigDecimal balance;

    @JsonDeserialize(using = BigDecimalRateDeserializer.class)
    private BigDecimal shopTaxRate;

    private String commissionGridLabel;
    private Date transactionDate;
    private String refundId;
    private String orderTaxCode;
    private String shopTaxCode;
    private MiraklIsoCurrencyCode currencyIsoCode;
    private String id;

    /**
     * Transaction log creation date
     */
    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    /**
     * Transaction log last update date
     */
    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    /**
     * Shop name associated to the transaction log
     */
    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    /**
     * Shop id associated to the transaction log
     */
    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    /**
     * Shop operator internal id associated to the transaction log
     */
    public String getShopOperatorInternalId() {
        return shopOperatorInternalId;
    }

    public void setShopOperatorInternalId(String shopOperatorInternalId) {
        this.shopOperatorInternalId = shopOperatorInternalId;
    }

    /**
     * Transaction log type
     */
    public MiraklTransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(MiraklTransactionType transactionType) {
        this.transactionType = transactionType;
    }

    /**
     * Transaction number associated to the transaction log
     */
    public String getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(String transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    /**
     * Order state of the line associated to the transaction log
     */
    public MiraklOrderStatus.State getOrderState() {
        return orderState;
    }

    public void setOrderState(MiraklOrderStatus.State orderState) {
        this.orderState = orderState;
    }

    /**
     * Order commercial ID associated to the transaction log
     */
    public String getOrderCommercialId() {
        return orderCommercialId;
    }

    public void setOrderCommercialId(String orderCommercialId) {
        this.orderCommercialId = orderCommercialId;
    }

    /**
     * Order ID associated to the transaction log
     */
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * Order line ID associated to the transaction log
     */
    public String getOrderLineId() {
        return orderLineId;
    }

    public void setOrderLineId(String orderLineId) {
        this.orderLineId = orderLineId;
    }

    /**
     * Accounting document number associated to the transaction log
     */
    public String getAccountingDocumentNumber() {
        return accountingDocumentNumber;
    }

    public void setAccountingDocumentNumber(String accountingDocumentNumber) {
        this.accountingDocumentNumber = accountingDocumentNumber;
    }

    /**
     * Accounting document creation date associated to the transaction log
     */
    public Date getAccountingDocumentCreationDate() {
        return accountingDocumentCreationDate;
    }

    public void setAccountingDocumentCreationDate(Date accountingDocumentCreationDate) {
        this.accountingDocumentCreationDate = accountingDocumentCreationDate;
    }

    /**
     * Payment voucher number associated to the transaction log
     */
    public String getPaymentVoucherNumber() {
        return paymentVoucherNumber;
    }

    public void setPaymentVoucherNumber(String paymentVoucherNumber) {
        this.paymentVoucherNumber = paymentVoucherNumber;
    }

    /**
     * Offer SKU of the order line associated to the transaction log
     */
    public String getOfferSku() {
        return offerSku;
    }

    public void setOfferSku(String offerSku) {
        this.offerSku = offerSku;
    }

    /**
     * Offer condition code of the order line associated to the transaction log
     */
    public String getOfferState() {
        return offerState;
    }

    public void setOfferState(String offerState) {
        this.offerState = offerState;
    }

    /**
     * Offer price unit of the order line associated to the transaction log
     */
    public BigDecimal getOfferPriceUnit() {
        return offerPriceUnit;
    }

    public void setOfferPriceUnit(BigDecimal offerPriceUnit) {
        this.offerPriceUnit = offerPriceUnit;
    }

    /**
     * Order line quantity
     */
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * Order shipping type code
     */
    public String getShippingTypeCode() {
        return shippingTypeCode;
    }

    public void setShippingTypeCode(String shippingTypeCode) {
        this.shippingTypeCode = shippingTypeCode;
    }

    /**
     * Order shipping zone code
     */
    public String getShippingZoneCode() {
        return shippingZoneCode;
    }

    public void setShippingZoneCode(String shippingZoneCode) {
        this.shippingZoneCode = shippingZoneCode;
    }

    /**
     * Transaction log payment state
     */
    public MiraklTransactionLogState getPaymentState() {
        return paymentState;
    }

    public void setPaymentState(MiraklTransactionLogState paymentState) {
        this.paymentState = paymentState;
    }

    /**
     * Transaction log credited amount
     */
    public BigDecimal getAmountCredited() {
        return amountCredited;
    }

    public void setAmountCredited(BigDecimal amountCredited) {
        this.amountCredited = amountCredited;
    }

    /**
     * Transaction log debited amount
     */
    public BigDecimal getAmountDebited() {
        return amountDebited;
    }

    public void setAmountDebited(BigDecimal amountDebited) {
        this.amountDebited = amountDebited;
    }

    /**
     * Shop balance after the transaction log has been registered
     */
    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    /**
     * Tax rate associated to the transaction log
     * @deprecated Please use {@link #getShopTaxRate()} instead
     */
    @Deprecated
    public BigDecimal getTaxRate() {
        return getShopTaxRate();
    }

    /**
     * @deprecated Please use {@link #setShopTaxRate(java.math.BigDecimal)} instead
     */
    @Deprecated
    public void setTaxRate(BigDecimal taxRate) {
        setShopTaxRate(taxRate);
    }

    public BigDecimal getShopTaxRate() {
        return shopTaxRate;
    }

    public void setShopTaxRate(BigDecimal shopTaxRate) {
        this.shopTaxRate = shopTaxRate;
    }

    /**
     * Commission grid label associated to the transaction log
     */
    public String getCommissionGridLabel() {
        return commissionGridLabel;
    }

    public void setCommissionGridLabel(String commissionGridLabel) {
        this.commissionGridLabel = commissionGridLabel;
    }

    /**
     * Transaction date associated to the transaction log
     */
    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    /**
     * Refund ID associated to the transaction log (if the log is a refund)
     */
    public String getRefundId() {
        return refundId;
    }

    public void setRefundId(String refundId) {
        this.refundId = refundId;
    }

    public MiraklProductInformation getProductInformation() {
        return productInformation;
    }

    public void setProductInformation(MiraklProductInformation productInformation) {
        this.productInformation = productInformation;
    }

    /**
     * The code of the order tax associated to the transaction log, or {@literal null} if the transaction log is not associated to an order tax
     */
    public String getOrderTaxCode() {
        return orderTaxCode;
    }

    public void setOrderTaxCode(String orderTaxCode) {
        this.orderTaxCode = orderTaxCode;
    }

    /**
     * The code of the shop tax associated to the transaction log, or {@literal null} if the transaction log is not associated to a shop tax
     */
    public String getShopTaxCode() {
        return shopTaxCode;
    }

    public void setShopTaxCode(String shopTaxCode) {
        this.shopTaxCode = shopTaxCode;
    }

    /**
     * Iso currency code
     */
    public MiraklIsoCurrencyCode getCurrencyIsoCode() {
        return currencyIsoCode;
    }

    public void setCurrencyIsoCode(MiraklIsoCurrencyCode currencyIsoCode) {
        this.currencyIsoCode = currencyIsoCode;
    }

    /**
     * Identifier of the transaction log
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklTransactionLog that = (MiraklTransactionLog) o;

        return id != null ? id.equals(that.id) : that.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
