/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.reason;

import com.mirakl.client.domain.common.Unicity;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties("total_count")
@Unicity(includeAll = true)
public class MiraklReasons {

    private List<MiraklReason> reasons;

    public List<MiraklReason> getReasons() {
        return reasons;
    }

    public void setReasons(List<MiraklReason> reasons) {
        this.reasons = reasons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklReasons that = (MiraklReasons) o;

        return reasons != null ? reasons.equals(that.reasons) : that.reasons == null;

    }

    @Override
    public int hashCode() {
        return reasons != null ? reasons.hashCode() : 0;
    }
}
