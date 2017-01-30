/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.request.additionalfield;

import com.mirakl.client.core.internal.MiraklApiEndpoint;
import com.mirakl.client.core.internal.util.MiraklApiUtils;
import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.core.internal.MiraklMarketplacePlatformCommonApiEndpoint;
import com.mirakl.client.mmp.domain.additionalfield.MiraklAdditionalFieldLinkedEntity;
import com.mirakl.client.request.AbstractMiraklApiRequest;

import java.util.Collection;
import java.util.Locale;
import java.util.Map;

@Unicity(includeAll = true)
public abstract class AbstractMiraklGetAdditionalFieldRequest extends AbstractMiraklApiRequest {

    private Collection<MiraklAdditionalFieldLinkedEntity> entities;

    private Locale locale;

    @Override
    public MiraklApiEndpoint getEndpoint() {
        return MiraklMarketplacePlatformCommonApiEndpoint.AF01;
    }

    @Override
    public Map<String, String> getQueryParams() {
        Map<String, String> result = super.getQueryParams();

        if (entities != null) {
            result.put("entities", MiraklApiUtils.convertCollectionToStringParam(entities));
        }

        if (locale != null) {
            result.put("locale", locale.toString());
        }

        return result;
    }

    /**
     * The object on which the additional field applies.
     * Ex: {@link MiraklAdditionalFieldLinkedEntity#OFFER}, {@link MiraklAdditionalFieldLinkedEntity#SHOP}
     */
    public void setEntities(Collection<MiraklAdditionalFieldLinkedEntity> entities) {
        this.entities = entities;
    }

    public Collection<MiraklAdditionalFieldLinkedEntity> getEntities() {
        return entities;
    }


    public Locale getLocale() {
        return locale;
    }

    /**
     * The locale of the server response
     */
    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AbstractMiraklGetAdditionalFieldRequest that = (AbstractMiraklGetAdditionalFieldRequest) o;

        if (entities != null ? !entities.equals(that.entities) : that.entities != null) {
            return false;
        }
        return locale != null ? locale.equals(that.locale) : that.locale == null;

    }

    @Override
    public int hashCode() {
        int result = entities != null ? entities.hashCode() : 0;
        result = 31 * result + (locale != null ? locale.hashCode() : 0);
        return result;
    }
}
