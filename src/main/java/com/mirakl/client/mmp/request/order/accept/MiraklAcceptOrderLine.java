/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.request.order.accept;

import com.mirakl.client.domain.common.Unicity;

@Unicity(includeAll = true)
public class MiraklAcceptOrderLine {

    private String id;
    private boolean accepted;

    public MiraklAcceptOrderLine(String id, boolean accepted) {
        this.id = id;
        this.accepted = accepted;
    }

    public String getId() {
        return id;
    }

    /**
     * Order line ID
     */
    public void setId(String id) {
        this.id = id;
    }

    public boolean isAccepted() {
        return accepted;
    }

    /**
     * Is the order line accepted or refused?
     */
    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklAcceptOrderLine that = (MiraklAcceptOrderLine) o;

        if (accepted != that.accepted) {
            return false;
        }
        return id != null ? id.equals(that.id) : that.id == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (accepted ? 1 : 0);
        return result;
    }
}
