/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.category.synchro;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.domain.common.synchro.AbstractMiraklSynchroResult;

@Unicity(props = "synchroId")
public class MiraklCategorySynchroResult extends AbstractMiraklSynchroResult {

    private Integer categoryInserted;
    private Integer categoryUpdated;
    private Integer categoryDeleted;

    /**
     * Total count of created categories
     */
    public Integer getCategoryInserted() {
        return categoryInserted;
    }

    /**
     * Total count of updtaed categories
     */
    public Integer getCategoryUpdated() {
        return categoryUpdated;
    }

    /**
     * Total count of deleted categories
     */
    public Integer getCategoryDeleted() {
        return categoryDeleted;
    }

    public void setCategoryInserted(Integer categoryInserted) {
        this.categoryInserted = categoryInserted;
    }

    public void setCategoryUpdated(Integer categoryUpdated) {
        this.categoryUpdated = categoryUpdated;
    }

    public void setCategoryDeleted(Integer categoryDeleted) {
        this.categoryDeleted = categoryDeleted;
    }
}
