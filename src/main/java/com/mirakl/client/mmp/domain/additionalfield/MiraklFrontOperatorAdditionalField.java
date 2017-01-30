/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.additionalfield;

public class MiraklFrontOperatorAdditionalField extends AbstractMiraklAdditionalField {

    /**
     * Describes the access level of shops on this Additional Field
     */
    private FieldPermission shopPermission;

    public FieldPermission getShopPermission() {
        return shopPermission;
    }

    public void setShopPermission(FieldPermission shopPermission) {
        this.shopPermission = shopPermission;
    }
}
