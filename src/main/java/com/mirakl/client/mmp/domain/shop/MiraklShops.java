/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.shop;

import com.mirakl.client.domain.common.Unicity;

import java.util.List;

@Unicity(includeAll = true)
public class MiraklShops {

    private List<MiraklShop> shops;

    private Long totalCount;

    public List<MiraklShop> getShops() {
        return shops;
    }

    public void setShops(List<MiraklShop> shops) {
        this.shops = shops;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklShops that = (MiraklShops) o;

        if (shops != null ? !shops.equals(that.shops) : that.shops != null) {
            return false;
        }
        return totalCount != null ? totalCount.equals(that.totalCount) : that.totalCount == null;

    }

    @Override
    public int hashCode() {
        int result = shops != null ? shops.hashCode() : 0;
        result = 31 * result + (totalCount != null ? totalCount.hashCode() : 0);
        return result;
    }
}
