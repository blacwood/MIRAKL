/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.operator.request.offer.importer;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.request.offer.importer.AbstractMiraklOfferImportReportRequest;

@Unicity(includeAll = true)
public class MiraklOfferImportReportRequest extends AbstractMiraklOfferImportReportRequest {

    public MiraklOfferImportReportRequest(String importId) {
        super(importId);
    }
}
