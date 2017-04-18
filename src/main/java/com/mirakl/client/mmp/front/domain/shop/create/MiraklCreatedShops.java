/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.front.domain.shop.create;

import com.mirakl.client.domain.common.Unicity;

import java.util.List;

@Unicity(includeAll = true)
public class MiraklCreatedShops {

    private List<MiraklCreatedShopReturn> shopReturns;

    public List<MiraklCreatedShopReturn> getShopReturns() {
        return shopReturns;
    }

    public void setShopReturns(List<MiraklCreatedShopReturn> shopReturns) {
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

        MiraklCreatedShops that = (MiraklCreatedShops) o;

        return shopReturns != null ? shopReturns.equals(that.shopReturns) : that.shopReturns == null;

    }

    @Override
    public int hashCode() {
        return shopReturns != null ? shopReturns.hashCode() : 0;
    }
}
