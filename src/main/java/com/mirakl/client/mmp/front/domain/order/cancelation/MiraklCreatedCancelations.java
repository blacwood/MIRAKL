/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.front.domain.order.cancelation;

import com.mirakl.client.domain.common.Unicity;

import java.util.List;

/**
 * This is an internal class. Please do not use.
 */
@Unicity(includeAll = true)
public class MiraklCreatedCancelations {

    private List<MiraklCancelationCreated> cancelations;

    public List<MiraklCancelationCreated> getCancelations() {
        return cancelations;
    }

    public void setCancelations(List<MiraklCancelationCreated> cancelations) {
        this.cancelations = cancelations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklCreatedCancelations that = (MiraklCreatedCancelations) o;

        return cancelations != null ? cancelations.equals(that.cancelations) : that.cancelations == null;

    }

    @Override
    public int hashCode() {
        return cancelations != null ? cancelations.hashCode() : 0;
    }
}
