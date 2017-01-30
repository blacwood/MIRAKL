/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.product;

import com.mirakl.client.domain.common.Unicity;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties("total_count")
@Unicity(includeAll = true)
public abstract class AbstractMiraklProducts<T extends AbstractMiraklProduct> {

    private List<T> products;

    public List<T> getProducts() {
        return products;
    }

    public void setProducts(List<T> products) {
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

        AbstractMiraklProducts<?> that = (AbstractMiraklProducts<?>) o;

        return products != null ? products.equals(that.products) : that.products == null;

    }

    @Override
    public int hashCode() {
        return products != null ? products.hashCode() : 0;
    }
}
