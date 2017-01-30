/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.operator.domain.shop.update;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.domain.shop.MiraklShop;

@Unicity(includeAll = true)
public class MiraklUpdatedShopReturn {

    private MiraklShop shopUpdated;
    private MiraklUpdateShopWithErrors shopError;

    public MiraklShop getShopUpdated() {
        return shopUpdated;
    }

    public void setShopUpdated(MiraklShop shopUpdated) {
        this.shopUpdated = shopUpdated;
    }

    public MiraklUpdateShopWithErrors getShopError() {
        return shopError;
    }

    public void setShopError(MiraklUpdateShopWithErrors shopError) {
        this.shopError = shopError;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklUpdatedShopReturn that = (MiraklUpdatedShopReturn) o;

        if (shopUpdated != null ? !shopUpdated.equals(that.shopUpdated) : that.shopUpdated != null) {
            return false;
        }
        return shopError != null ? shopError.equals(that.shopError) : that.shopError == null;

    }

    @Override
    public int hashCode() {
        int result = shopUpdated != null ? shopUpdated.hashCode() : 0;
        result = 31 * result + (shopError != null ? shopError.hashCode() : 0);
        return result;
    }
}
