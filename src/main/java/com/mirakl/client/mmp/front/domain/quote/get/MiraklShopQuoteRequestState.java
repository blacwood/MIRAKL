/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.front.domain.quote.get;

public enum MiraklShopQuoteRequestState {

    /**
     * Waiting to be scored by front
     * Unavailable to shop(s) at this point
     */
    STAGING,

    /**
     * FINAL STATE
     * front has invalidated the customer's paying information
     */
    STAGING_KO,

    /**
     * Initial state once the {@link MiraklQuoteRequest} is scored, stays here until shop replies
     */
    TO_PROCESS,

    /**
     * Second stage of the Quote Request for this shop: the shop has acknowledged and answered to this request, by
     * either writing a message or submitting a quote to the customer
     */
    IN_PROGRESS,

    /**
     * FINAL STATE
     * Once the Quote Request for this shop is inactive (no messages AND no currently valid quotes) for a period of time
     * set by operator.
     * Set to this state by batch
     */
    EXPIRED,

    /**
     * FINAL STATE
     * Customer has accepted one quote from this shop, every other quotes -from this shop- will be closed as a result
     */
    ACCEPTED
}
