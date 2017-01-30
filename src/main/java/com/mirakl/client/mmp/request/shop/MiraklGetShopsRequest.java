/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.request.shop;

import com.mirakl.client.core.internal.MiraklApiEndpoint;
import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.core.internal.MiraklFrontOperatorApiEndpoint;
import com.mirakl.client.mmp.domain.shop.MiraklShopState;
import com.mirakl.client.request.common.AbstractMiraklPaginationRequest;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

import static com.mirakl.client.core.internal.util.DateFormatter.formatDate;
import static com.mirakl.client.core.internal.util.MiraklApiUtils.addBooleanOrAllParam;
import static com.mirakl.client.core.internal.util.MiraklApiUtils.convertCollectionToStringParam;

@Unicity(includeAll = true)
public class MiraklGetShopsRequest extends AbstractMiraklPaginationRequest {

    private Collection<String> shopIds;
    private Boolean premium;
    private MiraklShopState state;
    private Date updatedSince;

    @Override
    public MiraklApiEndpoint getEndpoint() {
        return MiraklFrontOperatorApiEndpoint.S20;
    }

    @Override
    public Map<String, String> getQueryParams() {
        Map<String, String> result = super.getQueryParams();

        if (shopIds != null) {
            result.put("shop_ids", convertCollectionToStringParam(shopIds));
        }

        addBooleanOrAllParam(result, premium, "premium");

        if (state != null) {
            result.put("state", state.name());
        }
        if (updatedSince != null) {
            result.put("updated_since", formatDate(updatedSince));
        }

        return result;
    }


    /**
     * Filter the results by shop ids separated with comma
     * Limited to 100 values
     */
    public void setShopIds(Collection<String> shopIds) {
        this.shopIds = shopIds;
    }

    /**
     * Filter the results by shops premium state
     * If not set no filter will be applied
     */
    public void setPremium(Boolean premium) {
        this.premium = premium;
    }

    /**
     * Filter the results by shops state
     * If not set no filter will be applied
     */
    public void setState(MiraklShopState state) {
        this.state = state;
    }

    /**
     * Filter the results by shops who have been modified since the value of this parameter
     * Using this parameter will automatically switch the paginate filter to false
     */
    public void setUpdatedSince(Date updatedSince) {
        this.updatedSince = updatedSince;
    }

    public Collection<String> getShopIds() {
        return shopIds;
    }

    public Boolean getPremium() {
        return premium;
    }

    public MiraklShopState getState() {
        return state;
    }

    public Date getUpdatedSince() {
        return updatedSince;
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

        MiraklGetShopsRequest that = (MiraklGetShopsRequest) o;

        if (shopIds != null ? !shopIds.equals(that.shopIds) : that.shopIds != null) {
            return false;
        }
        if (premium != null ? !premium.equals(that.premium) : that.premium != null) {
            return false;
        }
        if (state != that.state) {
            return false;
        }
        return updatedSince != null ? updatedSince.equals(that.updatedSince) : that.updatedSince == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (shopIds != null ? shopIds.hashCode() : 0);
        result = 31 * result + (premium != null ? premium.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (updatedSince != null ? updatedSince.hashCode() : 0);
        return result;
    }
}
