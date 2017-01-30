/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.shop;

import com.mirakl.client.domain.common.Unicity;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Complementary information for profressional shops
 */
@JsonIgnoreProperties({"VAT_number"})
@Unicity(includeAll = true)
public class MiraklProfessionalInformation {

    /**
     * Corporation name
     */
    private String corporateName;

    /**
     * Professional identification number.
     * Can be the SIRET for french corporations
     */
    private String identificationNumber;

    /**
     * Tax identification number
     */
    private String taxIdentificationNumber;

    public String getCorporateName() {
        return corporateName;
    }

    public void setCorporateName(String corporateName) {
        this.corporateName = corporateName;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getTaxIdentificationNumber() {
        return taxIdentificationNumber;
    }

    public void setTaxIdentificationNumber(String taxIdentificationNumber) {
        this.taxIdentificationNumber = taxIdentificationNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MiraklProfessionalInformation)) return false;

        MiraklProfessionalInformation that = (MiraklProfessionalInformation) o;

        if (corporateName != null ? !corporateName.equals(that.corporateName) : that.corporateName != null)
            return false;
        if (identificationNumber != null ? !identificationNumber.equals(that.identificationNumber) : that.identificationNumber != null)
            return false;
        if (taxIdentificationNumber != null ? !taxIdentificationNumber.equals(that.taxIdentificationNumber) : that.taxIdentificationNumber != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = corporateName != null ? corporateName.hashCode() : 0;
        result = 31 * result + (identificationNumber != null ? identificationNumber.hashCode() : 0);
        result = 31 * result + (taxIdentificationNumber != null ? taxIdentificationNumber.hashCode() : 0);
        return result;
    }
}
