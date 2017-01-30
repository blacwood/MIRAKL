/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.request.shop;

import com.mirakl.client.core.internal.MiraklApiEndpoint;
import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.core.internal.MiraklFrontOperatorApiEndpoint;
import com.mirakl.client.request.common.sort.AbstractMiraklSortRequest;
import com.mirakl.client.request.common.sort.OrderBy;
import com.mirakl.client.request.common.sort.Sort;

import java.util.Locale;
import java.util.Map;

@Unicity(includeAll = true)
public class MiraklGetShopEvaluationsRequest extends AbstractMiraklSortRequest<MiraklGetShopEvaluationsRequest.EvaluationSort> {

    private String shopId;

    private Locale locale;

    public MiraklGetShopEvaluationsRequest(String shopId) {
        setShopId(shopId);
    }

    @Override
    public MiraklApiEndpoint getEndpoint() {
        return MiraklFrontOperatorApiEndpoint.S03;
    }

    @Override
    public Map<String, String> getRequestTemplates() {
        Map<String, String> templates = super.getRequestTemplates();
        templates.put("shop", shopId);
        return templates;
    }

    @Override
    public Map<String, String> getQueryParams() {
        Map<String, String> params = super.getQueryParams();

        if (locale != null) {
            params.put("locale", locale.toString());
        }

        return params;
    }

    public String getShopId() {
        return shopId;
    }

    /**
     * Shop ID
     */
    public void setShopId(String shopId) {
        checkRequiredArgument(shopId, "shopId");
        this.shopId = shopId;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public static enum EvaluationSort implements Sort {

        /**
         * (DEFAULT) Sort by creation date
         */
        DATE("date"),
        /**
         * Sort by grade
         */
        GRADE("grade"),
        /**
         * Sort by customer firstname
         */
        FIRSTNAME("firstname"),
        /**
         * Sort by customer lastname
         */
        LASTNAME("lastname"),;

        private final String value;

        EvaluationSort(String value) {
            this.value = value;
        }

        @Override
        public String getValue() {
            return value;
        }

        public OrderBy<EvaluationSort> asc() {
            return new OrderBy<EvaluationSort>(this, OrderBy.Order.ASC);
        }

        public OrderBy<EvaluationSort> desc() {
            return new OrderBy<EvaluationSort>(this, OrderBy.Order.DESC);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        MiraklGetShopEvaluationsRequest that = (MiraklGetShopEvaluationsRequest) o;

        if (shopId != null ? !shopId.equals(that.shopId) : that.shopId != null) {
            return false;
        }
        return locale != null ? locale.equals(that.locale) : that.locale == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (shopId != null ? shopId.hashCode() : 0);
        result = 31 * result + (locale != null ? locale.hashCode() : 0);
        return result;
    }
}
