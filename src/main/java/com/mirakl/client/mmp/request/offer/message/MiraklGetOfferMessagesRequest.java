/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.request.offer.message;

import com.mirakl.client.domain.common.Unicity;

/**
 * @deprecated Please use {@code com.mirakl.client.mmp.shop.request.offer.message.MiraklGetOfferMessagesRequest} or
 * {@code com.mirakl.client.mmp.operator.request.offer.message.MiraklGetOfferMessagesRequest} instead.
 */
@Deprecated
@Unicity(includeAll = true)
public class MiraklGetOfferMessagesRequest extends AbstractMiraklGetOfferMessagesRequest {

    public MiraklGetOfferMessagesRequest(String offerId) {
        super(offerId);
    }

}
