/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.request.shop.document;

import com.mirakl.client.core.internal.util.MiraklApiUtils;
import com.mirakl.client.domain.common.Unicity;

import java.util.Collection;
import java.util.Map;

@Unicity(includeAll = true)
public class MiraklDownloadShopsDocumentsRequest extends AbstractMiraklDownloadShopsDocumentsRequest {

    private Collection<String> shopIds;

    @Override
    public Map<String, String> getQueryParams() {
        Map<String, String> params = super.getQueryParams();

        if (shopIds != null) {
            params.put("shop_ids", MiraklApiUtils.convertCollectionToStringParam(shopIds));
        }

        return params;
    }

    public Collection<String> getShopIds() {
        return shopIds;
    }

    public void setShopIds(Collection<String> shopIds) {
        checkParams(shopIds, getDocumentIds());
        this.shopIds = shopIds;
    }

    public void setDocumentIds(Collection<String> documentIds) {
        checkParams(getShopIds(), documentIds);
        super.setDocumentIds(documentIds);
    }

    private void checkParams(Collection<String> shopIds, Collection<String> documentIds) {
        boolean orderIdsIsSet = shopIds != null && !shopIds.isEmpty();
        boolean documentIdsIsSet = documentIds != null && !documentIds.isEmpty();
        checkExpression(orderIdsIsSet || documentIdsIsSet, "you must set either shopIds or documentIds");
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

        MiraklDownloadShopsDocumentsRequest that = (MiraklDownloadShopsDocumentsRequest) o;

        return shopIds != null ? shopIds.equals(that.shopIds) : that.shopIds == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (shopIds != null ? shopIds.hashCode() : 0);
        return result;
    }
}
