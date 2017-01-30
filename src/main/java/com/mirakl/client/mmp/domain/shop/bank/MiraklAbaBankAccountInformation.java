/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.shop.bank;

import com.mirakl.client.domain.common.Unicity;
import org.codehaus.jackson.annotate.JsonTypeName;

/**
 * Bank account information for a Shop using the IBAN format
 */
@JsonTypeName("ABA")
@Unicity(includeAll = true)
public class MiraklAbaBankAccountInformation extends MiraklBankAccountInformation {

    private String bankAccountNumber;

    private String routingNumber;

    private String bic;

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getRoutingNumber() {
        return routingNumber;
    }

    public void setRoutingNumber(String routingNumber) {
        this.routingNumber = routingNumber;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
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

        MiraklAbaBankAccountInformation that = (MiraklAbaBankAccountInformation) o;

        if (bankAccountNumber != null ? !bankAccountNumber.equals(that.bankAccountNumber) : that.bankAccountNumber != null) {
            return false;
        }
        if (routingNumber != null ? !routingNumber.equals(that.routingNumber) : that.routingNumber != null) {
            return false;
        }
        return bic != null ? bic.equals(that.bic) : that.bic == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (bankAccountNumber != null ? bankAccountNumber.hashCode() : 0);
        result = 31 * result + (routingNumber != null ? routingNumber.hashCode() : 0);
        result = 31 * result + (bic != null ? bic.hashCode() : 0);
        return result;
    }
}
