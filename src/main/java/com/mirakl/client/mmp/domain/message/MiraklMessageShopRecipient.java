/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.message;

import com.mirakl.client.domain.common.Unicity;
import org.codehaus.jackson.annotate.JsonProperty;

@Unicity(props = "id")
public class MiraklMessageShopRecipient extends AbstractMiraklMessageUserRecipient {

    /**
     * Shop ID if the message has been sent to a shop
     */
    @JsonProperty("toShopId")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Shop name if the message has been sent to a shop
     */
    @JsonProperty("toShopName")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
