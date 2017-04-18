/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.front.request.order.cancelation;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.front.domain.order.cancelation.MiraklCreateCancelation;
import com.mirakl.client.mmp.request.order.cancelation.AbstractMiraklCreateCancelationsRequest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Unicity(includeAll = true)
public class MiraklCreateCancelationsRequest extends AbstractMiraklCreateCancelationsRequest {

    private List<MiraklCreateCancelation> cancelations = new ArrayList<MiraklCreateCancelation>();

    public MiraklCreateCancelationsRequest(List<MiraklCreateCancelation> refunds) {
        setCancelations(refunds);
    }

    /**
     * The list of cancelations to create
     */
    public List<MiraklCreateCancelation> getCancelations() {
        return Collections.unmodifiableList(cancelations);
    }

    public void setCancelations(List<MiraklCreateCancelation> cancelations) {
        checkRequiredArgument(cancelations, "cancelations");
        this.cancelations.addAll(cancelations);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        MiraklCreateCancelationsRequest that = (MiraklCreateCancelationsRequest) o;

        return cancelations != null ? cancelations.equals(that.cancelations) : that.cancelations == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (cancelations != null ? cancelations.hashCode() : 0);
        return result;
    }
}
