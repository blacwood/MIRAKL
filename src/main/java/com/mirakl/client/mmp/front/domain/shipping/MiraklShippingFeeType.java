/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.front.domain.shipping;

import com.mirakl.client.mmp.domain.shipping.MiraklShippingTypeWithConfiguration;
import com.mirakl.client.domain.common.Unicity;
import java.math.BigDecimal;

/**
 * Shipping type information for the shipping fees
 */
@Unicity(props = "code")
public class MiraklShippingFeeType extends MiraklShippingTypeWithConfiguration {

    private BigDecimal totalShippingPrice;

    /**
     * Total shipping price of the shipping type for all selected offers
     */
    public BigDecimal getTotalShippingPrice() {
        return totalShippingPrice;
    }

    public void setTotalShippingPrice(BigDecimal totalShippingPrice) {
        this.totalShippingPrice = totalShippingPrice;
    }
}
