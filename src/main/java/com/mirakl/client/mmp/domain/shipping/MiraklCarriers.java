/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.shipping;

import com.mirakl.client.domain.common.Unicity;

import java.util.List;

@Unicity(includeAll = true)
public class MiraklCarriers {

    private List<MiraklCarrier> carriers;

    public List<MiraklCarrier> getCarriers() {
        return carriers;
    }

    public void setCarriers(List<MiraklCarrier> carriers) {
        this.carriers = carriers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklCarriers that = (MiraklCarriers) o;

        return carriers != null ? carriers.equals(that.carriers) : that.carriers == null;

    }

    @Override
    public int hashCode() {
        return carriers != null ? carriers.hashCode() : 0;
    }
}
