/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.request.shop.document;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.request.common.document.MiraklUploadDocument;

import java.util.List;

@Unicity(includeAll = true)
public class MiraklUploadShopDocumentWrapper {

    private List<MiraklUploadDocument> shopDocuments;

    public MiraklUploadShopDocumentWrapper(List<MiraklUploadDocument> shopDocuments) {
        this.shopDocuments = shopDocuments;
    }

    public List<MiraklUploadDocument> getShopDocuments() {
        return shopDocuments;
    }

    public void setShopDocuments(List<MiraklUploadDocument> shopDocuments) {
        this.shopDocuments = shopDocuments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklUploadShopDocumentWrapper that = (MiraklUploadShopDocumentWrapper) o;

        return shopDocuments != null ? shopDocuments.equals(that.shopDocuments) : that.shopDocuments == null;

    }

    @Override
    public int hashCode() {
        return shopDocuments != null ? shopDocuments.hashCode() : 0;
    }
}
