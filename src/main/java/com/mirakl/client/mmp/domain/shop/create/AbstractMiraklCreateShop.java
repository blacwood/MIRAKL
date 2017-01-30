/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.shop.create;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.domain.shop.AbstractCommonMiraklShop;

@Unicity(includeAll = true)
public class AbstractMiraklCreateShop extends AbstractCommonMiraklShop {


    private MiraklCreateShopAddress address;

    public MiraklCreateShopAddress getAddress() {
        return address;
    }

    public void setAddress(MiraklCreateShopAddress address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        AbstractMiraklCreateShop that = (AbstractMiraklCreateShop) o;

        return !(address != null ? !address.equals(that.address) : that.address != null);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }
}
