/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.request.shop.document;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.request.shop.AbstractMiraklGetShopDocumentsRequest;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static com.mirakl.client.core.internal.util.MiraklApiUtils.convertCollectionToStringParam;

@Unicity(includeAll = true)
public class MiraklGetShopDocumentsRequest extends AbstractMiraklGetShopDocumentsRequest {

    private Collection<String> shopIds;

    public MiraklGetShopDocumentsRequest(Collection<String> shopIds) {
        setShopIds(shopIds);
    }

    @Override
    public Map<String, String> getQueryParams() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("shop_ids", convertCollectionToStringParam(shopIds));
        return params;
    }

    public Collection<String> getShopIds() {
        return shopIds;
    }

    /**
     * Filter by shop IDs
     */
    public void setShopIds(Collection<String> shopIds) {
        checkRequiredArgument(shopIds, "shopIds");
        this.shopIds = shopIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklGetShopDocumentsRequest that = (MiraklGetShopDocumentsRequest) o;

        return shopIds != null ? shopIds.equals(that.shopIds) : that.shopIds == null;

    }

    @Override
    public int hashCode() {
        return shopIds != null ? shopIds.hashCode() : 0;
    }
}
