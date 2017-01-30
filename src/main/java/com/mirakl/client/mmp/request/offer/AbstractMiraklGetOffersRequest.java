/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.request.offer;


import com.mirakl.client.core.internal.util.MiraklApiUtils;
import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.request.common.sort.AbstractMiraklSortRequest;
import com.mirakl.client.request.common.sort.OrderBy;
import com.mirakl.client.request.common.sort.Sort;

import java.util.Collection;
import java.util.Map;

@Unicity(includeAll = true)
public abstract class AbstractMiraklGetOffersRequest extends AbstractMiraklSortRequest<AbstractMiraklGetOffersRequest.OfferSort> {

    private Collection<String> offerStateCodes;

    private boolean favorite;

    @Override
    public Map<String, String> getQueryParams() {
        Map<String, String> params = super.getQueryParams();

        if (offerStateCodes != null) {
            params.put("offer_state_codes", MiraklApiUtils.convertCollectionToStringParam(offerStateCodes));
        }
        if (favorite) {
            params.put("favorite", Boolean.TRUE.toString());
        }

        return params;
    }

    public Collection<String> getOfferStateCodes() {
        return offerStateCodes;
    }

    /**
     * Filter by a list of offer state codes (optional)
     */
    public void setOfferStateCodes(Collection<String> offerStateCodes) {
        this.offerStateCodes = offerStateCodes;
    }

    public boolean isFavorite() {
        return favorite;
    }

    /**
     * Filter only the favorite offers. (optional, default false)
     */
    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public static enum OfferSort implements Sort {

        /**
         * (DEFAULT) Sort by total price
         */
        TOTAL_PRICE("totalPrice"),
        /**
         * Sort by price, total price
         */
        PRICE("price"),
        /**
         * Sort by product title, total price
         */
        PRODUCT_TITLE("productTitle");

        private final String value;

        OfferSort(String value) {
            this.value = value;
        }

        @Override
        public String getValue() {
            return value;
        }

        public OrderBy<OfferSort> asc() {
            return new OrderBy<OfferSort>(this, OrderBy.Order.ASC);
        }

        public OrderBy<OfferSort> desc() {
            return new OrderBy<OfferSort>(this, OrderBy.Order.DESC);
        }
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

        AbstractMiraklGetOffersRequest that = (AbstractMiraklGetOffersRequest) o;

        if (favorite != that.favorite) {
            return false;
        }
        return offerStateCodes != null ? offerStateCodes.equals(that.offerStateCodes) : that.offerStateCodes == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (offerStateCodes != null ? offerStateCodes.hashCode() : 0);
        result = 31 * result + (favorite ? 1 : 0);
        return result;
    }
}
