/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.shop.document;

import com.mirakl.client.domain.common.Unicity;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.Date;

@Unicity(includeAll = true)
public class MiraklShopDocument {

    private Date dateUploaded;
    private String shopId;
    private String fileName;
    private String id;
    @JsonProperty("type")
    private String typeCode;

    /**
     * Document upload date
     */
    public Date getDateUploaded() {
        return dateUploaded;
    }

    public void setDateUploaded(Date dateUploaded) {
        this.dateUploaded = dateUploaded;
    }

    /**
     * Document shop ID
     */
    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    /**
     * Document filename
     */
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Document ID
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Document Type Code
     */
    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklShopDocument that = (MiraklShopDocument) o;

        if (dateUploaded != null ? !dateUploaded.equals(that.dateUploaded) : that.dateUploaded != null) {
            return false;
        }
        if (shopId != null ? !shopId.equals(that.shopId) : that.shopId != null) {
            return false;
        }
        if (fileName != null ? !fileName.equals(that.fileName) : that.fileName != null) {
            return false;
        }
        if (id != null ? !id.equals(that.id) : that.id != null) {
            return false;
        }
        return typeCode != null ? typeCode.equals(that.typeCode) : that.typeCode == null;

    }

    @Override
    public int hashCode() {
        int result = dateUploaded != null ? dateUploaded.hashCode() : 0;
        result = 31 * result + (shopId != null ? shopId.hashCode() : 0);
        result = 31 * result + (fileName != null ? fileName.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (typeCode != null ? typeCode.hashCode() : 0);
        return result;
    }
}
