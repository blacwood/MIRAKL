/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.operator.request.offer.importer;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.domain.offer.importer.ImportMode;
import com.mirakl.client.mmp.request.offer.importer.AbstractMiraklOfferImportRequest;

import java.io.File;
import java.io.InputStream;

@Unicity(includeAll = true)
public class MiraklOfferImportRequest extends AbstractMiraklOfferImportRequest {

    private String shopId;

    public MiraklOfferImportRequest(String shopId, ImportMode importMode, File file) {
        setShopId(shopId);
        setFile(file);
        setImportMode(importMode);
    }

    public MiraklOfferImportRequest(String shopId, ImportMode importMode, InputStream inputStream) {
        setShopId(shopId);
        setImportMode(importMode);
        setInputStream(inputStream);
    }

    public MiraklOfferImportRequest(String shopId, ImportMode importMode, InputStream inputStream, String filename) {
        this(shopId, importMode, inputStream);
        setFilename(filename);
    }

    public String getShopId() {
        return shopId;
    }

    /**
     * Shop ID for the offers import
     */
    public void setShopId(String shopId) {
        checkRequiredArgument(shopId, "shopId");
        this.shopId = shopId;
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

        MiraklOfferImportRequest that = (MiraklOfferImportRequest) o;

        return shopId != null ? shopId.equals(that.shopId) : that.shopId == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (shopId != null ? shopId.hashCode() : 0);
        return result;
    }
}
