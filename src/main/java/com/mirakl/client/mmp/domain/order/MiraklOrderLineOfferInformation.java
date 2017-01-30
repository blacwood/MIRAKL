/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.order;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.domain.product.MiraklProductInformation;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonUnwrapped;

import java.math.BigDecimal;

@Unicity(includeAll = true)
public class MiraklOrderLineOfferInformation {

    @JsonUnwrapped
    private MiraklProductInformation product;

    @JsonProperty("offer_id")
    private String id;

    @JsonProperty("offer_state_code")
    private String stateCode;

    @JsonProperty("offer_sku")
    private String sku;

    @JsonProperty("description")
    private String description;

    @JsonProperty("price_unit")
    private BigDecimal price;

    /**
     * Associated offer ID
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    /**
     * Associated offer SKU (aka. ShopSKU)
     */
    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    /**
     * Description of the line
     */
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Unit price for the offer associated with the line
     */
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public MiraklProductInformation getProduct() {
        return product;
    }

    public void setProduct(MiraklProductInformation product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklOrderLineOfferInformation that = (MiraklOrderLineOfferInformation) o;

        if (product != null ? !product.equals(that.product) : that.product != null) {
            return false;
        }
        if (id != null ? !id.equals(that.id) : that.id != null) {
            return false;
        }
        if (stateCode != null ? !stateCode.equals(that.stateCode) : that.stateCode != null) {
            return false;
        }
        if (sku != null ? !sku.equals(that.sku) : that.sku != null) {
            return false;
        }
        if (description != null ? !description.equals(that.description) : that.description != null) {
            return false;
        }
        return price != null ? price.equals(that.price) : that.price == null;

    }

    @Override
    public int hashCode() {
        int result = product != null ? product.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (stateCode != null ? stateCode.hashCode() : 0);
        result = 31 * result + (sku != null ? sku.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }
}
