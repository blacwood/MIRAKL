/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.shop;

import com.mirakl.client.domain.common.Unicity;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.Set;

@Unicity(includeAll = true)
public class MiraklShippingInformation {

    /**
     * Indicate whether the shop is offering the shippings for all the customers on all his inventory
     */
    private Boolean freeShipping;

    /**
     * Code ISO 3166-1 alpha-3 of the shop's products shipping country
     */
    private String shippingCountry;

    /**
     * All the pair shipping zone / shipping type accepted by the shop
     */
    @JsonProperty("shippings")
    private Set<MiraklShippingRule> shippingRules;

    public Boolean getFreeShipping() {
        return freeShipping;
    }

    public void setFreeShipping(Boolean freeShipping) {
        this.freeShipping = freeShipping;
    }

    public String getShippingCountry() {
        return shippingCountry;
    }

    public void setShippingCountry(String shippingCountry) {
        this.shippingCountry = shippingCountry;
    }

    public Set<MiraklShippingRule> getShippingRules() {
        return shippingRules;
    }

    public void setShippingRules(Set<MiraklShippingRule> shippingRules) {
        this.shippingRules = shippingRules;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklShippingInformation that = (MiraklShippingInformation) o;

        if (freeShipping != null ? !freeShipping.equals(that.freeShipping) : that.freeShipping != null) {
            return false;
        }
        if (shippingCountry != null ? !shippingCountry.equals(that.shippingCountry) : that.shippingCountry != null) {
            return false;
        }
        return shippingRules != null ? shippingRules.equals(that.shippingRules) : that.shippingRules == null;

    }

    @Override
    public int hashCode() {
        int result = freeShipping != null ? freeShipping.hashCode() : 0;
        result = 31 * result + (shippingCountry != null ? shippingCountry.hashCode() : 0);
        result = 31 * result + (shippingRules != null ? shippingRules.hashCode() : 0);
        return result;
    }
}
