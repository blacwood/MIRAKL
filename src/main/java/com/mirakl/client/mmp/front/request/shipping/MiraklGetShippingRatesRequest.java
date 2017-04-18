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

import java.util.List;
import java.util.Locale;
import java.util.Map;

import static com.mirakl.client.mmp.front.core.internal.MiraklFrontApiEndpoint.SH02;

@Unicity(includeAll = true)
public class MiraklGetShippingRatesRequest extends AbstractMiraklApiRequest {

    private List<MiraklOfferQuantityShippingTypeTuple> offerQuantityShippingTypeTuples;
    private String shippingZoneCode;
    private Locale locale;

    public MiraklGetShippingRatesRequest(List<MiraklOfferQuantityShippingTypeTuple> offerQuantityShippingTypeTuples, String shippingZoneCode) {
        setOfferQuantityShippingTypeTuples(offerQuantityShippingTypeTuples);
        setShippingZoneCode(shippingZoneCode);
    }

    @Override
    public MiraklApiEndpoint getEndpoint() {
        return SH02;
    }

    @Override
    public Map<String, String> getQueryParams() {
        Map<String, String> result = super.getQueryParams();

        if (getShippingZoneCode() != null) {
            result.put("shipping_zone_code", getShippingZoneCode());
        }

        if (getOfferQuantityShippingTypeTuples() != null) {
            result.put("offers", MiraklApiUtils.convertCollectionToStringParam(getOfferQuantityShippingTypeTuples()));
        }

        if (getLocale() != null) {
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
        this.shippingZoneCode = shippingZoneCode;
    }

    public List<MiraklOfferQuantityShippingTypeTuple> getOfferQuantityShippingTypeTuples() {
        return offerQuantityShippingTypeTuples;
    }

    /**
     * Selected offers with quantity and shipping type for each offer
     */
    public void setOfferQuantityShippingTypeTuples(List<MiraklOfferQuantityShippingTypeTuple> offerQuantityShippingTypeTuples) {
        checkRequiredArgument(offerQuantityShippingTypeTuples, "offerQuantityShippingTypeTuples");
        this.offerQuantityShippingTypeTuples = offerQuantityShippingTypeTuples;
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

        MiraklGetShippingRatesRequest that = (MiraklGetShippingRatesRequest) o;

        if (offerQuantityShippingTypeTuples != null ? !offerQuantityShippingTypeTuples.equals(that.offerQuantityShippingTypeTuples) : that.offerQuantityShippingTypeTuples != null) {
            return false;
        }
        if (shippingZoneCode != null ? !shippingZoneCode.equals(that.shippingZoneCode) : that.shippingZoneCode != null) {
            return false;
        }
        return locale != null ? locale.equals(that.locale) : that.locale == null;

    }

    @Override
    public int hashCode() {
        int result = offerQuantityShippingTypeTuples != null ? offerQuantityShippingTypeTuples.hashCode() : 0;
        result = 31 * result + (shippingZoneCode != null ? shippingZoneCode.hashCode() : 0);
        result = 31 * result + (locale != null ? locale.hashCode() : 0);
        return result;
    }
}
