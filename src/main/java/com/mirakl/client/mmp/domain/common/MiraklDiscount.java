/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.common;

import com.mirakl.client.domain.common.Unicity;

import java.math.BigDecimal;
import java.util.*;

/**
 * Representation of a discount
 */
@Unicity(includeAll = true)
public class MiraklDiscount {

    private BigDecimal discountPrice;
    private BigDecimal originPrice;
    private Date startDate;
    private Date endDate;
    private List<MiraklDiscountRange> ranges = new ArrayList<MiraklDiscountRange>();

    public MiraklDiscount() {
    }

    public MiraklDiscount(BigDecimal originPrice, Date startDate, Date endDate) {
        this.originPrice = originPrice;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public MiraklDiscount(BigDecimal discountPrice, BigDecimal originPrice, Date startDate, Date endDate) {
        this(originPrice, startDate, endDate);
        this.discountPrice = discountPrice;
    }

    /**
     * The discount price of the offer
     */
    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(BigDecimal discountPrice) {
        this.discountPrice = discountPrice;
    }

    /**
     * The original price of the offer if it is currently in a discount period
     */
    public BigDecimal getOriginPrice() {
        return originPrice;
    }

    public void setOriginPrice(BigDecimal originPrice) {
        this.originPrice = originPrice;
    }

    /**
     * The start date of the discount period
     */
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * The end date of the discount period
     */
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * The discount ranges that define the discount
     */
    public List<MiraklDiscountRange> getRanges() {
        return Collections.unmodifiableList(ranges);
    }

    public boolean addRange(MiraklDiscountRange discountRange) {
        return ranges.add(discountRange);
    }

    public void addAllRanges(Collection<? extends MiraklDiscountRange> discountRanges) {
        this.ranges.addAll(discountRanges);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklDiscount that = (MiraklDiscount) o;

        if (discountPrice != null ? !discountPrice.equals(that.discountPrice) : that.discountPrice != null) {
            return false;
        }
        if (originPrice != null ? !originPrice.equals(that.originPrice) : that.originPrice != null) {
            return false;
        }
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) {
            return false;
        }
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) {
            return false;
        }
        return ranges != null ? ranges.equals(that.ranges) : that.ranges == null;

    }

    @Override
    public int hashCode() {
        int result = discountPrice != null ? discountPrice.hashCode() : 0;
        result = 31 * result + (originPrice != null ? originPrice.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (ranges != null ? ranges.hashCode() : 0);
        return result;
    }
}
