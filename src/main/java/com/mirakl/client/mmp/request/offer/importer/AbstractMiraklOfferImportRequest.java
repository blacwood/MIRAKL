/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.request.offer.importer;

import com.mirakl.client.core.internal.MiraklApiEndpoint;
import com.mirakl.client.core.internal.MiraklOperatorShopApiEndpoint;
import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.domain.offer.importer.ImportMode;
import com.mirakl.client.request.common.synchro.AbstractMiraklRequestWithFile;

@Unicity(includeAll = true)
public abstract class AbstractMiraklOfferImportRequest extends AbstractMiraklRequestWithFile {

    private ImportMode importMode;
    private boolean withProducts;

    @Override
    public MiraklApiEndpoint getEndpoint() {
        return MiraklOperatorShopApiEndpoint.OF01;
    }

    public ImportMode getImportMode() {
        return importMode;
    }

    public void setImportMode(ImportMode importMode) {
        checkRequiredArgument(importMode, "importMode");
        this.importMode = importMode;
    }

    public boolean isWithProducts() {
        return withProducts;
    }

    public void setWithProducts(boolean withProducts) {
        this.withProducts = withProducts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        AbstractMiraklOfferImportRequest that = (AbstractMiraklOfferImportRequest) o;

        if (withProducts != that.withProducts) {
            return false;
        }
        return importMode == that.importMode;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (importMode != null ? importMode.hashCode() : 0);
        result = 31 * result + (withProducts ? 1 : 0);
        return result;
    }
}
