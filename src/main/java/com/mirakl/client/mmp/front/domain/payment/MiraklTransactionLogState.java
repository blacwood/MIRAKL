/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.front.domain.payment;

/**
 * Different payment state available for shop balance.
 */
public enum MiraklTransactionLogState {

    /**
     * The order has been paid by the customer but no received
     * Ther order has been paid and received by the customer but has an ongoing incident
     */
    PENDING,

    /**
     * The order has been received by the customer and has no active incident.
     */
    PAYABLE,

    /**
     * The transaction log is currently being processed by the payment batch
     */
    PAYMENT_IN_PROGRESS,

    /**
     * The order has been paid to the shop
     */
    PAID

}
