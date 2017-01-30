/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.shop.bank;

import com.mirakl.client.domain.common.Unicity;

@Unicity(includeAll = true)
public class MiraklBankAccountInformation extends MiraklPaymentInformation {

    private String bankName;

    private String bankStreet;

    private String bankZip;

    private String bankCity;

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankStreet() {
        return bankStreet;
    }

    public void setBankStreet(String bankStreet) {
        this.bankStreet = bankStreet;
    }

    public String getBankZip() {
        return bankZip;
    }

    public void setBankZip(String bankZip) {
        this.bankZip = bankZip;
    }

    public String getBankCity() {
        return bankCity;
    }

    public void setBankCity(String bankCity) {
        this.bankCity = bankCity;
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

        MiraklBankAccountInformation that = (MiraklBankAccountInformation) o;

        if (bankName != null ? !bankName.equals(that.bankName) : that.bankName != null) {
            return false;
        }
        if (bankStreet != null ? !bankStreet.equals(that.bankStreet) : that.bankStreet != null) {
            return false;
        }
        if (bankZip != null ? !bankZip.equals(that.bankZip) : that.bankZip != null) {
            return false;
        }
        return bankCity != null ? bankCity.equals(that.bankCity) : that.bankCity == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (bankName != null ? bankName.hashCode() : 0);
        result = 31 * result + (bankStreet != null ? bankStreet.hashCode() : 0);
        result = 31 * result + (bankZip != null ? bankZip.hashCode() : 0);
        result = 31 * result + (bankCity != null ? bankCity.hashCode() : 0);
        return result;
    }
}
