/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.front.domain.shop.create;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.domain.shop.create.AbstractMiraklCreateShop;
import org.codehaus.jackson.annotate.JsonProperty;

@Unicity(includeAll = true)
public class MiraklCreateShop extends AbstractMiraklCreateShop {

    @JsonProperty("new_user")
    protected MiraklCreateShopNewUser newUser;
    @JsonProperty("existing_user")
    protected MiraklCreateShopExistingUser existingUser;

    public MiraklCreateShopNewUser getNewUser() {
        return newUser;
    }

    public void setNewUser(MiraklCreateShopNewUser newUser) {
        this.newUser = newUser;
    }

    public MiraklCreateShopExistingUser getExistingUser() {
        return existingUser;
    }

    public void setExistingUser(MiraklCreateShopExistingUser existingUser) {
        this.existingUser = existingUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MiraklCreateShop)) return false;

        MiraklCreateShop that = (MiraklCreateShop) o;

        if (existingUser != null ? !existingUser.equals(that.existingUser) : that.existingUser != null) return false;
        if (newUser != null ? !newUser.equals(that.newUser) : that.newUser != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = newUser != null ? newUser.hashCode() : 0;
        result = 31 * result + (existingUser != null ? existingUser.hashCode() : 0);
        return result;
    }
}
