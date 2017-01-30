/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.operator.domain.shop.create;

import com.mirakl.client.domain.common.Unicity;

@Unicity(props = "email")
public class MiraklCreateShopExistingUser {

    private String email;

    public MiraklCreateShopExistingUser() {
    }

    public MiraklCreateShopExistingUser(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MiraklCreateShopExistingUser)) return false;

        MiraklCreateShopExistingUser that = (MiraklCreateShopExistingUser) o;

        if (email != null ? !email.equals(that.email) : that.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return email != null ? email.hashCode() : 0;
    }
}
