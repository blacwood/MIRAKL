/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.operator.request.shop;
import com.mirakl.client.core.internal.MiraklApiEndpoint;
import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.core.internal.MiraklFrontOperatorApiEndpoint;
import com.mirakl.client.mmp.operator.domain.shop.create.MiraklCreateShop;
import com.mirakl.client.request.AbstractMiraklApiRequest;

import java.util.List;

@Unicity(includeAll = true)
public class MiraklCreateShopsRequest extends AbstractMiraklApiRequest {

    private List<MiraklCreateShop> shops;

    public MiraklCreateShopsRequest(List<MiraklCreateShop> shops) {
        setShops(shops);
    }

    @Override
    public MiraklApiEndpoint getEndpoint() {
        return MiraklFrontOperatorApiEndpoint.S06;
    }

    public List<MiraklCreateShop> getShops() {
        return shops;
    }

    public void setShops(List<MiraklCreateShop> shops) {
        checkRequiredArgument(shops, "shops");
        this.shops = shops;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklCreateShopsRequest that = (MiraklCreateShopsRequest) o;

        return shops != null ? shops.equals(that.shops) : that.shops == null;

    }

    @Override
    public int hashCode() {
        return shops != null ? shops.hashCode() : 0;
    }
}
