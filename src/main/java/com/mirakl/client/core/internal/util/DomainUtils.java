/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.core.internal.util;

import java.util.Collections;
import java.util.List;

public final class DomainUtils {

    private DomainUtils() {
    }

    public static <T> List<T> unmodifiableList(List<? extends T> list) {
        return list == null ? null : Collections.unmodifiableList(list);
    }
}
