/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.order;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.domain.common.MiraklAdditionalFieldValue;
import com.mirakl.client.mmp.domain.order.state.MiraklOrderLineStatus;
import com.mirakl.client.mmp.domain.order.tax.MiraklOrderTaxAmount;
import com.mirakl.client.mmp.domain.product.MiraklProductMedia;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonUnwrapped;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@JsonIgnoreProperties({"shipping_price_unit", "shipping_price_additional_unit"})
@Unicity(props = "id")
public class MiraklShopOrderLine {

    @JsonProperty("order_line_id")
    private String id;

    @JsonProperty("order_line_index")
    private int index;

    @JsonUnwrapped
    private MiraklOrderLineHistory history;

    @JsonUnwrapped
    private MiraklOrderLineOfferInformation offer;

    private int quantity;
    private String priceAdditionalInfo;
    private BigDecimal price;
    private BigDecimal shippingPrice;
    private BigDecimal totalPrice;

    @JsonUnwrapped
    private MiraklOrderLineCommission commission;

    @JsonUnwrapped
    @JsonProperty("state")
    private MiraklOrderLineStatus status;

    private boolean canRefund;
    private List<MiraklRefund> refunds;
    private List<MiraklCancelation> cancelations = new ArrayList<MiraklCancelation>();

    @JsonProperty("order_line_additional_fields")
    private List<MiraklAdditionalFieldValue> additionalFields;

    private List<MiraklOrderTaxAmount> taxes;
    private List<MiraklOrderTaxAmount> shippingTaxes;

    @JsonUnwrapped
    @JsonProperty("product_medias")
    private List<MiraklProductMedia> productMedias;

    /**
     * Order line ID
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Order line index
     */
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * Offer quantity for the line
     */
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Price additional information of the offer
     */
    public String getPriceAdditionalInfo() {
        return priceAdditionalInfo;
    }

    public void setPriceAdditionalInfo(String priceAdditionalInfo) {
        this.priceAdditionalInfo = priceAdditionalInfo;
    }

    /**
     * Price of the line without shipping price
     */
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * Total price of the shipping price of the line
     */
    public BigDecimal getShippingPrice() {
        return shippingPrice;
    }

    public void setShippingPrice(BigDecimal shippingPrice) {
        this.shippingPrice = shippingPrice;
    }

    /**
     * Price of the line with shipping price
     */
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public MiraklOrderLineStatus getStatus() {
        return status;
    }

    public void setStatus(MiraklOrderLineStatus status) {
        this.status = status;
    }

    /**
     * @deprecated Please use {@link #getStatus()} instead
     */
    @Deprecated
    public MiraklOrderLineStatus getState() {
        return status;
    }

    /**
     * @deprecated Please use {@link #setStatus(MiraklOrderLineStatus)} instead
     */
    @JsonIgnore
    @Deprecated
    public void setState(MiraklOrderLineStatus status) {
        this.status = status;
    }

    /**
     * Indicate if the order line can be refunded by the operator
     */
    public boolean getCanRefund() {
        return canRefund;
    }

    public void setCanRefund(boolean canRefund) {
        this.canRefund = canRefund;
    }

    public List<MiraklAdditionalFieldValue> getAdditionalFields() {
        return additionalFields == null ? null : Collections.unmodifiableList(additionalFields);
    }

    public void setAdditionalFields(List<MiraklAdditionalFieldValue> additionalFields) {
        this.additionalFields = additionalFields;
    }

    /**
     * Order line refund
     */
    public List<MiraklRefund> getRefunds() {
        return refunds;
    }

    public void setRefunds(List<MiraklRefund> refunds) {
        this.refunds = refunds;
    }

    public List<MiraklCancelation> getCancelations() {
        return Collections.unmodifiableList(cancelations);
    }

    public boolean addCancelation(MiraklCancelation cancelation) {
        return cancelations.add(cancelation);
    }

    public MiraklOrderLineHistory getHistory() {
        return history;
    }

    public void setHistory(MiraklOrderLineHistory history) {
        this.history = history;
    }

    public MiraklOrderLineOfferInformation getOffer() {
        return offer;
    }

    public void setOffer(MiraklOrderLineOfferInformation offer) {
        this.offer = offer;
    }

    public MiraklOrderLineCommission getCommission() {
        return commission;
    }

    public void setCommission(MiraklOrderLineCommission commission) {
        this.commission = commission;
    }

    /**
     * The taxes applied on the price
     */
    public List<MiraklOrderTaxAmount> getTaxes() {
        return taxes;
    }

    public void setTaxes(List<MiraklOrderTaxAmount> taxes) {
        this.taxes = taxes;
    }

    /**
     * The taxes applied on the shipping price
     */
    public List<MiraklOrderTaxAmount> getShippingTaxes() {
        return shippingTaxes;
    }

    public void setShippingTaxes(List<MiraklOrderTaxAmount> shippingTaxes) {
        this.shippingTaxes = shippingTaxes;
    }

    /**
     * List of all product media associated to the line
     */
    public List<MiraklProductMedia> getProductMedias() {
        return productMedias;
    }

    public void setProductMedias(List<MiraklProductMedia> productMedias) {
        this.productMedias = productMedias;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklShopOrderLine that = (MiraklShopOrderLine) o;

        return id != null ? id.equals(that.id) : that.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
