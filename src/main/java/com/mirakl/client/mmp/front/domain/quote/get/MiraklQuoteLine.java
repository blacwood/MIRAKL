/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.front.domain.quote.get;

import com.mirakl.client.domain.common.Unicity;
import org.codehaus.jackson.annotate.JsonUnwrapped;

import java.math.BigDecimal;

@Unicity(props = "id")
public class MiraklQuoteLine {

    private String id;
    private String offerId;

    private String productSku;
    private String productTitle;
    private String categoryCode;
    private String categoryLabel;
    private String offerDescription;
    private String offerStateCode;
    private String shopSku;
    private Integer originalLeadtimeToShip;
    private String priceAdditionalInfo;
    private BigDecimal unitPrice;
    private Integer quantity;
    @JsonUnwrapped
    private MiraklQuoteLinePriceSummary priceSummary;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOfferId() {
        return offerId;
    }

    public void setOfferId(String offerId) {
        this.offerId = offerId;
    }

    public String getProductSku() {
        return productSku;
    }

    public void setProductSku(String productSku) {
        this.productSku = productSku;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getCategoryLabel() {
        return categoryLabel;
    }

    public void setCategoryLabel(String categoryLabel) {
        this.categoryLabel = categoryLabel;
    }

    public String getOfferDescription() {
        return offerDescription;
    }

    public void setOfferDescription(String offerDescription) {
        this.offerDescription = offerDescription;
    }

    public String getOfferStateCode() {
        return offerStateCode;
    }

    public void setOfferStateCode(String offerStateCode) {
        this.offerStateCode = offerStateCode;
    }

    public String getShopSku() {
        return shopSku;
    }

    public void setShopSku(String shopSku) {
        this.shopSku = shopSku;
    }

    public Integer getOriginalLeadtimeToShip() {
        return originalLeadtimeToShip;
    }

    public void setOriginalLeadtimeToShip(Integer originalLeadtimeToShip) {
        this.originalLeadtimeToShip = originalLeadtimeToShip;
    }

    public String getPriceAdditionalInfo() {
        return priceAdditionalInfo;
    }

    public void setPriceAdditionalInfo(String priceAdditionalInfo) {
        this.priceAdditionalInfo = priceAdditionalInfo;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public MiraklQuoteLinePriceSummary getPriceSummary() {
        return priceSummary;
    }

    public void setPriceSummary(MiraklQuoteLinePriceSummary priceSummary) {
        this.priceSummary = priceSummary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklQuoteLine that = (MiraklQuoteLine) o;

        return id != null ? id.equals(that.id) : that.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
