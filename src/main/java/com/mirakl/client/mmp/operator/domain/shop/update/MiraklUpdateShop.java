/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.operator.domain.shop.update;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.domain.shop.AbstractCommonMiraklShop;
import com.mirakl.client.mmp.domain.shop.MiraklPremiumState;
import com.mirakl.client.mmp.domain.shop.MiraklShopAddress;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

@Unicity(includeAll = true)
public class MiraklUpdateShop extends AbstractCommonMiraklShop {

    private Long shopId;

    private MiraklShopAddress address;

    private MiraklPremiumState premiumState;

    @JsonProperty("channel_codes")
    private List<String> channels;

    public MiraklShopAddress getAddress() {
        return address;
    }

    public void setAddress(MiraklShopAddress address) {
        this.address = address;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public MiraklPremiumState getPremiumState() {
        return premiumState;
    }

    public void setPremiumState(MiraklPremiumState premiumState) {
        this.premiumState = premiumState;
    }


    public List<String> getChannels() {
        return channels;
    }

    public void setChannels(List<String> channels) {
        this.channels = channels;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        MiraklUpdateShop that = (MiraklUpdateShop) o;

        if (shopId != null ? !shopId.equals(that.shopId) : that.shopId != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (premiumState != that.premiumState) return false;
        return !(channels != null ? !channels.equals(that.channels) : that.channels != null);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (shopId != null ? shopId.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (premiumState != null ? premiumState.hashCode() : 0);
        result = 31 * result + (channels != null ? channels.hashCode() : 0);
        return result;
    }
}
