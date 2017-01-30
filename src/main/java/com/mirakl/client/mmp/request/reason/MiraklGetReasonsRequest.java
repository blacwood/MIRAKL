/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.request.reason;

import com.mirakl.client.core.internal.MiraklApiEndpoint;
import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.core.internal.MiraklFrontOperatorApiEndpoint;
import com.mirakl.client.request.AbstractMiraklApiRequest;

import java.util.Locale;
import java.util.Map;

@Unicity(includeAll = true)
public class MiraklGetReasonsRequest extends AbstractMiraklApiRequest {

    private Locale locale;

    @Override
    public MiraklApiEndpoint getEndpoint() {
        return MiraklFrontOperatorApiEndpoint.RE01;
    }

    public MiraklGetReasonsRequest() {
    }

    public MiraklGetReasonsRequest(Locale locale) {
        this.locale = locale;
    }

    @Override
    public Map<String, String> getQueryParams() {
        Map<String, String> params = super.getQueryParams();

        if (locale != null) {
            params.put("locale", locale.toString());
        }

        return params;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklGetReasonsRequest that = (MiraklGetReasonsRequest) o;

        return locale != null ? locale.equals(that.locale) : that.locale == null;

    }

    @Override
    public int hashCode() {
        return locale != null ? locale.hashCode() : 0;
    }
}
