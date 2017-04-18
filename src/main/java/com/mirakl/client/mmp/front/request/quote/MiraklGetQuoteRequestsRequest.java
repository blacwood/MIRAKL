/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.front.request.quote;

import com.mirakl.client.core.internal.MiraklApiEndpoint;
import com.mirakl.client.mmp.front.core.internal.MiraklFrontApiEndpoint;
import com.mirakl.client.request.AbstractMiraklApiRequest;

import java.util.*;

import static com.mirakl.client.core.internal.util.MiraklApiUtils.convertCollectionToStringParam;
import static java.util.Collections.*;

public class MiraklGetQuoteRequestsRequest extends AbstractMiraklApiRequest {

    private List<String> customerIds = new ArrayList<String>();
    private List<String> shopIds = new ArrayList<String>();
    private List<String> states = new ArrayList<String>();
    private String shopQuoteRequestId;

    /**
     * Filter by customer ids
     */
    public boolean addAllCustomerIds(List<String> customerIds) {
        return this.customerIds.addAll(customerIds);
    }

    public boolean addCustomerId(String customerId) {
        return this.customerIds.add(customerId);
    }

    public List<String> getCustomerIds() {
        return unmodifiableList(customerIds);
    }

    /**
     * Filter by shop ids
     */
    public boolean addAllShopIds(List<String> shopIds) {
        return this.shopIds.addAll(shopIds);
    }

    public boolean addShopIds(String shopId) {
        return this.shopIds.add(shopId);
    }

    public List<String> getShopIds() {
        return unmodifiableList(shopIds);
    }

    /**
     * Filter by quote request statuses
     */
    public boolean addAllStates(List<String> states) {
        return this.states.addAll(states);
    }

    public boolean addState(String state) {
        return this.states.add(state);
    }

    public List<String> getStates() {
        return unmodifiableList(states);
    }

    /**
     * The id of the shop quote request to filter on.
     * Note that the entire quote request will be returned: all the shop quote requests of the matching quote request will be returned, not only the shop quote request with the given id.
     */
    public void setShopQuoteRequestId(String shopQuoteRequestId) {
        this.shopQuoteRequestId = shopQuoteRequestId;
    }

    public String getShopQuoteRequestId() {
        return shopQuoteRequestId;
    }

    @Override
    public Map<String, String> getQueryParams() {
        Map<String, String> result = super.getQueryParams();

        if (customerIds != null) {
            result.put("customer_ids", convertCollectionToStringParam(customerIds));
        }
        if (shopIds != null) {
            result.put("shop_ids", convertCollectionToStringParam(shopIds));
        }
        if (states != null) {
            result.put("states", convertCollectionToStringParam(states));
        }
        if (shopQuoteRequestId != null) {
            result.put("shop_quote_request_id", shopQuoteRequestId);
        }

        return result;
    }

    @Override
    public MiraklApiEndpoint getEndpoint() {
        return MiraklFrontApiEndpoint.Q04;
    }
}
