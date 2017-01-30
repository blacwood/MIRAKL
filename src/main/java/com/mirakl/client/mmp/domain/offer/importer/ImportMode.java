/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.offer.importer;

public enum ImportMode {

    /**
     * Update shop's offers : insert, update (if offer already exist) or delete offer
     */
    NORMAL,
    /**
     * Partial update shop's offers (only if field not empty)
     */
    PARTIAL_UPDATE,
    /**
     * Replace all shop's offers
     */
    REPLACE

}
