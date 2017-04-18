/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.front.domain.quote.get;

import com.mirakl.client.domain.common.Unicity;
import org.codehaus.jackson.annotate.JsonUnwrapped;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.util.Collections.unmodifiableList;

@Unicity(props = "id")
public class MiraklQuote {

    private String id;
    private Date dateCreated;
    private MiraklQuoteState state;
    private List<MiraklQuoteLine> lines = new ArrayList<MiraklQuoteLine>();
    @JsonUnwrapped
    private MiraklQuotePriceSummary priceSummary;
    private List<MiraklQuoteOrderInformation> orders;
    private Date expirationDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public MiraklQuoteState getState() {
        return state;
    }

    public void setState(MiraklQuoteState state) {
        this.state = state;
    }

    public List<MiraklQuoteLine> getLines() {
        return unmodifiableList(lines);
    }

    public void setLines(List<MiraklQuoteLine> lines) {
        this.lines.addAll(lines);
    }

    public MiraklQuotePriceSummary getPriceSummary() {
        return priceSummary;
    }

    public void setPriceSummary(MiraklQuotePriceSummary priceSummary) {
        this.priceSummary = priceSummary;
    }

    public List<MiraklQuoteOrderInformation> getOrders() {
        return orders;
    }

    public void setOrders(List<MiraklQuoteOrderInformation> orders) {
        this.orders = orders;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklQuote that = (MiraklQuote) o;

        return id != null ? id.equals(that.id) : that.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
