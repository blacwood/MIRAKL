/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.offer;

import com.mirakl.client.domain.common.Unicity;
import org.codehaus.jackson.annotate.JsonProperty;

import java.math.BigDecimal;

@Unicity(includeAll = true)
public class MiraklOfferMinimumShipping {

    @JsonProperty("min_shipping_price")
    private BigDecimal price;
    @JsonProperty("min_shipping_price_additional")
    private BigDecimal priceAdditional;
    @JsonProperty("min_shipping_zone")
    private String zoneCode;
    @JsonProperty("min_shipping_type")
    private String typeCode;

    /**
     * Minimun shipping price available for this offer
     */
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * Minimun additional shipping price available for this offer
     */
    public BigDecimal getPriceAdditional() {
        return priceAdditional;
    }

    public void setPriceAdditional(BigDecimal priceAdditional) {
        this.priceAdditional = priceAdditional;
    }

    /**
     * Shipping zoneCode code associated to the minimum shipping price
     */
    public String getZoneCode() {
        return zoneCode;
    }

    public void setZoneCode(String zoneCode) {
        this.zoneCode = zoneCode;
    }

    /**
     * Shipping typeCode code associated to the minimum shipping price
     */
    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklOfferMinimumShipping that = (MiraklOfferMinimumShipping) o;

        if (price != null ? !price.equals(that.price) : that.price != null) {
            return false;
        }
        if (priceAdditional != null ? !priceAdditional.equals(that.priceAdditional) : that.priceAdditional != null) {
            return false;
        }
        if (zoneCode != null ? !zoneCode.equals(that.zoneCode) : that.zoneCode != null) {
            return false;
        }
        return typeCode != null ? typeCode.equals(that.typeCode) : that.typeCode == null;

    }

    @Override
    public int hashCode() {
        int result = price != null ? price.hashCode() : 0;
        result = 31 * result + (priceAdditional != null ? priceAdditional.hashCode() : 0);
        result = 31 * result + (zoneCode != null ? zoneCode.hashCode() : 0);
        result = 31 * result + (typeCode != null ? typeCode.hashCode() : 0);
        return result;
    }
}
