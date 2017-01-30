/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.order;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.domain.shipping.MiraklShippingType;
import com.mirakl.client.mmp.domain.shipping.MiraklShippingZone;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonUnwrapped;

import java.math.BigDecimal;

@Unicity(includeAll = true)
public class MiraklOrderShipping {

    @JsonProperty("shipping_price")
    private BigDecimal price;

    @JsonUnwrapped
    private MiraklShippingZone zone;

    @JsonUnwrapped
    private MiraklShippingType type;

    @JsonProperty("shipping_company")
    private String carrier;

    @JsonProperty("shipping_carrier_code")
    private String carrierCode;

    @JsonProperty("shipping_tracking")
    private String trackingNumber;

    @JsonProperty("shipping_tracking_url")
    private String trackingUrl;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public MiraklShippingZone getZone() {
        return zone;
    }

    public void setZone(MiraklShippingZone zone) {
        this.zone = zone;
    }

    public MiraklShippingType getType() {
        return type;
    }

    public void setType(MiraklShippingType type) {
        this.type = type;
    }

    /**
     * Shipping carrier name of the order
     */
    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getCarrierCode() {
        return carrierCode;
    }

    public void setCarrierCode(String carrierCode) {
        this.carrierCode = carrierCode;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getTrackingUrl() {
        return trackingUrl;
    }

    public void setTrackingUrl(String trackingUrl) {
        this.trackingUrl = trackingUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklOrderShipping that = (MiraklOrderShipping) o;

        if (price != null ? !price.equals(that.price) : that.price != null) {
            return false;
        }
        if (zone != null ? !zone.equals(that.zone) : that.zone != null) {
            return false;
        }
        if (type != null ? !type.equals(that.type) : that.type != null) {
            return false;
        }
        if (carrier != null ? !carrier.equals(that.carrier) : that.carrier != null) {
            return false;
        }
        if (trackingNumber != null ? !trackingNumber.equals(that.trackingNumber) : that.trackingNumber != null) {
            return false;
        }
        return trackingUrl != null ? trackingUrl.equals(that.trackingUrl) : that.trackingUrl == null;

    }

    @Override
    public int hashCode() {
        int result = price != null ? price.hashCode() : 0;
        result = 31 * result + (zone != null ? zone.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (carrier != null ? carrier.hashCode() : 0);
        result = 31 * result + (trackingNumber != null ? trackingNumber.hashCode() : 0);
        result = 31 * result + (trackingUrl != null ? trackingUrl.hashCode() : 0);
        return result;
    }
}
