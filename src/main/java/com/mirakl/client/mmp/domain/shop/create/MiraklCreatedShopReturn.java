/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.shop.create;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.domain.shop.MiraklShop;

/**
 * @deprecated Please use {@code com.mirakl.client.mmp.front.domain.shop.create.MiraklCreatedShopReturn} or {@code com.mirakl.client.mmp.operator.domain.shop.create.MiraklCreatedShopReturn} instead
 */
@Deprecated
@Unicity(includeAll = true)
public class MiraklCreatedShopReturn {

    private MiraklShop shopCreated;
    private MiraklShopWithErrors shopError;

    public MiraklShop getShopCreated() {
        return shopCreated;
    }

    public void setShopCreated(MiraklShop shopCreated) {
        this.shopCreated = shopCreated;
    }

    public MiraklShopWithErrors getShopError() {
        return shopError;
    }

    public void setShopError(MiraklShopWithErrors shopError) {
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

        MiraklCreatedShopReturn that = (MiraklCreatedShopReturn) o;

        if (shopCreated != null ? !shopCreated.equals(that.shopCreated) : that.shopCreated != null) {
            return false;
        }
        return shopError != null ? shopError.equals(that.shopError) : that.shopError == null;

    }

    @Override
    public int hashCode() {
        int result = shopCreated != null ? shopCreated.hashCode() : 0;
        result = 31 * result + (shopError != null ? shopError.hashCode() : 0);
        return result;
    }
}
