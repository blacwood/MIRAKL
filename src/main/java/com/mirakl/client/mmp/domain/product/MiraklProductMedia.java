/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.product;

import com.mirakl.client.domain.common.Unicity;
import org.codehaus.jackson.annotate.JsonProperty;

@Unicity(props = "mediaUrl")
public class MiraklProductMedia {

    @JsonProperty("media_url")
    private String mediaUrl;

    private String type;

    @JsonProperty("mime_type")
    private String mimeType;

    /**
     * Url of the product media
     */
    public String getMediaUrl() {
        return mediaUrl;
    }

    /**
     * Type of the product media (small, large...)
     */
    public String getType() {
        return type;
    }

    /**
     * Mime of the product media (.jpg, .png ...)
     */
    public String getMimeType() {
        return mimeType;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }


    public void setType(String type) {
        this.type = type;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklProductMedia that = (MiraklProductMedia) o;

        return mediaUrl != null ? mediaUrl.equals(that.mediaUrl) : that.mediaUrl == null;

    }

    @Override
    public int hashCode() {
        return mediaUrl != null ? mediaUrl.hashCode() : 0;
    }
}
