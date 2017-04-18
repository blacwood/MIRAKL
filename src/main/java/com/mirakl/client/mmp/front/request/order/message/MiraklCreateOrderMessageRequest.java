/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.front.request.order.message;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.request.order.message.AbstractMiraklCreateOrderMessageRequest;
import com.mirakl.client.mmp.request.order.message.MiraklCreateOrderMessage;

@Unicity(includeAll = true)
public class MiraklCreateOrderMessageRequest extends AbstractMiraklCreateOrderMessageRequest {

    public MiraklCreateOrderMessageRequest(String orderId, MiraklCreateOrderMessage message) {
        super(orderId, message);
    }
    
}
