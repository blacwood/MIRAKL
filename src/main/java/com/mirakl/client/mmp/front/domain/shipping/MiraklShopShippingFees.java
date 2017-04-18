/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.front.domain.shipping;

import com.mirakl.client.domain.common.Unicity;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties("total_count")
@Unicity(includeAll = true)
public class MiraklShopShippingFees {

    private List<String> offersNotFound;

    private List<MiraklShopShippingFee> shops = new ArrayList<MiraklShopShippingFee>();

    /**
     * List of offers ID that are not found or not available to shipping.
     */
    public List<String> getOffersNotFound() {
        return offersNotFound;
    }

    public void setOffersNotFound(List<String> offersNotFound) {
        this.offersNotFound = offersNotFound;
    }

    /**
     * Shipping fees information group by shop
     */
    public List<MiraklShopShippingFee> getShops() {
        return shops;
    }

    public void setShops(List<MiraklShopShippingFee> shops) {
        this.shops = shops;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklShopShippingFees that = (MiraklShopShippingFees) o;

        if (offersNotFound != null ? !offersNotFound.equals(that.offersNotFound) : that.offersNotFound != null) {
            return false;
        }
        return shops != null ? shops.equals(that.shops) : that.shops == null;

    }

    @Override
    public int hashCode() {
        int result = offersNotFound != null ? offersNotFound.hashCode() : 0;
        result = 31 * result + (shops != null ? shops.hashCode() : 0);
        return result;
    }
}
