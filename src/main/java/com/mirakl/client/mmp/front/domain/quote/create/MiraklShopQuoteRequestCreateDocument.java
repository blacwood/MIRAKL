/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.front.domain.quote.create;

import com.mirakl.client.domain.common.Unicity;
import org.codehaus.jackson.annotate.JsonProperty;

@Unicity(includeAll = true)
public class MiraklShopQuoteRequestCreateDocument {

    @JsonProperty("file_name")
    private String filename;

    public MiraklShopQuoteRequestCreateDocument() {
    }

    public MiraklShopQuoteRequestCreateDocument(String filename) {
        this.filename = filename;
    }

    /**
     * The filename of the document
     */
    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklShopQuoteRequestCreateDocument that = (MiraklShopQuoteRequestCreateDocument) o;

        return filename != null ? filename.equals(that.filename) : that.filename == null;

    }

    @Override
    public int hashCode() {
        return filename != null ? filename.hashCode() : 0;
    }
}
