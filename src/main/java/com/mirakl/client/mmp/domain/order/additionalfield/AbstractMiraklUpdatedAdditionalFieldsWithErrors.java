/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.order.additionalfield;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.domain.common.error.InputWithErrors;

@Unicity(includeAll = true)
public abstract class AbstractMiraklUpdatedAdditionalFieldsWithErrors<UPDATE_AF extends AbstractMiraklUpdateAdditionalFields> extends InputWithErrors<UPDATE_AF> {
}
