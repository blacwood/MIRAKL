/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.order.document;

import com.mirakl.client.domain.common.Unicity;

@Unicity(props = {"fileName", "typeCode"})
public class MiraklOrderDocumentUpload {

    private String fileName;
    private String typeCode;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

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

        MiraklOrderDocumentUpload that = (MiraklOrderDocumentUpload) o;

        if (fileName != null ? !fileName.equals(that.fileName) : that.fileName != null) {
            return false;
        }
        return typeCode != null ? typeCode.equals(that.typeCode) : that.typeCode == null;

    }

    @Override
    public int hashCode() {
        int result = fileName != null ? fileName.hashCode() : 0;
        result = 31 * result + (typeCode != null ? typeCode.hashCode() : 0);
        return result;
    }
}
