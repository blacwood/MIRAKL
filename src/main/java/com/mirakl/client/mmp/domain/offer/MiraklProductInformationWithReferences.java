/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.offer;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.domain.product.MiraklProductInformation;
import com.mirakl.client.mmp.domain.product.offer.MiraklProductReference;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

@Unicity(props = "sku")
public class MiraklProductInformationWithReferences extends MiraklProductInformation {

    @JsonProperty("product_references")
    private List<MiraklProductReference> references;

    /**
     * Offer product references
     */
    public List<MiraklProductReference> getReferences() {
        return references;
    }

    public void setReferences(List<MiraklProductReference> references) {
        this.references = references;
    }

}
