/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.front.domain.payment;

import com.mirakl.client.domain.common.Unicity;

import java.util.List;

@Unicity(includeAll = true)
public class MiraklTransactionLogs {

    private List<MiraklTransactionLog> lines;
    private long totalCount;

    public List<MiraklTransactionLog> getLines() {
        return lines;
    }

    public void setLines(List<MiraklTransactionLog> lines) {
        this.lines = lines;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklTransactionLogs that = (MiraklTransactionLogs) o;

        if (totalCount != that.totalCount) {
            return false;
        }
        return lines != null ? lines.equals(that.lines) : that.lines == null;

    }

    @Override
    public int hashCode() {
        int result = lines != null ? lines.hashCode() : 0;
        result = 31 * result + (int) (totalCount ^ (totalCount >>> 32));
        return result;
    }
}
