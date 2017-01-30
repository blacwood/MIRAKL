/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.version;

import com.mirakl.client.domain.common.Unicity;

@Unicity(includeAll = true)
public class MiraklVersion {

    private String version;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklVersion that = (MiraklVersion) o;

        return version != null ? version.equals(that.version) : that.version == null;

    }

    @Override
    public int hashCode() {
        return version != null ? version.hashCode() : 0;
    }
}
