/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.offer.importer;

import com.mirakl.client.domain.common.Unicity;

@Unicity(props = "importId")
public class MiraklOfferImportTracking {

    private String importId;

    public String getImportId() {
        return importId;
    }

    public void setImportId(String importId) {
        this.importId = importId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklOfferImportTracking that = (MiraklOfferImportTracking) o;

        return importId != null ? importId.equals(that.importId) : that.importId == null;

    }

    @Override
    public int hashCode() {
        return importId != null ? importId.hashCode() : 0;
    }
}
