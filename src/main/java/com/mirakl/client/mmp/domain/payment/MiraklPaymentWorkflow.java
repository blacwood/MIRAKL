/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.payment;

public enum MiraklPaymentWorkflow {
    /**
     * Represents a payment workflow where the payment is done just after the order has been (fully or partially) accepted by the shop.
     */
    PAY_ON_ACCEPTANCE,
    /**
     * Represents a payment workflow where the payment is done at the latest when the order is waiting for collection.
     */
    PAY_ON_DELIVERY

}
