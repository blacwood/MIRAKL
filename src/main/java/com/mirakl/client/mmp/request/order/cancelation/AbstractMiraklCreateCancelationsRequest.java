/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.request.order.cancelation;

import com.mirakl.client.core.internal.MiraklApiEndpoint;
import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.core.internal.MiraklFrontOperatorApiEndpoint;
import com.mirakl.client.request.AbstractMiraklApiRequest;

@Unicity(includeAll = true)
public abstract class AbstractMiraklCreateCancelationsRequest extends AbstractMiraklApiRequest {

    @Override
    public MiraklApiEndpoint getEndpoint() {
        return MiraklFrontOperatorApiEndpoint.OR30;
    }

}
