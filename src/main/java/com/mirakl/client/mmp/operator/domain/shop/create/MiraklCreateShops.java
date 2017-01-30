/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.operator.domain.shop.create;


import com.mirakl.client.domain.common.Unicity;

import java.util.List;

@Unicity(includeAll = true)
public class MiraklCreateShops {

    private List<MiraklCreateShop> shops;

    public MiraklCreateShops(List<MiraklCreateShop> shops) {
        this.shops = shops;
    }

    public List<MiraklCreateShop> getShops() {
        return shops;
    }

    public void setShops(List<MiraklCreateShop> shops) {
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

        MiraklCreateShops that = (MiraklCreateShops) o;

        return shops != null ? shops.equals(that.shops) : that.shops == null;

    }

    @Override
    public int hashCode() {
        return shops != null ? shops.hashCode() : 0;
    }
}
