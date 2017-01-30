/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.additionalfield;

import com.mirakl.client.domain.common.Unicity;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties({"default_value"})
@Unicity(props = {"code", "entity"})
public abstract class AbstractMiraklAdditionalField {

    private String code;
    private String label;
    private MiraklAdditionalFieldType type;
    private boolean required;
    private MiraklAdditionalFieldLinkedEntity entity;
    private List<String> acceptedValues;
    private String regex;

    /**
     * Code of the additional field
     */
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Label of the additional field
     */
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * Type of the additional field
     */
    public MiraklAdditionalFieldType getType() {
        return type;
    }

    public void setType(MiraklAdditionalFieldType type) {
        this.type = type;
    }

    /**
     * Whether or not the additionnal field is required
     */
    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    /**
     * The object on which the additional field applies
     */
    public MiraklAdditionalFieldLinkedEntity getEntity() {
        return entity;
    }

    public void setEntity(MiraklAdditionalFieldLinkedEntity entity) {
        this.entity = entity;
    }

    /**
     * This list populated with the accepted values of additional field when the type is MiraklAdditionalFieldType.LIST
     */
    public List<String> getAcceptedValues() {
        return acceptedValues;
    }

    public void setAcceptedValues(List<String> acceptedValues) {
        this.acceptedValues = acceptedValues;
    }

    /**
     * The regular expression that is used to validate the field value
     */
    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AbstractMiraklAdditionalField that = (AbstractMiraklAdditionalField) o;

        if (code != null ? !code.equals(that.code) : that.code != null) {
            return false;
        }
        return entity == that.entity;

    }

    @Override
    public int hashCode() {
        int result = code != null ? code.hashCode() : 0;
        result = 31 * result + (entity != null ? entity.hashCode() : 0);
        return result;
    }
}
