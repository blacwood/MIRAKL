/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.core.internal.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateFormatter {

    /** ISO 8601 - Time Zone GMT */
    public static final String API_DATE_PATTERN_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

//    XXX is not supported in Java 6
//    public static final String API_DATE_PATTERN_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";

    private DateFormatter() {
        //should not be instantiated
    }

    public static String formatDate(Date date) {
        Preconditions.checkNotNull(date);
        SimpleDateFormat dateFormat = new SimpleDateFormat(API_DATE_PATTERN_FORMAT);
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return dateFormat.format(date);
    }

}
