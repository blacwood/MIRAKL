/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.request.order.incident;

import com.mirakl.client.domain.common.Unicity;

@Unicity(includeAll = true)
public class MiraklIncidentReason {

    private String reasonCode;

    public MiraklIncidentReason(String reasonCode) {
        this.reasonCode = reasonCode;
    }

    public String getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklIncidentReason that = (MiraklIncidentReason) o;

        return reasonCode != null ? reasonCode.equals(that.reasonCode) : that.reasonCode == null;

    }

    @Override
    public int hashCode() {
        return reasonCode != null ? reasonCode.hashCode() : 0;
    }
}
