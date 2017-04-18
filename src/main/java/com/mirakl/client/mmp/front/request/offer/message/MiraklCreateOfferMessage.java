/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.front.request.offer.message;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.domain.message.MiraklMessageCustomer;
import org.codehaus.jackson.annotate.JsonUnwrapped;

@Unicity(includeAll = true)
public class MiraklCreateOfferMessage {

    private String subject;
    private String body;
    private boolean visible;
    @JsonUnwrapped
    private MiraklMessageCustomer customer;

    public String getSubject() {
        return subject;
    }

    /**
     * Message subject
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    /**
     * Message body
     */
    public void setBody(String body) {
        this.body = body;
    }

    public boolean isVisible() {
        return visible;
    }

    /**
     * Does the message is visible on the front by other customers?
     */
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public MiraklMessageCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(MiraklMessageCustomer customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklCreateOfferMessage that = (MiraklCreateOfferMessage) o;

        if (visible != that.visible) {
            return false;
        }
        if (subject != null ? !subject.equals(that.subject) : that.subject != null) {
            return false;
        }
        if (body != null ? !body.equals(that.body) : that.body != null) {
            return false;
        }
        return customer != null ? customer.equals(that.customer) : that.customer == null;

    }

    @Override
    public int hashCode() {
        int result = subject != null ? subject.hashCode() : 0;
        result = 31 * result + (body != null ? body.hashCode() : 0);
        result = 31 * result + (visible ? 1 : 0);
        result = 31 * result + (customer != null ? customer.hashCode() : 0);
        return result;
    }
}
