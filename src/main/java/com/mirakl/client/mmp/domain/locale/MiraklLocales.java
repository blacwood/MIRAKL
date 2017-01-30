/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.locale;

import com.mirakl.client.domain.common.Unicity;

import java.util.List;

@Unicity(includeAll = true)
public class MiraklLocales {

    private List<MiraklLocale> locales;

    public List<MiraklLocale> getLocales() {
        return locales;
    }

    public void setLocales(List<MiraklLocale> locales) {
        this.locales = locales;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklLocales that = (MiraklLocales) o;

        return locales != null ? locales.equals(that.locales) : that.locales == null;

    }

    @Override
    public int hashCode() {
        return locales != null ? locales.hashCode() : 0;
    }
}
