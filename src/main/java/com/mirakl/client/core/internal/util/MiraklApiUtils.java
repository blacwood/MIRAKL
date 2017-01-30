/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.core.internal.util;

import java.util.*;

public final class MiraklApiUtils {

    public static final String API_LIST_SEPARATOR = ",";
    public static final String API_MAP_SEPARATOR = "|";

    private MiraklApiUtils() {
        //should not be instantiated
    }

    public static String convertCollectionToStringParam(Collection params) {
        Preconditions.checkNotNull(params);
        StringBuilder sb = new StringBuilder();
        Iterator parts = params.iterator();
        if (parts.hasNext()) {
            sb.append(parts.next().toString());
            while (parts.hasNext()) {
                sb.append(API_LIST_SEPARATOR);
                sb.append(parts.next().toString());
            }
        }
        return sb.toString();
    }

    public static List<String> parseListFromStringParam(String value) {
        Preconditions.checkNotNull(value);

        String[] split = value.split(API_LIST_SEPARATOR);

        return Arrays.asList(split);
    }

    public static String convertMapToStringParam(Map<String, ?> params) {
        Preconditions.checkNotNull(params);

        List<String> flattenMap = new ArrayList<String>(params.size());

        for (Map.Entry<String, ?> entry : params.entrySet()) {
            String flatEntry = entry.getKey() + API_MAP_SEPARATOR + entry.getValue().toString();
            flattenMap.add(flatEntry);
        }

        return convertCollectionToStringParam(flattenMap);
    }

    public static void addBooleanOrAllParam(Map<String, String> params, Boolean param, String paramName){
        if (param != null) {
            params.put(paramName, String.valueOf(param).toUpperCase());
        } else {
            params.put(paramName, "ALL");
        }
    }

}
