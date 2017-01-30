/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.offer;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.domain.common.MiraklAdditionalFieldValue;
import com.mirakl.client.mmp.domain.common.MiraklDiscount;
import org.codehaus.jackson.annotate.JsonProperty;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Unicity(includeAll = true)
public class MiraklUpdateOffer {

    private String productId;
    private String productIdType;
    @JsonProperty("shop_sku")
    private String sku;

    private String stateCode;
    private String description;
    private String internalDescription;

    private BigDecimal price;
    private String priceAdditionalInfo;
    private MiraklDiscount discount;

    private Integer quantity;
    private Integer minQuantityAlert;

    private Date availableStarted;
    private Date availableEnded;
    private String updateDelete;

    private String logisticClass;

    private Integer leadtimeToShip;

    @JsonProperty("offer_additional_fields")
    private List<MiraklAdditionalFieldValue> additionalFields;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductIdType() {
        return productIdType;
    }

    public void setProductIdType(String productIdType) {
        this.productIdType = productIdType;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInternalDescription() {
        return internalDescription;
    }

    public void setInternalDescription(String internalDescription) {
        this.internalDescription = internalDescription;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getPriceAdditionalInfo() {
        return priceAdditionalInfo;
    }

    public void setPriceAdditionalInfo(String priceAdditionalInfo) {
        this.priceAdditionalInfo = priceAdditionalInfo;
    }

    public MiraklDiscount getDiscount() {
        return discount;
    }

    public void setDiscount(MiraklDiscount discount) {
        this.discount = discount;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getMinQuantityAlert() {
        return minQuantityAlert;
    }

    public void setMinQuantityAlert(Integer minQuantityAlert) {
        this.minQuantityAlert = minQuantityAlert;
    }

    public Date getAvailableStarted() {
        return availableStarted;
    }

    public void setAvailableStarted(Date availableStarted) {
        this.availableStarted = availableStarted;
    }

    public Date getAvailableEnded() {
        return availableEnded;
    }

    public void setAvailableEnded(Date availableEnded) {
        this.availableEnded = availableEnded;
    }

    public String getUpdateDelete() {
        return updateDelete;
    }

    public void setUpdateDelete(String updateDelete) {
        this.updateDelete = updateDelete;
    }

    public String getLogisticClass() {
        return logisticClass;
    }

    public void setLogisticClass(String logisticClass) {
        this.logisticClass = logisticClass;
    }

    public List<MiraklAdditionalFieldValue> getAdditionalFields() {
        return additionalFields == null ? null : Collections.unmodifiableList(additionalFields);
    }

    public void setAdditionalFields(List<MiraklAdditionalFieldValue> additionalFields) {
        this.additionalFields = additionalFields;
    }

    public Integer getLeadtimeToShip() {
        return leadtimeToShip;
    }

    public void setLeadtimeToShip(Integer leadtimeToShip) {
        this.leadtimeToShip = leadtimeToShip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklUpdateOffer that = (MiraklUpdateOffer) o;

        if (productId != null ? !productId.equals(that.productId) : that.productId != null) {
            return false;
        }
        if (productIdType != null ? !productIdType.equals(that.productIdType) : that.productIdType != null) {
            return false;
        }
        if (sku != null ? !sku.equals(that.sku) : that.sku != null) {
            return false;
        }
        if (stateCode != null ? !stateCode.equals(that.stateCode) : that.stateCode != null) {
            return false;
        }
        if (description != null ? !description.equals(that.description) : that.description != null) {
            return false;
        }
        if (internalDescription != null ? !internalDescription.equals(that.internalDescription) : that.internalDescription != null) {
            return false;
        }
        if (price != null ? !price.equals(that.price) : that.price != null) {
            return false;
        }
        if (priceAdditionalInfo != null ? !priceAdditionalInfo.equals(that.priceAdditionalInfo) : that.priceAdditionalInfo != null) {
            return false;
        }
        if (discount != null ? !discount.equals(that.discount) : that.discount != null) {
            return false;
        }
        if (quantity != null ? !quantity.equals(that.quantity) : that.quantity != null) {
            return false;
        }
        if (minQuantityAlert != null ? !minQuantityAlert.equals(that.minQuantityAlert) : that.minQuantityAlert != null) {
            return false;
        }
        if (availableStarted != null ? !availableStarted.equals(that.availableStarted) : that.availableStarted != null) {
            return false;
        }
        if (availableEnded != null ? !availableEnded.equals(that.availableEnded) : that.availableEnded != null) {
            return false;
        }
        if (updateDelete != null ? !updateDelete.equals(that.updateDelete) : that.updateDelete != null) {
            return false;
        }
        if (logisticClass != null ? !logisticClass.equals(that.logisticClass) : that.logisticClass != null) {
            return false;
        }
        if (leadtimeToShip != null ? !leadtimeToShip.equals(that.leadtimeToShip) : that.leadtimeToShip != null) {
            return false;
        }
        return additionalFields != null ? additionalFields.equals(that.additionalFields) : that.additionalFields == null;

    }

    @Override
    public int hashCode() {
        int result = productId != null ? productId.hashCode() : 0;
        result = 31 * result + (productIdType != null ? productIdType.hashCode() : 0);
        result = 31 * result + (sku != null ? sku.hashCode() : 0);
        result = 31 * result + (stateCode != null ? stateCode.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (internalDescription != null ? internalDescription.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (priceAdditionalInfo != null ? priceAdditionalInfo.hashCode() : 0);
        result = 31 * result + (discount != null ? discount.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (minQuantityAlert != null ? minQuantityAlert.hashCode() : 0);
        result = 31 * result + (availableStarted != null ? availableStarted.hashCode() : 0);
        result = 31 * result + (availableEnded != null ? availableEnded.hashCode() : 0);
        result = 31 * result + (updateDelete != null ? updateDelete.hashCode() : 0);
        result = 31 * result + (logisticClass != null ? logisticClass.hashCode() : 0);
        result = 31 * result + (leadtimeToShip != null ? leadtimeToShip.hashCode() : 0);
        result = 31 * result + (additionalFields != null ? additionalFields.hashCode() : 0);
        return result;
    }
}
