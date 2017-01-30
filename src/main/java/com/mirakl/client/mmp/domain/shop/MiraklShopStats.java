/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.shop;

import com.mirakl.client.core.internal.mapper.BigDecimalRateDeserializer;
import com.mirakl.client.domain.common.Unicity;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import java.math.BigDecimal;

@Unicity(includeAll = true)
public class MiraklShopStats {

    /**
     * Total count of offers
     */
    private Long offersCount;

    /**
     * Total count of orders
     */
    private Long ordersCount;

    /**
     * Number of evaluations submited by customers on shop's orders
     */
    private Long evaluationsCount;

    /**
     * Accepted orders rate
     */
    @JsonDeserialize(using = BigDecimalRateDeserializer.class)
    private BigDecimal approvalRate;

    /**
     * Average time to accept or refuse an order (in seconds)
     */
    private Long approvalDelay;

    /**
     * Average time to answer to an order message (in seconds)
     */
    private Long orderMessagesResponseDelay;

    public Long getApprovalDelay() {
        return approvalDelay;
    }

    public void setApprovalDelay(Long approvalDelay) {
        this.approvalDelay = approvalDelay;
    }

    public BigDecimal getApprovalRate() {
        return approvalRate;
    }

    public void setApprovalRate(BigDecimal approvalRate) {
        this.approvalRate = approvalRate;
    }

    public Long getEvaluationsCount() {
        return evaluationsCount;
    }

    public void setEvaluationsCount(Long evaluationsCount) {
        this.evaluationsCount = evaluationsCount;
    }

    public Long getOffersCount() {
        return offersCount;
    }

    public void setOffersCount(Long offersCount) {
        this.offersCount = offersCount;
    }

    public Long getOrdersCount() {
        return ordersCount;
    }

    public void setOrdersCount(Long ordersCount) {
        this.ordersCount = ordersCount;
    }

    public Long getOrderMessagesResponseDelay() {
        return orderMessagesResponseDelay;
    }

    public void setOrderMessagesResponseDelay(Long orderMessagesResponseDelay) {
        this.orderMessagesResponseDelay = orderMessagesResponseDelay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklShopStats that = (MiraklShopStats) o;

        if (offersCount != null ? !offersCount.equals(that.offersCount) : that.offersCount != null) {
            return false;
        }
        if (ordersCount != null ? !ordersCount.equals(that.ordersCount) : that.ordersCount != null) {
            return false;
        }
        if (evaluationsCount != null ? !evaluationsCount.equals(that.evaluationsCount) : that.evaluationsCount != null) {
            return false;
        }
        if (approvalRate != null ? !approvalRate.equals(that.approvalRate) : that.approvalRate != null) {
            return false;
        }
        if (approvalDelay != null ? !approvalDelay.equals(that.approvalDelay) : that.approvalDelay != null) {
            return false;
        }
        return orderMessagesResponseDelay != null ? orderMessagesResponseDelay.equals(that.orderMessagesResponseDelay) : that.orderMessagesResponseDelay == null;

    }

    @Override
    public int hashCode() {
        int result = offersCount != null ? offersCount.hashCode() : 0;
        result = 31 * result + (ordersCount != null ? ordersCount.hashCode() : 0);
        result = 31 * result + (evaluationsCount != null ? evaluationsCount.hashCode() : 0);
        result = 31 * result + (approvalRate != null ? approvalRate.hashCode() : 0);
        result = 31 * result + (approvalDelay != null ? approvalDelay.hashCode() : 0);
        result = 31 * result + (orderMessagesResponseDelay != null ? orderMessagesResponseDelay.hashCode() : 0);
        return result;
    }
}
