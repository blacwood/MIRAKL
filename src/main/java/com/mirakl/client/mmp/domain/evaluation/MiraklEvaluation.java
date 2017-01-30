/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.evaluation;

import com.mirakl.client.domain.common.Unicity;

@Unicity(includeAll = true)
public class MiraklEvaluation extends AbstractMiraklEvaluation {

    private boolean visible = true;

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        MiraklEvaluation that = (MiraklEvaluation) o;

        return visible == that.visible;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (visible ? 1 : 0);
        return result;
    }
}
