/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.front.domain.order.create;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.domain.common.currency.MiraklIsoCurrencyCode;
import com.mirakl.client.mmp.domain.order.tax.MiraklOrderTaxAmount;
import com.mirakl.client.mmp.request.additionalfield.MiraklRequestAdditionalFieldValue;
import org.codehaus.jackson.annotate.JsonProperty;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

@Unicity(props = "id")
public class MiraklCreateOrderOffer {

    @JsonProperty("offer_id")
    private String id;
    @JsonProperty("offer_price")
    private BigDecimal priceUnit;
    private int quantity;
    private BigDecimal price;
    private BigDecimal shippingPrice;
    private String shippingTypeCode;
    private String orderLineId;
    private List<MiraklRequestAdditionalFieldValue> orderLineAdditionalFields;
    private List<MiraklOrderTaxAmount> taxes;
    private List<MiraklOrderTaxAmount> shippingTaxes;
    private MiraklIsoCurrencyCode currencyIsoCode;
    private Integer leadtimeToShip;

    public String getId() {
        return id;
    }

    /**
     * Offer ID
     */
    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getPriceUnit() {
        return priceUnit;
    }

    /**
     * Unit price of the offer
     */
    public void setPriceUnit(BigDecimal priceUnit) {
        this.priceUnit = priceUnit;
    }

    public int getQuantity() {
        return quantity;
    }

    /**
     * Quantity ordered of the offer
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Price without shipping price = ({@link #priceUnit} * {@link #quantity})
     */
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getShippingPrice() {
        return shippingPrice;
    }

    /**
     * Shipping price of the line
     */
    public void setShippingPrice(BigDecimal shippingPrice) {
        this.shippingPrice = shippingPrice;
    }

    public String getShippingTypeCode() {
        return shippingTypeCode;
    }

    /**
     * Code of the shipping type used
     */
    public void setShippingTypeCode(String shippingTypeCode) {
        this.shippingTypeCode = shippingTypeCode;
    }

    public String getOrderLineId() {
        return orderLineId;
    }

    /**
     * (Optional) Force the value of the order line ID. If nothing specified the ID will be generated based on the commercial ID
     */
    public void setOrderLineId(String orderLineId) {
        this.orderLineId = orderLineId;
    }

    public List<MiraklRequestAdditionalFieldValue> getOrderLineAdditionalFields() {
        return orderLineAdditionalFields == null ? null : Collections.unmodifiableList(orderLineAdditionalFields);
    }

    /**
     * Additional fields of the order line
     */
    public void setOrderLineAdditionalFields(List<MiraklRequestAdditionalFieldValue> orderLineAdditionalFields) {
        this.orderLineAdditionalFields = orderLineAdditionalFields;
    }

    public List<MiraklOrderTaxAmount> getTaxes() {
        return taxes;
    }

    /**
     * (Optional) Taxes to be applied on the price
     */
    public void setTaxes(List<MiraklOrderTaxAmount> taxes) {
        this.taxes = taxes;
    }

    public List<MiraklOrderTaxAmount> getShippingTaxes() {
        return shippingTaxes;
    }

    /**
     * (Optional) Taxes to be applied on the shipping price
     */
    public void setShippingTaxes(List<MiraklOrderTaxAmount> shippingTaxes) {
        this.shippingTaxes = shippingTaxes;
    }

    public MiraklIsoCurrencyCode getCurrencyIsoCode() {
        return currencyIsoCode;
    }

    /**
     * The currency used by the shop (iso format)
     * The field is required if the shop is not using the default Operator platform currency
     */
    public void setCurrencyIsoCode(MiraklIsoCurrencyCode currencyIsoCode) {
        this.currencyIsoCode = currencyIsoCode;
    }

    public Integer getLeadtimeToShip() {
        return leadtimeToShip;
    }

    /**
     * (Optional) lead time to ship of the offer
     */
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

        MiraklCreateOrderOffer that = (MiraklCreateOrderOffer) o;

        return id != null ? id.equals(that.id) : that.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
