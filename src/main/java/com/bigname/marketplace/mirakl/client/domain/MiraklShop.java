package com.bigname.marketplace.mirakl.client.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mirakl.client.mmp.domain.shop.MiraklContactInformation;
import com.mirakl.client.mmp.domain.shop.MiraklShopState;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.Date;

/**
 * Created by Manu on 2/1/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MiraklShop {

    @JsonProperty("shop_id")
    private String id;

    private Date dateCreated;

    @JsonProperty("shop_name")
    private String name;

    @JsonProperty("contact_informations")
    private MiraklContactInformation contactInformation;

    private Date lastUpdatedDate;

    @JsonProperty("shop_state")
    private MiraklShopState state;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MiraklContactInformation getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(MiraklContactInformation contactInformation) {
        this.contactInformation = contactInformation;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public MiraklShopState getState() {
        return state;
    }

    public void setState(MiraklShopState state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklShop that = (MiraklShop) o;

        return id != null ? id.equals(that.id) : that.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

}
