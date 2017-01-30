/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.product;

import com.mirakl.client.domain.common.Unicity;

import java.util.List;

@Unicity(props = "sku")
public class MiraklProduct extends AbstractMiraklProduct {

    private List<String> authorizedShopIds;

    public List<String> getAuthorizedShopIds() {
        return authorizedShopIds;
    }

    public void setAuthorizedShopIds(List<String> authorizedShopIds) {
        this.authorizedShopIds = authorizedShopIds;
    }
}
