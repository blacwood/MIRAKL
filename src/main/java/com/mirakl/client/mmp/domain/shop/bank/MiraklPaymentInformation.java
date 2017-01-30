/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.shop.bank;

import com.mirakl.client.domain.common.Unicity;
import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonTypeInfo;

import static org.codehaus.jackson.annotate.JsonSubTypes.Type;

/**
 * Payment information that would be use to generate the invoice and the payment voucher info file
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "@type")
@JsonSubTypes({
        @Type(value = MiraklIbanBankAccountInformation.class),
        @Type(value = MiraklAbaBankAccountInformation.class),
        @Type(value = MiraklHKBankAccountInformation.class),
        @Type(value = MiraklNubanBankAccountInformation.class),
        @Type(value = MiraklNzBsbBankAccountInformation.class),
        @Type(value = MiraklAuBsbBankAccountInformation.class)
})
@Unicity(includeAll = true)
public class MiraklPaymentInformation {

    /**
     * Name of the owner of the payment information
     */
    private String owner;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MiraklPaymentInformation)) return false;

        MiraklPaymentInformation that = (MiraklPaymentInformation) o;

        if (owner != null ? !owner.equals(that.owner) : that.owner != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return owner != null ? owner.hashCode() : 0;
    }
}
