/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.operator.domain.shop.update;

import com.mirakl.client.domain.common.Unicity;

import java.util.List;

@Unicity(includeAll = true)
public class MiraklUpdatedShops {

    private List<MiraklUpdatedShopReturn> shopReturns;

    public List<MiraklUpdatedShopReturn> getShopReturns() {
        return shopReturns;
    }

    public void setShopReturns(List<MiraklUpdatedShopReturn> shopReturns) {
        this.shopReturns = shopReturns;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklUpdatedShops that = (MiraklUpdatedShops) o;

        return shopReturns != null ? shopReturns.equals(that.shopReturns) : that.shopReturns == null;

    }

    @Override
    public int hashCode() {
        return shopReturns != null ? shopReturns.hashCode() : 0;
    }
}
