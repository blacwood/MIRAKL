/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.front.request.shipping;

import com.mirakl.client.core.internal.MiraklApiEndpoint;
import com.mirakl.client.core.internal.util.MiraklApiUtils;
import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.request.AbstractMiraklApiRequest;

import java.util.Locale;
import java.util.Map;

import static com.mirakl.client.mmp.front.core.internal.MiraklFrontApiEndpoint.SH01;

@Unicity(includeAll = true)
public class MiraklGetShippingFeesRequest extends AbstractMiraklApiRequest {

    private String shippingZoneCode;
    private Map<String, Integer> offersWithQuantity;
    private Map<String, String> shopsWithShippingType;
    private Locale locale;

    public MiraklGetShippingFeesRequest(String shippingZoneCode, Map<String, Integer> offersWithQuantity) {
        setShippingZoneCode(shippingZoneCode);
        setOffersWithQuantity(offersWithQuantity);
    }

    @Override
    public MiraklApiEndpoint getEndpoint() {
        return SH01;
    }

    @Override
    public Map<String, String> getQueryParams() {
        Map<String, String> result = super.getQueryParams();

        if (getShippingZoneCode() != null) {
            result.put("shipping_zone_code", getShippingZoneCode());
        }

        if (getOffersWithQuantity() != null) {
            result.put("offers", MiraklApiUtils.convertMapToStringParam(getOffersWithQuantity()));
        }

        if (getShopsWithShippingType() != null) {
            result.put("shops", MiraklApiUtils.convertMapToStringParam(getShopsWithShippingType()));
        }

        if(getLocale() != null) {
            result.put("locale", getLocale().toString());
        }

        return result;
    }

    public String getShippingZoneCode() {
        return shippingZoneCode;
    }

    /**
     * The code of the selected shipping zone.
     */
    public void setShippingZoneCode(String shippingZoneCode) {
        checkRequiredArgument(shippingZoneCode, "shippingZoneCode");
        this.shippingZoneCode = shippingZoneCode;
    }

    public Map<String, Integer> getOffersWithQuantity() {
        return offersWithQuantity;
    }

    /**
     * Selected offers with quantity represented by a map with the offer ID as key and the quantity requested as value
     */
    public void setOffersWithQuantity(Map<String, Integer> offersWithQuantity) {
        checkExpression(offersWithQuantity != null && !offersWithQuantity.isEmpty(), "offersWithQuantity is required");
        this.offersWithQuantity = offersWithQuantity;
    }

    public Map<String, String> getShopsWithShippingType() {
        return shopsWithShippingType;
    }

    /**
     * Selected shops with the shipping type represented by a map with the shop ID as key and the shipping type requested as value
     */
    public void setShopsWithShippingType(Map<String, String> shopsWithShippingType) {
        this.shopsWithShippingType = shopsWithShippingType;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklGetShippingFeesRequest that = (MiraklGetShippingFeesRequest) o;

        if (shippingZoneCode != null ? !shippingZoneCode.equals(that.shippingZoneCode) : that.shippingZoneCode != null) {
            return false;
        }
        if (offersWithQuantity != null ? !offersWithQuantity.equals(that.offersWithQuantity) : that.offersWithQuantity != null) {
            return false;
        }
        if (shopsWithShippingType != null ? !shopsWithShippingType.equals(that.shopsWithShippingType) : that.shopsWithShippingType != null) {
            return false;
        }
        return locale != null ? locale.equals(that.locale) : that.locale == null;

    }

    @Override
    public int hashCode() {
        int result = shippingZoneCode != null ? shippingZoneCode.hashCode() : 0;
        result = 31 * result + (offersWithQuantity != null ? offersWithQuantity.hashCode() : 0);
        result = 31 * result + (shopsWithShippingType != null ? shopsWithShippingType.hashCode() : 0);
        result = 31 * result + (locale != null ? locale.hashCode() : 0);
        return result;
    }
}
