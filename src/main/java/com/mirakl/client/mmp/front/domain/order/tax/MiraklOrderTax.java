/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.front.domain.order.tax;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.domain.order.tax.AbstractMiraklOrderTax;

@Unicity(props = "code")
public class MiraklOrderTax extends AbstractMiraklOrderTax{

    private boolean active;

    /**
     * Whether or not the tax is active on the plateform
     */
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
