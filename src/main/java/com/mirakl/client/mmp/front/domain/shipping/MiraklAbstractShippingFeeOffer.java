/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.front.domain.shipping;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.domain.common.MiraklAdditionalFieldValue;
import com.mirakl.client.mmp.domain.common.MiraklDiscount;
import com.mirakl.client.mmp.domain.shipping.MiraklShippingTypeDetail;
import org.codehaus.jackson.annotate.JsonProperty;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

@Unicity(includeAll = true)
public abstract class MiraklAbstractShippingFeeOffer {

    @JsonProperty("offer_id")
    private String id;
    @JsonProperty("offer_price")
    private BigDecimal price;

    @JsonProperty("offer_discount")
    private MiraklDiscount discount;

    @JsonProperty("offer_quantity")
    private Integer quantity;
    private String productCategoryCode;

    private BigDecimal shippingPriceUnit;
    private BigDecimal shippingPriceAdditionalUnit;

    private Integer lineOriginalQuantity;

    private BigDecimal linePrice;
    private Integer lineQuantity;

    private BigDecimal lineShippingPrice;
    private BigDecimal lineTotalPrice;

    private BigDecimal lineOnlyShippingPrice;
    private BigDecimal lineOnlyTotalPrice;

    @JsonProperty("offer_additional_fields")
    private List<MiraklAdditionalFieldValue> offerAdditionalFields;

    @JsonProperty("shipping_types")
    private List<MiraklShippingTypeDetail> shippingTypeDetails;

    private boolean allowQuoteRequests;

    /**
     * Offer ID
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Offer price
     */
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * Offer discount
     */
    public MiraklDiscount getDiscount() {
        return discount;
    }

    public void setDiscount(MiraklDiscount discount) {
        this.discount = discount;
    }

    /**
     * Quantity of the offer
     * <p/>
     * <ul>
     * <li>0: if quantity = 0 or the offer is not available</li>
     * <li>x: quantity available</li>
     * </ul>
     */
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * Code of the category of the product of the offer
     */
    public String getProductCategoryCode() {
        return productCategoryCode;
    }

    public void setProductCategoryCode(String productCategoryCode) {
        this.productCategoryCode = productCategoryCode;
    }

    /**
     * Shipping price of the offer
     */
    public BigDecimal getShippingPriceUnit() {
        return shippingPriceUnit;
    }

    public void setShippingPriceUnit(BigDecimal shippingPriceUnit) {
        this.shippingPriceUnit = shippingPriceUnit;
    }

    /**
     * Additional shipping price of the offer
     */
    public BigDecimal getShippingPriceAdditionalUnit() {
        return shippingPriceAdditionalUnit;
    }

    public void setShippingPriceAdditionalUnit(BigDecimal shippingPriceAdditionalUnit) {
        this.shippingPriceAdditionalUnit = shippingPriceAdditionalUnit;
    }

    /**
     * Quantity of offers requested in the line
     */
    public Integer getLineOriginalQuantity() {
        return lineOriginalQuantity;
    }

    public void setLineOriginalQuantity(Integer lineOriginalQuantity) {
        this.lineOriginalQuantity = lineOriginalQuantity;
    }

    /**
     * Price of the order line (offer price * quantity)
     */
    public BigDecimal getLinePrice() {
        return linePrice;
    }

    public void setLinePrice(BigDecimal linePrice) {
        this.linePrice = linePrice;
    }

    /**
     * Quantity of offers returned for the line
     */
    public Integer getLineQuantity() {
        return lineQuantity;
    }

    public void setLineQuantity(Integer lineQuantity) {
        this.lineQuantity = lineQuantity;
    }

    /**
     * Shipping price of the order line If the shipping price of the offer is the biggest in the order for the shop : shipping price * 1 + additional shipping price * (quantity - 1) Else : additional shipping price * quantity
     */
    public BigDecimal getLineShippingPrice() {
        return lineShippingPrice;
    }

    public void setLineShippingPrice(BigDecimal lineShippingPrice) {
        this.lineShippingPrice = lineShippingPrice;
    }

    /**
     * Total price of the order line (line_price + line_shipping_price)
     */
    public BigDecimal getLineTotalPrice() {
        return lineTotalPrice;
    }

    public void setLineTotalPrice(BigDecimal lineTotalPrice) {
        this.lineTotalPrice = lineTotalPrice;
    }

    /**
     * Shipping price of the order line if the order is composed only of the offer (shipping price * 1 + additional shipping price * (quantity - 1))
     */
    public BigDecimal getLineOnlyShippingPrice() {
        return lineOnlyShippingPrice;
    }

    public void setLineOnlyShippingPrice(BigDecimal lineOnlyShippingPrice) {
        this.lineOnlyShippingPrice = lineOnlyShippingPrice;
    }

    /**
     * Total price of the order line if the order is composed only of the offer (price + shipping price of the order line)
     */
    public BigDecimal getLineOnlyTotalPrice() {
        return lineOnlyTotalPrice;
    }

