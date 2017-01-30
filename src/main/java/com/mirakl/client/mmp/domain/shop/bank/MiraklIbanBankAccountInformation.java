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
@JsonTypeName("IBAN")
@Unicity(includeAll = true)
public class MiraklIbanBankAccountInformation extends MiraklBankAccountInformation {

    private String iban;

    private String bic;

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

}
