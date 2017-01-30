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
public class MiraklUploadShopDocumentsRequest extends AbstractMiraklUploadShopsDocumentsRequest {

    private String shopId;

    public MiraklUploadShopDocumentsRequest(String shopId, List<MiraklUploadDocument> documents) {
        setShopId(shopId);
        setDocuments(documents);
    }

    public String getShopId() {
        return shopId;
    }

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

        MiraklUploadShopDocumentsRequest that = (MiraklUploadShopDocumentsRequest) o;

        return shopId != null ? shopId.equals(that.shopId) : that.shopId == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (shopId != null ? shopId.hashCode() : 0);
        return result;
    }
}
