/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.shop;

import com.mirakl.client.domain.common.Unicity;

@Unicity(includeAll = true)
public class MiraklShopAddress {

    private String civility;
    private String firstname;
    private String lastname;
    private String street1;
    private String street2;
    private String zipCode;
    private String state;
    private String city;
    private String country;
    private String phone;
    private String phoneSecondary;

    public String getCivility() {
        return civility;
    }

    public void setCivility(String civility) {
        this.civility = civility;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoneSecondary() {
        return phoneSecondary;
    }

    public void setPhoneSecondary(String phoneSecondary) {
        this.phoneSecondary = phoneSecondary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MiraklShopAddress)) return false;

        MiraklShopAddress that = (MiraklShopAddress) o;

        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (civility != null ? !civility.equals(that.civility) : that.civility != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (phoneSecondary != null ? !phoneSecondary.equals(that.phoneSecondary) : that.phoneSecondary != null)
            return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (street1 != null ? !street1.equals(that.street1) : that.street1 != null) return false;
        if (street2 != null ? !street2.equals(that.street2) : that.street2 != null) return false;
        if (zipCode != null ? !zipCode.equals(that.zipCode) : that.zipCode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = civility != null ? civility.hashCode() : 0;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (street1 != null ? street1.hashCode() : 0);
        result = 31 * result + (street2 != null ? street2.hashCode() : 0);
        result = 31 * result + (zipCode != null ? zipCode.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (phoneSecondary != null ? phoneSecondary.hashCode() : 0);
        return result;
    }
}
