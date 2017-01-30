/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.shop.create;

import com.mirakl.client.domain.common.Unicity;

/**
 * @deprecated Please use {@code com.mirakl.client.mmp.front.domain.shop.create.MiraklCreateShop} or {@code com.mirakl.client.mmp.operator.domain.shop.create.MiraklCreateShop} instead
 */
@Deprecated
@Unicity(includeAll = true)
public class MiraklCreateShop extends AbstractMiraklCreateShop {

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MiraklCreateShop)) return false;
        if (!super.equals(o)) return false;

        MiraklCreateShop that = (MiraklCreateShop) o;

        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
