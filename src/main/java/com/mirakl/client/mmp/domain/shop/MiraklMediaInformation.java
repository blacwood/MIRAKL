/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.shop;

import com.mirakl.client.domain.common.Unicity;

@Unicity(includeAll = true)
public class MiraklMediaInformation {

    /**
     * Logo's media URL
     */
    private String logo;

    /**
     * Banner's media URL
     */
    private String banner;


    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklMediaInformation that = (MiraklMediaInformation) o;

        if (logo != null ? !logo.equals(that.logo) : that.logo != null) {
            return false;
        }
        return banner != null ? banner.equals(that.banner) : that.banner == null;

    }

    @Override
    public int hashCode() {
        int result = logo != null ? logo.hashCode() : 0;
        result = 31 * result + (banner != null ? banner.hashCode() : 0);
        return result;
    }
}
