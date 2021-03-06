/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.message;

import com.mirakl.client.domain.common.Unicity;

import java.util.List;

@Unicity(includeAll = true)
public class MiraklOfferMessages {

    private List<MiraklOfferMessage> messages;
    private long totalCount;

    public List<MiraklOfferMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<MiraklOfferMessage> messages) {
        this.messages = messages;
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

        MiraklOfferMessages that = (MiraklOfferMessages) o;

        if (totalCount != that.totalCount) {
            return false;
        }
        return messages != null ? messages.equals(that.messages) : that.messages == null;

    }

    @Override
    public int hashCode() {
        int result = messages != null ? messages.hashCode() : 0;
        result = 31 * result + (int) (totalCount ^ (totalCount >>> 32));
        return result;
    }
}
