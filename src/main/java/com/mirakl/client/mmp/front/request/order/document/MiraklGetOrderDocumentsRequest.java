/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.front.request.order.document;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.request.order.document.AbstractMiraklGetOrderDocumentsRequest;

import java.util.Collection;

@Unicity(includeAll = true)
public class MiraklGetOrderDocumentsRequest extends AbstractMiraklGetOrderDocumentsRequest {

    public MiraklGetOrderDocumentsRequest(Collection<String> orderIds) {
        super(orderIds);
    }

}
