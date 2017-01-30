/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.shop;

/**
 * Determination mode of the premium state of a shop
 */
public enum MiraklPremiumState {

    /**
     * The premium state of the shop will be automatically determined from the stats (KPI) of the shop
     * Shipping delay, incident rate, refund rate...
     */
    DEFAULT,

    /**
     * The shop will always be premium (its KPIs won't have any effect)
     */
    PREMIUM,

    /**
     * The shop will always be NOT premium (its KPIs won't have any effect)
     */
    NOT_PREMIUM

}
