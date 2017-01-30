/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.request.product.offer;

import com.mirakl.client.core.internal.MiraklApiEndpoint;
import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.core.internal.MiraklMarketplacePlatformCommonApiEndpoint;
import com.mirakl.client.mmp.request.product.ProductReferencesParameter;
import com.mirakl.client.request.common.sort.AbstractMiraklSortRequest;
import com.mirakl.client.request.common.sort.OrderBy;
import com.mirakl.client.request.common.sort.Sort;

import java.util.Collection;
import java.util.Map;

import static com.mirakl.client.core.internal.util.MiraklApiUtils.convertCollectionToStringParam;

@Unicity(includeAll = true)
public abstract class AbstractMiraklGetOffersOnProductsRequest extends AbstractMiraklSortRequest<AbstractMiraklGetOffersOnProductsRequest.OfferSort> {

    protected Collection<String> productIds;
    protected ProductReferencesParameter productReferences;
    protected Collection<String> offerStateCodes;
    protected boolean allOffers;
    protected Collection<String> channelCodes;
    protected boolean allChannels;

    @Override
    public MiraklApiEndpoint getEndpoint() {
        return MiraklMarketplacePlatformCommonApiEndpoint.P11;
    }

    @Override
    public Map<String, String> getQueryParams() {
        Map<String, String> params = super.getQueryParams();
        if (productIds != null) {
            params.put("product_ids", convertCollectionToStringParam(productIds));
        }

        if (productReferences != null) {
            params.put("product_references", productReferences.toQueryParam());
        }

        if (offerStateCodes != null) {
            params.put("offer_state_codes", convertCollectionToStringParam(offerStateCodes));
        }

        if (allOffers) {
            params.put("all_offers", Boolean.TRUE.toString());
        }

        if (channelCodes != null) {
            params.put("channel_codes", convertCollectionToStringParam(channelCodes));
        }

        if (allChannels) {
            params.put("all_channels", Boolean.TRUE.toString());
        }

        return params;
    }

    /**
     * REQUIRED - List of product's skus separated with comma. Limited to 100 values.
     */
    public void setProductIds(Collection<String> productIds) {
        if (productReferences == null) {
            checkRequiredArgument(productIds, "productIds");
        }
        this.productIds = productIds;
    }

    /**
     * REQUIRED - List of product's references separated with comma. Limited to 100 values.
     */
    public void setProductReferences(ProductReferencesParameter productReferences) {
        if (productIds == null) {
            checkRequiredArgument(productReferences, "productReferences");
        }
        this.productReferences = productReferences;
    }

    /**
     * Filter by offer state codes
     */
    public void setOfferStateCodes(Collection<String> offerStateCodes) {
        this.offerStateCodes = offerStateCodes;
    }

    public Collection<String> getOfferStateCodes() {
        return offerStateCodes;
    }

    /**
     * Filter only active offers
     * Default value is true, only active offers will be returned
     * If set to false, only inactive offers will be returned
     */
    public void setAllOffers(boolean allOffers) {
        this.allOffers = allOffers;
    }

    /**
     * Filter by channels
     */
    public void setChannelCodes(Collection<String> channelCodes) {
        this.channelCodes = channelCodes;
    }

    /**
     * Default value is false and filter the offers with the given {@link #channelCodes} param of the default channel of the platform if no {@link #channelCodes} are given.
     * If set to true, no filtering on channels will be applied and the {@link #channelCodes} param will be ignored.
     */
    public void setAllChannels(boolean allChannels) {
        this.allChannels = allChannels;
    }

    public enum OfferSort implements Sort {

        /**
         * (DEFAULT) Sort by product sku and then by total price, premium information, shop grade
         */
        BEST_PRICE("bestPrice"),
        /**
         * Sort by product sku and then by shop grade, total price, premium information
         */
        BEST_EVALUATION("bestEvaluation");

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

        AbstractMiraklGetOffersOnProductsRequest that = (AbstractMiraklGetOffersOnProductsRequest) o;

        if (productIds != null ? !productIds.equals(that.productIds) : that.productIds != null) {
            return false;
        }
        return offerStateCodes != null ? offerStateCodes.equals(that.offerStateCodes) : that.offerStateCodes == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (productIds != null ? productIds.hashCode() : 0);
        result = 31 * result + (offerStateCodes != null ? offerStateCodes.hashCode() : 0);
        return result;
    }
}
