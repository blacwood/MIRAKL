/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.shop.bank;


import org.codehaus.jackson.annotate.JsonTypeName;

/**
 * Bank account information for a Shop using the Nuban format
 */
@JsonTypeName("NUBAN")
public class MiraklNubanBankAccountInformation extends MiraklBankAccountInformation {

    private String nuban;

    public String getNuban() {
        return nuban;
    }

    public void setNuban(String nuban) {
        this.nuban = nuban;
    }

}
