/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.request.order.message;

import com.mirakl.client.domain.common.Unicity;

import java.util.List;
import java.util.Locale;

@Unicity(includeAll = true)
public class MiraklCreateOrderMessage {

    private String subject;
    private String body;

    private String customerId;
    private String customerEmail;
    private String customerFirstname;
    private String customerLastname;
    private Locale customerLocale;

    private boolean toShop;
    private boolean toCustomer;
    private boolean toOperator;

    private List<Long> documentIds;

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

    public String getCustomerId() {
        return customerId;
    }

    /**
     * Customer ID
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    /**
     * Customer e-mail
     */
    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerFirstname() {
        return customerFirstname;
    }

    /**
     * Customer first name
     */
    public void setCustomerFirstname(String customerFirstname) {
        this.customerFirstname = customerFirstname;
    }

    public String getCustomerLastname() {
        return customerLastname;
    }

    /**
     * Customer last name
     */
    public void setCustomerLocale(Locale customerLocale) {
        this.customerLocale = customerLocale;
    }

    public Locale getCustomerLocale() {
        return customerLocale;
    }

    /**
     * Customer last name
     */
    public void setCustomerLastname(String customerLastname) {
        this.customerLastname = customerLastname;
    }

    public boolean isToShop() {
        return toShop;
    }

    /**
     * Does the message will be sent to the shop?
     */
    public void setToShop(boolean toShop) {
        this.toShop = toShop;
    }

    public boolean isToCustomer() {
        return toCustomer;
    }

    /**
     * Does the message will be sent to the customer?
     */
    public void setToCustomer(boolean toCustomer) {
        this.toCustomer = toCustomer;
    }

    public boolean isToOperator() {
        return toOperator;
    }

    /**
     * Does the message will be sent to the operator?
     */
    public void setToOperator(boolean toOperator) {
        this.toOperator = toOperator;
    }

    public void setDocumentIds(List<Long> documentIds) {
        this.documentIds = documentIds;
    }

    public List<Long> getDocumentIds() {
        return documentIds;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklCreateOrderMessage that = (MiraklCreateOrderMessage) o;

        if (toShop != that.toShop) {
            return false;
        }
        if (toCustomer != that.toCustomer) {
            return false;
        }
        if (toOperator != that.toOperator) {
            return false;
        }
        if (subject != null ? !subject.equals(that.subject) : that.subject != null) {
            return false;
        }
        if (body != null ? !body.equals(that.body) : that.body != null) {
            return false;
        }
        if (customerId != null ? !customerId.equals(that.customerId) : that.customerId != null) {
            return false;
        }
        if (customerEmail != null ? !customerEmail.equals(that.customerEmail) : that.customerEmail != null) {
            return false;
        }
        if (customerFirstname != null ? !customerFirstname.equals(that.customerFirstname) : that.customerFirstname != null) {
            return false;
        }
        if (customerLastname != null ? !customerLastname.equals(that.customerLastname) : that.customerLastname != null) {
            return false;
        }
        if (customerLocale != null ? !customerLocale.equals(that.customerLocale) : that.customerLocale != null) {
            return false;
        }
        return documentIds != null ? documentIds.equals(that.documentIds) : that.documentIds == null;

    }

    @Override
    public int hashCode() {
        int result = subject != null ? subject.hashCode() : 0;
        result = 31 * result + (body != null ? body.hashCode() : 0);
        result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
        result = 31 * result + (customerEmail != null ? customerEmail.hashCode() : 0);
        result = 31 * result + (customerFirstname != null ? customerFirstname.hashCode() : 0);
        result = 31 * result + (customerLastname != null ? customerLastname.hashCode() : 0);
        result = 31 * result + (customerLocale != null ? customerLocale.hashCode() : 0);
        result = 31 * result + (toShop ? 1 : 0);
        result = 31 * result + (toCustomer ? 1 : 0);
        result = 31 * result + (toOperator ? 1 : 0);
        result = 31 * result + (documentIds != null ? documentIds.hashCode() : 0);
        return result;
    }
}
