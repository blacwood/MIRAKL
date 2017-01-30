/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.message;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.domain.common.MiraklUserType;
import org.codehaus.jackson.annotate.JsonProperty;

@Unicity(props = "id")
public class MiraklMessageUserSender {

    @JsonProperty("fromId")
    private String id;

    @JsonProperty("fromName")
    private String name;

    @JsonProperty("fromType")
    private MiraklUserType type;

    /**
     * Sender user ID
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * UserType of the sender
     */
    public MiraklUserType getType() {
        return type;
    }

    public void setType(MiraklUserType type) {
        this.type = type;
    }

    /**
     * Sender name
     */
    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklMessageUserSender that = (MiraklMessageUserSender) o;

        return id != null ? id.equals(that.id) : that.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
