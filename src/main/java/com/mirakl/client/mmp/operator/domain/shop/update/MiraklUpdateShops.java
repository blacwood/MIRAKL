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
public class MiraklUpdateShops {

    private List<MiraklUpdateShop> shops;

    public MiraklUpdateShops(List<MiraklUpdateShop> shops) {
        this.shops = shops;
    }

    public List<MiraklUpdateShop> getShops() {
        return shops;
    }

    public void setShops(List<MiraklUpdateShop> shops) {
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

        MiraklUpdateShops that = (MiraklUpdateShops) o;

        return shops != null ? shops.equals(that.shops) : that.shops == null;

    }

    @Override
    public int hashCode() {
        return shops != null ? shops.hashCode() : 0;
    }
}
