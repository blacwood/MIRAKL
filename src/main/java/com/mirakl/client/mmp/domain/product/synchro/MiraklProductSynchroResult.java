/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.product.synchro;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.domain.common.synchro.AbstractMiraklSynchroResult;

@Unicity(props = "synchroId")
public class MiraklProductSynchroResult extends AbstractMiraklSynchroResult {

    private Integer productInserted;
    private Integer productUpdated;
    private Integer productDeleted;

    public Integer getProductInserted() {
        return productInserted;
    }

    public void setProductInserted(Integer productInserted) {
        this.productInserted = productInserted;
    }

    public Integer getProductUpdated() {
        return productUpdated;
    }

    public void setProductUpdated(Integer productUpdated) {
        this.productUpdated = productUpdated;
    }

    public Integer getProductDeleted() {
        return productDeleted;
    }

    public void setProductDeleted(Integer productDeleted) {
        this.productDeleted = productDeleted;
    }
}
