/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.reason;

import com.mirakl.client.domain.common.Unicity;
import org.codehaus.jackson.annotate.JsonProperty;

@Unicity(props = "code")
public class MiraklReason {

    private String code;
    private String label;
    private MiraklReasonType type;
    @JsonProperty("is_customer_right")
    private boolean customerRight;
    @JsonProperty("is_operator_right")
    private boolean operatorRight;
    @JsonProperty("is_shop_right")
    private boolean shopRight;

    /**
     * Reason code
     */
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Reason label
     */
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * Reason type
     */
    public MiraklReasonType getType() {
        return type;
    }

    public void setType(MiraklReasonType type) {
        this.type = type;
    }

    /**
     * Does the customer can use this reason?
     */
    public boolean isCustomerRight() {
        return customerRight;
    }

    public void setCustomerRight(boolean customerRight) {
        this.customerRight = customerRight;
    }

    /**
     * Does the operator can use this reason?
     */
    public boolean isOperatorRight() {
        return operatorRight;
    }

    public void setOperatorRight(boolean operatorRight) {
        this.operatorRight = operatorRight;
    }

    /**
     * Does the shop can use this reason?
     */
    public boolean isShopRight() {
        return shopRight;
    }

    public void setShopRight(boolean shopRight) {
        this.shopRight = shopRight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklReason that = (MiraklReason) o;

        return code != null ? code.equals(that.code) : that.code == null;

    }

    @Override
    public int hashCode() {
        return code != null ? code.hashCode() : 0;
    }
}

