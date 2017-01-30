/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.order;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.domain.customer.AbstractMiraklCustomer;

@Unicity(props = "id")
public abstract class AbstractMiraklOrderCustomer extends AbstractMiraklCustomer {

    private MiraklCustomerBillingAddress billingAddress;

    public MiraklCustomerBillingAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(MiraklCustomerBillingAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

}
