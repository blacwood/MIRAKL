/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.common.synchro;

import com.mirakl.client.domain.common.Unicity;

@Unicity(props = "synchroId")
public abstract class AbstractMiraklSynchroTracking {

    private String synchroId;

    /**
     * Identifier of the import
     */
    public String getSynchroId() {
        return synchroId;
    }

    public void setSynchroId(String synchroId) {
        this.synchroId = synchroId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AbstractMiraklSynchroTracking that = (AbstractMiraklSynchroTracking) o;

        return synchroId != null ? synchroId.equals(that.synchroId) : that.synchroId == null;

    }

    @Override
    public int hashCode() {
        return synchroId != null ? synchroId.hashCode() : 0;
    }
}
