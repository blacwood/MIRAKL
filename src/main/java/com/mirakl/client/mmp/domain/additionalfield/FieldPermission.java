/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.additionalfield;

/**
 * Describes the permissions applied to a target (shop user, for instance) on a given field
 */
public enum FieldPermission {
    /**
     * The target can neither see nor modify the field
     */
    INVISIBLE,

    /**
     * The target can only see the field value, not modify it
     */
    READ_ONLY,

    /**
     * The target can see the field value and affect a value to the field
     */
    READ_WRITE
}
