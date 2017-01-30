/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.product;

import com.mirakl.client.domain.common.Unicity;
import org.codehaus.jackson.annotate.JsonProperty;

@Unicity(props = "sku")
public abstract class AbstractMiraklProduct extends MiraklProductInformation {

    @JsonProperty("product_id")
    private String id;

    @JsonProperty("product_id_type")
    private String idType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

}
