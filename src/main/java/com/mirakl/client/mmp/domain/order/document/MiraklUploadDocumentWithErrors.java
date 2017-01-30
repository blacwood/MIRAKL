/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.order.document;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.domain.common.error.InputWithErrors;
import com.mirakl.client.mmp.request.common.document.MiraklUploadDocument;

@Unicity(includeAll = true)
public class MiraklUploadDocumentWithErrors extends InputWithErrors<MiraklUploadDocument> {

}

