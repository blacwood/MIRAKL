/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.shop.create;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.domain.common.error.InputWithErrors;

/**
 * @deprecated Please use {@code com.mirakl.client.mmp.front.domain.shop.create.MiraklShopWithErrors} or {@code com.mirakl.client.mmp.operator.domain.shop.create.MiraklShopWithErrors} instead
 */
@Deprecated
@Unicity(includeAll = true)
public class MiraklShopWithErrors extends InputWithErrors<MiraklCreateShop> {
}
