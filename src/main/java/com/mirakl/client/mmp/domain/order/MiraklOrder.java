/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.order;

import com.mirakl.client.domain.common.Unicity;

import java.util.ArrayList;
import java.util.List;

@Unicity(props = "id")
public class MiraklOrder extends AbstractMiraklOrder {

    private String shopId;
    private String shopName;

    private boolean canEvaluate;
    private boolean canCancel;

    private Integer evaluationGrade;

    private MiraklOrderCustomer customer;

    private List<MiraklOrderLine> orderLines = new ArrayList<MiraklOrderLine>();

    private String imprintNumber;

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    /**
     * Indicate if the customer can evaluate this order
     */
    public boolean getCanEvaluate() {
        return canEvaluate;
    }

    public void setCanEvaluate(boolean canEvaluate) {
        this.canEvaluate = canEvaluate;
    }

    /**
     * Indicate if the order can be cancelled
     */
    public boolean getCanCancel() {
        return canCancel;
    }

    public void setCanCancel(boolean canCancel) {
        this.canCancel = canCancel;
    }

    public Integer getEvaluationGrade() {
        return evaluationGrade;
    }

    /**
     * Indicate if the order can be evaluated by the customer
     */
    public void setEvaluationGrade(Integer evaluationGrade) {
        this.evaluationGrade = evaluationGrade;
    }

    public MiraklOrderCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(MiraklOrderCustomer customer) {
        this.customer = customer;
    }

    public List<MiraklOrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<MiraklOrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public String getImprintNumber() {
        return imprintNumber;
    }

    public void setImprintNumber(String imprintNumber) {
        this.imprintNumber = imprintNumber;
    }
}
