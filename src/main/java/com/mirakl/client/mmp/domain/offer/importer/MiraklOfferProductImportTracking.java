/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.offer.importer;

import com.mirakl.client.domain.common.Unicity;

@Unicity(props = "importId")
public class MiraklOfferProductImportTracking extends MiraklOfferImportTracking {

    private String productImportId;

    public String getProductImportId() {
        return productImportId;
    }

    public void setProductImportId(String productImportId) {
        this.productImportId = productImportId;
    }
}
