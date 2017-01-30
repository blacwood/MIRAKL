/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.shop.document;

import com.mirakl.client.domain.common.Unicity;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties("total_count")
@Unicity(includeAll = true)
public class MiraklShopDocuments {

    private List<MiraklShopDocument> shopDocuments;

    public List<MiraklShopDocument> getShopDocuments() {
        return shopDocuments;
    }

    public void setShopDocuments(List<MiraklShopDocument> shopDocuments) {
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

        MiraklShopDocuments that = (MiraklShopDocuments) o;

        return shopDocuments != null ? shopDocuments.equals(that.shopDocuments) : that.shopDocuments == null;

    }

    @Override
    public int hashCode() {
        return shopDocuments != null ? shopDocuments.hashCode() : 0;
    }
}
