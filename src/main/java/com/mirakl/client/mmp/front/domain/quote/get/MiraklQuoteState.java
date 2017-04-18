/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.front.domain.quote.get;

public enum MiraklQuoteState {
    /**
     * Original quote from user, never used
     */
    INITIAL,

    /**
     * Quote finalized by shop and pending acceptance from customer
     */
    ISSUED,

    /**
     * Quote accepted by the customer
     */
    ACCEPTED,

    /**
     * Quote has passed its validity period
     */
    EXPIRED
}
