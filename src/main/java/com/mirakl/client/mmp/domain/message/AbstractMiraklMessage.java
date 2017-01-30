/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.message;

import com.mirakl.client.domain.common.Unicity;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.annotate.JsonUnwrapped;
import org.codehaus.jackson.map.annotate.JsonTypeResolver;

import java.util.Date;

@JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
@JsonTypeResolver(MessageTypeResolver.class)
@JsonIgnoreProperties({
        "read", "archived", "to_shop_archived", "to_customer_archived", "to_operator_archived"
})
@Unicity(props = "id")
public class AbstractMiraklMessage {

    private String id;

    private String subject;
    private String body;

    private Date dateCreated;

    @JsonUnwrapped
    private MiraklMessageUserSender userSender;

    @JsonUnwrapped
    private MiraklMessageShopRecipient shopRecipient;

    @JsonUnwrapped
    private MiraklMessageCustomerRecipient customerRecipient;

    private boolean toOperator;

    /**
     * Message ID
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Message subject
     */
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * Message body
     */
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    /**
     * Does the message has been sent to the operator?
     */
    public boolean isToOperator() {
        return toOperator;
    }

    public void setToOperator(boolean toOperator) {
        this.toOperator = toOperator;
    }

    /**
     * Information about the user sending the message
     */
    public MiraklMessageUserSender getUserSender() {
        return userSender;
    }

    public void setUserSender(MiraklMessageUserSender userSender) {
        this.userSender = userSender;
    }

    /**
     * Information about the shop if one is recipient for the message
     */
    public MiraklMessageShopRecipient getShopRecipient() {
        return shopRecipient;
    }

    public void setShopRecipient(MiraklMessageShopRecipient shopRecipient) {
        this.shopRecipient = shopRecipient;
    }

    /**
     * Information about the customer if one is recipient for the message
     */
    public MiraklMessageCustomerRecipient getCustomerRecipient() {
        return customerRecipient;
    }

    public void setCustomerRecipient(MiraklMessageCustomerRecipient customerRecipient) {
        this.customerRecipient = customerRecipient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AbstractMiraklMessage that = (AbstractMiraklMessage) o;

        return id != null ? id.equals(that.id) : that.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
