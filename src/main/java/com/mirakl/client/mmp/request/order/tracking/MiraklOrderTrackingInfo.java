/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.request.order.tracking;

import com.mirakl.client.domain.common.Unicity;

@Unicity(includeAll = true)
public class MiraklOrderTrackingInfo {

    private String carrierCode;
    private String carrierName;
    private String carrierUrl;
    private String trackingNumber;

    public String getCarrierCode() {
        return carrierCode;
    }

    /**
     * The code of a carrier. This information is mandatory for a registered carrier.
     */
    public void setCarrierCode(String carrierCode) {
        this.carrierCode = carrierCode;
    }

    public String getCarrierName() {
        return carrierName;
    }

    /**
     * The name of a carrier. This information is mandatory for an unregistered carrier.
     */
    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    public String getCarrierUrl() {
        return carrierUrl;
    }

    /**
     * The tracking url of a carrier. This information is unused for registered carriers (because computed automatically). This information is optional for unregistered carriers.
     */
    public void setCarrierUrl(String carrierUrl) {
        this.carrierUrl = carrierUrl;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    /**
     * The carrier tracking number. This information is mandatory.
     */
    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklOrderTrackingInfo that = (MiraklOrderTrackingInfo) o;

        if (carrierCode != null ? !carrierCode.equals(that.carrierCode) : that.carrierCode != null) {
            return false;
        }
        if (carrierName != null ? !carrierName.equals(that.carrierName) : that.carrierName != null) {
            return false;
        }
        if (carrierUrl != null ? !carrierUrl.equals(that.carrierUrl) : that.carrierUrl != null) {
            return false;
        }
        return trackingNumber != null ? trackingNumber.equals(that.trackingNumber) : that.trackingNumber == null;

    }

    @Override
    public int hashCode() {
        int result = carrierCode != null ? carrierCode.hashCode() : 0;
        result = 31 * result + (carrierName != null ? carrierName.hashCode() : 0);
        result = 31 * result + (carrierUrl != null ? carrierUrl.hashCode() : 0);
        result = 31 * result + (trackingNumber != null ? trackingNumber.hashCode() : 0);
        return result;
    }
}
