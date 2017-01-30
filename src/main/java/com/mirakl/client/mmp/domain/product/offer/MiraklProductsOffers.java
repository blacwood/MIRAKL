/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.product.offer;

import com.mirakl.client.domain.common.Unicity;

import java.util.List;

@Deprecated
/**
 * @deprecated Please use {@link com.mirakl.client.mmp.shop.domain.product.MiraklProductsOffers} or {@link com.mirakl.client.mmp.domain.product.MiraklProductsOffers}
 */
@Unicity(includeAll = true)
public class MiraklProductsOffers {

    private List<MiraklProductWithOffers> products;

    public List<MiraklProductWithOffers> getProducts() {
        return products;
    }

    public void setProducts(List<MiraklProductWithOffers> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklProductsOffers that = (MiraklProductsOffers) o;

        return products != null ? products.equals(that.products) : that.products == null;

    }

    @Override
    public int hashCode() {
        return products != null ? products.hashCode() : 0;
    }
}
