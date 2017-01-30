/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.order;

import com.mirakl.client.domain.common.Unicity;

@Unicity(props = "id")
public class MiraklOrderLine extends MiraklShopOrderLine {

    private boolean canOpenIncident;

    /**
     * Indicate if an incident can be openned on the order line
     */
    public boolean getCanOpenIncident() {
        return canOpenIncident;
    }

    public void setCanOpenIncident(boolean canOpenIncident) {
        this.canOpenIncident = canOpenIncident;
    }

}
