/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.reason;

public enum MiraklReasonType {

    INCIDENT_OPEN,

    INCIDENT_CLOSE,

    REFUND,

    @Deprecated
    MESSAGING,

    ORDER_MESSAGING,

    OFFER_MESSAGING,

    CANCELATION,

    CANCELED,

    REFUSED,
}
