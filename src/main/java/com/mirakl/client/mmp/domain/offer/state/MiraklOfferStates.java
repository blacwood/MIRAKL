/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.offer.state;

import com.mirakl.client.domain.common.Unicity;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties("total_count")
@Unicity(includeAll = true)
public class MiraklOfferStates {

    private List<MiraklOfferState> offerStates;

    public List<MiraklOfferState> getOfferStates() {
        return offerStates;
    }

    public void setOfferStates(List<MiraklOfferState> offerStates) {
        this.offerStates = offerStates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklOfferStates that = (MiraklOfferStates) o;

        return offerStates != null ? offerStates.equals(that.offerStates) : that.offerStates == null;

    }

    @Override
    public int hashCode() {
        return offerStates != null ? offerStates.hashCode() : 0;
    }
}
