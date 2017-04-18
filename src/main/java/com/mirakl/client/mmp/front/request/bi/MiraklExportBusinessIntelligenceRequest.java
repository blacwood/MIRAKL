/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.front.request.bi;

import com.mirakl.client.core.internal.MiraklApiEndpoint;
import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.front.core.internal.MiraklFrontApiEndpoint;
import com.mirakl.client.mmp.front.domain.bi.MiraklBiExportFileType;
import com.mirakl.client.mmp.front.domain.bi.MiraklDataType;
import com.mirakl.client.request.AbstractMiraklApiRequest;

import java.util.Map;

@Unicity(includeAll = true)
public class MiraklExportBusinessIntelligenceRequest extends AbstractMiraklApiRequest {

    private MiraklDataType dataType;
    private MiraklBiExportFileType fileType;

    public MiraklExportBusinessIntelligenceRequest(MiraklDataType dataType, MiraklBiExportFileType fileType) {
        setDataType(dataType);
        setFileType(fileType);
    }

    @Override
    public MiraklApiEndpoint getEndpoint() {
        return MiraklFrontApiEndpoint.BI01;
    }

    @Override
    public Map<String, String> getQueryParams() {
        Map<String, String> result = super.getQueryParams();

        if (dataType != null) {
            result.put("data_type", dataType.name());
        }
        if (fileType != null) {
            result.put("file_type", fileType.name());
        }

        return result;
    }

    /**
     * The data type to be extracted. Currently, only ORDER_LINE is supported
     */
    public void setDataType(MiraklDataType dataType) {
        checkRequiredArgument(dataType, "dataType");
        this.dataType = dataType;
    }

    /**
     * The file type (which will be compressed as a ZIP file)
     */
    public void setFileType(MiraklBiExportFileType fileType) {
        checkRequiredArgument(fileType, "fileType");
        this.fileType = fileType;
    }

    /**
     * The data type to be extracted. Currently, only ORDER_LINE is supported
     */
    public MiraklDataType getDataType() {
        return dataType;
    }

    /**
     * The file type (which will be compressed as a ZIP file)
     */
    public MiraklBiExportFileType getFileType() {
        return fileType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklExportBusinessIntelligenceRequest that = (MiraklExportBusinessIntelligenceRequest) o;

        if (dataType != that.dataType) {
            return false;
        }
        return fileType == that.fileType;

    }

    @Override
    public int hashCode() {
        int result = dataType != null ? dataType.hashCode() : 0;
        result = 31 * result + (fileType != null ? fileType.hashCode() : 0);
        return result;
    }
}
