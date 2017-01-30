/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.shop.bank;


import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonTypeName;

/**
 * Bank account information for a Shop using the Australia BSB format
 */
@JsonTypeName("AUBSB")
public class MiraklAuBsbBankAccountInformation extends MiraklBankAccountInformation {

    /**
     * Bank State Branch code.
     */
    @JsonProperty("aubsb")
    private String bsbCode;
    /**
     * Bank Account Number.
     */
    @JsonProperty("auban")
    private String bsbBan;

    public String getBsbCode() {
        return bsbCode;
    }

    public void setBsbCode(String bsbCode) {
        this.bsbCode = bsbCode;
    }

    public String getBsbBan() {
        return bsbBan;
    }

    public void setBsbBan(String bsbBan) {
        this.bsbBan = bsbBan;
    }
}
