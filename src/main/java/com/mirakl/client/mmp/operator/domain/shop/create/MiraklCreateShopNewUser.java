/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.operator.domain.shop.create;

import com.mirakl.client.domain.common.Unicity;

import java.util.Locale;

@Unicity(props = "email")
public class MiraklCreateShopNewUser {

    private String email;

    private Locale locale;

    public MiraklCreateShopNewUser() {
    }

    public MiraklCreateShopNewUser(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MiraklCreateShopNewUser)) return false;

        MiraklCreateShopNewUser that = (MiraklCreateShopNewUser) o;

        if (email != null ? !email.equals(that.email) : that.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return email != null ? email.hashCode() : 0;
    }
}
