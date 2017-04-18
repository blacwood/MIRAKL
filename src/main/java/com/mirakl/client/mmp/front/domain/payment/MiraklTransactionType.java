/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.front.domain.payment;

/**
 * Type of transactions in the transaction logs
 */
public enum MiraklTransactionType {

    MANUAL_CREDIT,
    MANUAL_CREDIT_VAT,
    MANUAL_INVOICE,
    MANUAL_INVOICE_VAT,

    ORDER_AMOUNT,
    ORDER_AMOUNT_TAX,
    ORDER_SHIPPING_AMOUNT,
    ORDER_SHIPPING_AMOUNT_TAX,
    COMMISSION_FEE,
    COMMISSION_VAT,

    REFUND_ORDER_AMOUNT,
    REFUND_ORDER_AMOUNT_TAX,
    REFUND_ORDER_SHIPPING_AMOUNT,
    REFUND_ORDER_SHIPPING_AMOUNT_TAX,
    REFUND_COMMISSION_FEE,
    REFUND_COMMISSION_VAT,

    SUBSCRIPTION_FEE,
    SUBSCRIPTION_VAT,

    PAYMENT

}
