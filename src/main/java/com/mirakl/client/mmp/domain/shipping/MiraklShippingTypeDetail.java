/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.shipping;

import com.mirakl.client.domain.common.Unicity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

/**
 * Shipping type detail for the offer
 */
@XmlRootElement(name = "shipping_type")
@Unicity(includeAll = true)
public class MiraklShippingTypeDetail {

    private String code;
    private String label;

    private BigDecimal lineOnlyShippingPrice;
    private BigDecimal lineOnlyTotalPrice;

    private BigDecimal lineShippingPrice;
    private BigDecimal lineTotalPrice;

    private BigDecimal shippingPriceAdditionalUnit;
    private BigDecimal shippingPriceUnit;

    /**
     * Code of the shipping type
     */
    @XmlElement(required = true, nillable = false, name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Label of the shipping type
     */
    @XmlElement(required = true, nillable = false, name = "label")
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * Shipping price of the order line if the order is composed only of the offer (shipping price * 1 + additional shipping price * (quantity - 1))
     */
    @XmlElement(required = true, nillable = false, name = "line_only_shipping_price")
    public BigDecimal getLineOnlyShippingPrice() {
        return lineOnlyShippingPrice;
    }

    public void setLineOnlyShippingPrice(BigDecimal lineOnlyShippingPrice) {
        this.lineOnlyShippingPrice = lineOnlyShippingPrice;
    }

    /**
     * Total price of the order line if the order is composed only of the offer (price + shipping price of the order line)
     */
    @XmlElement(required = true, nillable = false, name = "line_only_total_price")
    public BigDecimal getLineOnlyTotalPrice() {
        return lineOnlyTotalPrice;
    }

    public void setLineOnlyTotalPrice(BigDecimal lineOnlyTotalPrice) {
        this.lineOnlyTotalPrice = lineOnlyTotalPrice;
    }

    /**
     * Shipping price of the order line
     * If the shipping price of the offer is the biggest in the order for the shop: shipping price * 1 + additional shipping price * (quantity - 1)
     * Else: additional shipping price * quantity
     */
    @XmlElement(required = true, nillable = false, name = "line_shipping_price")
    public BigDecimal getLineShippingPrice() {
        return lineShippingPrice;
    }

    public void setLineShippingPrice(BigDecimal lineShippingPrice) {
        this.lineShippingPrice = lineShippingPrice;
    }

    /**
     * Total price of the order line (line_price + line_shipping_price)
     */
    @XmlElement(required = true, nillable = false, name = "line_total_price")
    public BigDecimal getLineTotalPrice() {
        return lineTotalPrice;
    }

    public void setLineTotalPrice(BigDecimal lineTotalPrice) {
        this.lineTotalPrice = lineTotalPrice;
    }

    /**
     * Additional shipping price of the offer
     */
    @XmlElement(required = true, nillable = false, name = "shipping_price_additional_unit")
    public BigDecimal getShippingPriceAdditionalUnit() {
        return shippingPriceAdditionalUnit;
    }

    public void setShippingPriceAdditionalUnit(BigDecimal shippingPriceAdditionalUnit) {
        this.shippingPriceAdditionalUnit = shippingPriceAdditionalUnit;
    }

    /**
     * Shipping price of the offer
     */
    @XmlElement(required = true, nillable = false, name = "shipping_price_unit")
    public BigDecimal getShippingPriceUnit() {
        return shippingPriceUnit;
    }

    public void setShippingPriceUnit(BigDecimal shippingPriceUnit) {
        this.shippingPriceUnit = shippingPriceUnit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklShippingTypeDetail that = (MiraklShippingTypeDetail) o;

        if (code != null ? !code.equals(that.code) : that.code != null) {
            return false;
        }
        if (label != null ? !label.equals(that.label) : that.label != null) {
            return false;
        }
        if (lineOnlyShippingPrice != null ? !lineOnlyShippingPrice.equals(that.lineOnlyShippingPrice) : that.lineOnlyShippingPrice != null) {
            return false;
        }
        if (lineOnlyTotalPrice != null ? !lineOnlyTotalPrice.equals(that.lineOnlyTotalPrice) : that.lineOnlyTotalPrice != null) {
            return false;
        }
        if (lineShippingPrice != null ? !lineShippingPrice.equals(that.lineShippingPrice) : that.lineShippingPrice != null) {
            return false;
        }
        if (lineTotalPrice != null ? !lineTotalPrice.equals(that.lineTotalPrice) : that.lineTotalPrice != null) {
            return false;
        }
        if (shippingPriceAdditionalUnit != null ? !shippingPriceAdditionalUnit.equals(that.shippingPriceAdditionalUnit) : that.shippingPriceAdditionalUnit != null) {
            return false;
        }

        return shippingPriceUnit != null ? shippingPriceUnit.equals(that.shippingPriceUnit) : that.shippingPriceUnit == null;
    }

    @Override
    public int hashCode() {
        int result = code != null ? code.hashCode() : 0;
        result = 31 * result + (label != null ? label.hashCode() : 0);
        result = 31 * result + (lineOnlyShippingPrice != null ? lineOnlyShippingPrice.hashCode() : 0);
        result = 31 * result + (lineOnlyTotalPrice != null ? lineOnlyTotalPrice.hashCode() : 0);
        result = 31 * result + (lineShippingPrice != null ? lineShippingPrice.hashCode() : 0);
        result = 31 * result + (lineTotalPrice != null ? lineTotalPrice.hashCode() : 0);
        result = 31 * result + (shippingPriceAdditionalUnit != null ? shippingPriceAdditionalUnit.hashCode() : 0);
        result = 31 * result + (shippingPriceUnit != null ? shippingPriceUnit.hashCode() : 0);
        return result;
    }
}