    public void setLineOnlyTotalPrice(BigDecimal lineOnlyTotalPrice) {
        this.lineOnlyTotalPrice = lineOnlyTotalPrice;
    }

    public List<MiraklAdditionalFieldValue> getOfferAdditionalFields() {
        return offerAdditionalFields == null ? null : Collections.unmodifiableList(offerAdditionalFields);
    }

    public void setOfferAdditionalFields(List<MiraklAdditionalFieldValue> offerAdditionalFields) {
        this.offerAdditionalFields = offerAdditionalFields;
    }

    public List<MiraklShippingTypeDetail> getShippingTypeDetails() {
        return shippingTypeDetails;
    }

    public void setShippingTypeDetails(List<MiraklShippingTypeDetail> shippingTypeDetails) {
        this.shippingTypeDetails = shippingTypeDetails;
    }

    /**
     * Whether or not a quote can be issued by the shop on that offer
     */
    public boolean getAllowQuoteRequests() {
        return allowQuoteRequests;
    }

    public void setAllowQuoteRequests(boolean allowQuoteRequests) {
        this.allowQuoteRequests = allowQuoteRequests;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklAbstractShippingFeeOffer that = (MiraklAbstractShippingFeeOffer) o;

        if (allowQuoteRequests != that.allowQuoteRequests) {
            return false;
        }
        if (id != null ? !id.equals(that.id) : that.id != null) {
            return false;
        }
        if (price != null ? !price.equals(that.price) : that.price != null) {
            return false;
        }
        if (discount != null ? !discount.equals(that.discount) : that.discount != null) {
            return false;
        }
        if (quantity != null ? !quantity.equals(that.quantity) : that.quantity != null) {
            return false;
        }
        if (productCategoryCode != null ? !productCategoryCode.equals(that.productCategoryCode) : that.productCategoryCode != null) {
            return false;
        }
        if (shippingPriceUnit != null ? !shippingPriceUnit.equals(that.shippingPriceUnit) : that.shippingPriceUnit != null) {
            return false;
        }
        if (shippingPriceAdditionalUnit != null ? !shippingPriceAdditionalUnit.equals(that.shippingPriceAdditionalUnit) : that.shippingPriceAdditionalUnit != null) {
            return false;
        }
        if (lineOriginalQuantity != null ? !lineOriginalQuantity.equals(that.lineOriginalQuantity) : that.lineOriginalQuantity != null) {
            return false;
        }
        if (linePrice != null ? !linePrice.equals(that.linePrice) : that.linePrice != null) {
            return false;
        }
        if (lineQuantity != null ? !lineQuantity.equals(that.lineQuantity) : that.lineQuantity != null) {
            return false;
        }
        if (lineShippingPrice != null ? !lineShippingPrice.equals(that.lineShippingPrice) : that.lineShippingPrice != null) {
            return false;
        }
        if (lineTotalPrice != null ? !lineTotalPrice.equals(that.lineTotalPrice) : that.lineTotalPrice != null) {
            return false;
        }
        if (lineOnlyShippingPrice != null ? !lineOnlyShippingPrice.equals(that.lineOnlyShippingPrice) : that.lineOnlyShippingPrice != null) {
            return false;
        }
        if (lineOnlyTotalPrice != null ? !lineOnlyTotalPrice.equals(that.lineOnlyTotalPrice) : that.lineOnlyTotalPrice != null) {
            return false;
        }
        if (offerAdditionalFields != null ? !offerAdditionalFields.equals(that.offerAdditionalFields) : that.offerAdditionalFields != null) {
            return false;
        }
        return shippingTypeDetails != null ? shippingTypeDetails.equals(that.shippingTypeDetails) : that.shippingTypeDetails == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (discount != null ? discount.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (productCategoryCode != null ? productCategoryCode.hashCode() : 0);
        result = 31 * result + (shippingPriceUnit != null ? shippingPriceUnit.hashCode() : 0);
        result = 31 * result + (shippingPriceAdditionalUnit != null ? shippingPriceAdditionalUnit.hashCode() : 0);
        result = 31 * result + (lineOriginalQuantity != null ? lineOriginalQuantity.hashCode() : 0);
        result = 31 * result + (linePrice != null ? linePrice.hashCode() : 0);
        result = 31 * result + (lineQuantity != null ? lineQuantity.hashCode() : 0);
        result = 31 * result + (lineShippingPrice != null ? lineShippingPrice.hashCode() : 0);
        result = 31 * result + (lineTotalPrice != null ? lineTotalPrice.hashCode() : 0);
        result = 31 * result + (lineOnlyShippingPrice != null ? lineOnlyShippingPrice.hashCode() : 0);
        result = 31 * result + (lineOnlyTotalPrice != null ? lineOnlyTotalPrice.hashCode() : 0);
        result = 31 * result + (offerAdditionalFields != null ? offerAdditionalFields.hashCode() : 0);
        result = 31 * result + (shippingTypeDetails != null ? shippingTypeDetails.hashCode() : 0);
        result = 31 * result + (allowQuoteRequests ? 1 : 0);
        return result;
    }
}
