/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.product;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.domain.offer.MiraklProductInformationWithReferences;
import org.codehaus.jackson.annotate.JsonUnwrapped;

import java.util.List;

@Unicity(includeAll = true)
public class MiraklProductWithOffers {
    @JsonUnwrapped
    private MiraklProductInformationWithReferences product;

    private List<MiraklOfferOnProduct> offers;

    private int totalCount;

    /**
     * Total count of the offers on the product (without filtering)
     */
    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public MiraklProductInformationWithReferences getProduct() {
        return product;
    }

    public void setProduct(MiraklProductInformationWithReferences product) {
        this.product = product;
    }

    public List<MiraklOfferOnProduct> getOffers() {
        return offers;
    }

    public void setOffers(List<MiraklOfferOnProduct> offers) {
        this.offers = offers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklProductWithOffers that = (MiraklProductWithOffers) o;

        if (totalCount != that.totalCount) {
            return false;
        }
        if (product != null ? !product.equals(that.product) : that.product != null) {
            return false;
        }
        return offers != null ? offers.equals(that.offers) : that.offers == null;

    }

    @Override
    public int hashCode() {
        int result = product != null ? product.hashCode() : 0;
        result = 31 * result + (offers != null ? offers.hashCode() : 0);
        result = 31 * result + totalCount;
        return result;
    }
}
