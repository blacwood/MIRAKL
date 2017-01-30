/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.message;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.domain.customer.AbstractMiraklCustomer;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.Locale;

@Unicity(props = "id")
public class MiraklMessageCustomer extends AbstractMiraklCustomer {

    private String email;

    @JsonProperty("customer_email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    @JsonProperty("customer_civility")
    public String getCivility() {
        return super.getCivility();
    }

    @Override
    @JsonProperty("customer_firstname")
    public String getFirstname() {
        return super.getFirstname();
    }

    @Override
    @JsonProperty("customer_lastname")
    public String getLastname() {
        return super.getLastname();
    }

    @Override
    @JsonProperty("customer_locale")
    public Locale getLocale() {
        return super.getLocale();
    }


}
