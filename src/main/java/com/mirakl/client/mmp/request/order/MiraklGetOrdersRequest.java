/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.request.order;

import com.mirakl.client.domain.common.Unicity;
import java.util.Collection;
import java.util.Map;

import static com.mirakl.client.core.internal.util.MiraklApiUtils.convertCollectionToStringParam;

@Unicity(includeAll = true)
public class MiraklGetOrdersRequest extends AbstractMiraklGetOrdersRequest {

    private Collection<String> commercialIds;
    private Collection<String> customerIds;
    private Collection<String> offerIds;
    private Collection<String> productSkus;
    private Collection<String> shopIds;

    public Collection<String> getCommercialIds() {
        return commercialIds;
    }

    /**
     * Filter by commercial IDs
     */
    public void setCommercialIds(Collection<String> commercialIds) {
        this.commercialIds = commercialIds;
    }

    public Collection<String> getCustomerIds() {
        return customerIds;
    }

    /**
     * Filter by customer IDs
     */
    public void setCustomerIds(Collection<String> customerIds) {
        this.customerIds = customerIds;
    }

    public Collection<String> getOfferIds() {
        return offerIds;
    }

    /**
     * Filter by offer IDs
     */
    public void setOfferIds(Collection<String> offerIds) {
        this.offerIds = offerIds;
    }

    public Collection<String> getProductSkus() {
        return productSkus;
    }

    /**
     * Filter by product SKUs
     */
    public void setProductSkus(Collection<String> productSkus) {
        this.productSkus = productSkus;
    }

    public Collection<String> getShopIds() {
        return shopIds;
    }

    /**
     * Filter by shop IDs
     */
    public void setShopIds(Collection<String> shopIds) {
        this.shopIds = shopIds;
    }

    @Override
    public Map<String, String> getQueryParams() {
        Map<String, String> result = super.getQueryParams();

        if (commercialIds != null) {
            result.put("commercial_ids", convertCollectionToStringParam(commercialIds));
        }
        if (customerIds != null) {
            result.put("customer_ids", convertCollectionToStringParam(customerIds));
        }
        if (offerIds != null) {
            result.put("offer_ids", convertCollectionToStringParam(offerIds));
        }
        if (productSkus != null) {
            result.put("product_skus", convertCollectionToStringParam(productSkus));
        }
        if (shopIds != null) {
            result.put("shop_ids", convertCollectionToStringParam(shopIds));
        }

        return result;
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

        MiraklGetOrdersRequest that = (MiraklGetOrdersRequest) o;

        if (commercialIds != null ? !commercialIds.equals(that.commercialIds) : that.commercialIds != null) {
            return false;
        }
        if (customerIds != null ? !customerIds.equals(that.customerIds) : that.customerIds != null) {
            return false;
        }
        if (offerIds != null ? !offerIds.equals(that.offerIds) : that.offerIds != null) {
            return false;
        }
        if (productSkus != null ? !productSkus.equals(that.productSkus) : that.productSkus != null) {
            return false;
        }
        if (shopIds != null ? !shopIds.equals(that.shopIds) : that.shopIds != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (commercialIds != null ? commercialIds.hashCode() : 0);
        result = 31 * result + (customerIds != null ? customerIds.hashCode() : 0);
        result = 31 * result + (offerIds != null ? offerIds.hashCode() : 0);
        result = 31 * result + (productSkus != null ? productSkus.hashCode() : 0);
        result = 31 * result + (shopIds != null ? shopIds.hashCode() : 0);
        return result;
    }
}
