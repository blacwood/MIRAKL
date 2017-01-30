/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.common;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.domain.additionalfield.MiraklAdditionalFieldType;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.List;
import java.util.logging.Logger;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", defaultImpl = MiraklAdditionalFieldValue.MiraklUnknownAdditionalFieldValue.class)
@JsonSubTypes({
        @JsonSubTypes.Type(MiraklAdditionalFieldValue.MiraklStringAdditionalFieldValue.class),
        @JsonSubTypes.Type(MiraklAdditionalFieldValue.MiraklDateAdditionalFieldValue.class),
        @JsonSubTypes.Type(MiraklAdditionalFieldValue.MiraklNumericAdditionalFieldValue.class),
        @JsonSubTypes.Type(MiraklAdditionalFieldValue.MiraklBooleanAdditionalFieldValue.class),
        @JsonSubTypes.Type(MiraklAdditionalFieldValue.MiraklLinkAdditionalFieldValue.class),
        @JsonSubTypes.Type(MiraklAdditionalFieldValue.MiraklValueListAdditionalFieldValue.class),
        @JsonSubTypes.Type(MiraklAdditionalFieldValue.MiraklRegexAdditionalFieldValue.class),
        @JsonSubTypes.Type(MiraklAdditionalFieldValue.MiraklTextAreaAdditionalFieldValue.class),
        @JsonSubTypes.Type(MiraklAdditionalFieldValue.MiraklMultipleValuesListAdditionalFieldValue.class)
})
@XmlSeeAlso({
        MiraklAdditionalFieldValue.MiraklStringAdditionalFieldValue.class,
        MiraklAdditionalFieldValue.MiraklDateAdditionalFieldValue.class,
        MiraklAdditionalFieldValue.MiraklNumericAdditionalFieldValue.class,
        MiraklAdditionalFieldValue.MiraklBooleanAdditionalFieldValue.class,
        MiraklAdditionalFieldValue.MiraklLinkAdditionalFieldValue.class,
        MiraklAdditionalFieldValue.MiraklValueListAdditionalFieldValue.class,
        MiraklAdditionalFieldValue.MiraklRegexAdditionalFieldValue.class,
        MiraklAdditionalFieldValue.MiraklTextAreaAdditionalFieldValue.class,
        MiraklAdditionalFieldValue.MiraklMultipleValuesListAdditionalFieldValue.class
})
@Unicity(props = {"code"})
public abstract class MiraklAdditionalFieldValue {

    private static final Logger LOGGER = Logger.getLogger(MiraklAdditionalFieldValue.class.getName());

    /**
     * Code of the additional field
     */
    protected String code;

    public MiraklAdditionalFieldValue() {
    }

    @JsonIgnore
    public abstract MiraklAdditionalFieldType getFieldType();

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "MiraklAdditionalFieldValue{" +
                "code='" + code + '\'' +
                '}';
    }

    @Unicity(props = {"code", "value"})
    public static abstract class MiraklAbstractAdditionalFieldWithSingleValue extends MiraklAdditionalFieldValue {
        /**
         * Value of the additional field
         */
        protected String value;

        public MiraklAbstractAdditionalFieldWithSingleValue() {}

        public MiraklAbstractAdditionalFieldWithSingleValue(String code, String value) {
            this.code = code;
            this.value = value;
        }

        @XmlElement(name = "value", required = true, nillable = false)
        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            MiraklAbstractAdditionalFieldWithSingleValue that = (MiraklAbstractAdditionalFieldWithSingleValue) o;

            return value != null ? value.equals(that.value) : that.value == null && !(code != null ? !code.equals(that.code) : that.code != null);

        }

        @Override
        public int hashCode() {
            int result = value != null ? value.hashCode() : 0;
            result = 31 * result + (code != null ? code.hashCode() : 0);
            return result;
        }
    }

    @Unicity(props = {"code", "values"})
    public static abstract class MiraklAbstractAdditionalFieldWithMultipleValues extends MiraklAdditionalFieldValue {
        /**
         * Values of the additional field
         */
        protected List<String> values;

        public MiraklAbstractAdditionalFieldWithMultipleValues() {}

        public MiraklAbstractAdditionalFieldWithMultipleValues(String code, List<String> values) {
            this.code = code;
            this.values = values;
        }

        @XmlElement(required = true, nillable = false, name = "values")
        public List<String> getValues() {
            return values;
        }

        public void setValues(List<String> values) {
            this.values  = values;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            MiraklAbstractAdditionalFieldWithMultipleValues that = (MiraklAbstractAdditionalFieldWithMultipleValues) o;

            return values != null ? values.containsAll(that.values) : that.values == null && !(code != null ? !code.equals(that.code) : that.code != null);

        }

        @Override
        public int hashCode() {
            return values.hashCode();
        }
    }

    @JsonTypeName("STRING")
    public static class MiraklStringAdditionalFieldValue extends MiraklAbstractAdditionalFieldWithSingleValue {
        public MiraklStringAdditionalFieldValue() {
            super();
        }

        public MiraklStringAdditionalFieldValue(String code, String value) {
            super(code, value);
        }

        @Override
        public MiraklAdditionalFieldType getFieldType() {
            return MiraklAdditionalFieldType.STRING;
        }
    }

    @JsonTypeName("DATE")
    public static class MiraklDateAdditionalFieldValue extends MiraklAbstractAdditionalFieldWithSingleValue {
        public MiraklDateAdditionalFieldValue() {
            super();
        }

        public MiraklDateAdditionalFieldValue(String code, String value) {
            super(code, value);
        }

        @Override
        public MiraklAdditionalFieldType getFieldType() {
            return MiraklAdditionalFieldType.DATE;
        }
    }

    @JsonTypeName("NUMERIC")
    public static class MiraklNumericAdditionalFieldValue extends MiraklAbstractAdditionalFieldWithSingleValue {
        public MiraklNumericAdditionalFieldValue() {
            super();
        }

        public MiraklNumericAdditionalFieldValue(String code, String value) {
            super(code, value);
        }

        @Override
        public MiraklAdditionalFieldType getFieldType() {
            return MiraklAdditionalFieldType.NUMERIC;
        }
    }

    @JsonTypeName("BOOLEAN")
    public static class MiraklBooleanAdditionalFieldValue extends MiraklAbstractAdditionalFieldWithSingleValue {
        public MiraklBooleanAdditionalFieldValue() {
            super();
        }

        public MiraklBooleanAdditionalFieldValue(String code, String value) {
            super(code, value);
        }

        @Override
        public MiraklAdditionalFieldType getFieldType() {
            return MiraklAdditionalFieldType.BOOLEAN;
        }
    }

    @JsonTypeName("LINK")
    public static class MiraklLinkAdditionalFieldValue extends MiraklAbstractAdditionalFieldWithSingleValue {
        public MiraklLinkAdditionalFieldValue() {
            super();
        }

        public MiraklLinkAdditionalFieldValue(String code, String value) {
            super(code, value);
        }

        @Override
        public MiraklAdditionalFieldType getFieldType() {
            return MiraklAdditionalFieldType.LINK;
        }
    }

    @JsonTypeName("LIST")
    public static class MiraklValueListAdditionalFieldValue extends MiraklAbstractAdditionalFieldWithSingleValue {
        public MiraklValueListAdditionalFieldValue() {
            super();
        }

        public MiraklValueListAdditionalFieldValue(String code, String value) {
            super(code, value);
        }

        @Override
        public MiraklAdditionalFieldType getFieldType() {
            return MiraklAdditionalFieldType.LIST;
        }
    }

    @JsonTypeName("REGEX")
    public static class MiraklRegexAdditionalFieldValue extends MiraklAbstractAdditionalFieldWithSingleValue {
        public MiraklRegexAdditionalFieldValue() {
            super();
        }

        public MiraklRegexAdditionalFieldValue(String code, String value) {
            super(code, value);
        }

        @Override
        public MiraklAdditionalFieldType getFieldType() {
            return MiraklAdditionalFieldType.REGEX;
        }
    }

    @JsonTypeName("TEXTAREA")
    public static class MiraklTextAreaAdditionalFieldValue extends MiraklAbstractAdditionalFieldWithSingleValue {
        public MiraklTextAreaAdditionalFieldValue() {
            super();
        }

        public MiraklTextAreaAdditionalFieldValue(String code, String value) {
            super(code, value);
        }

        @Override
        public MiraklAdditionalFieldType getFieldType() {
            return MiraklAdditionalFieldType.TEXTAREA;
        }
    }

    @JsonTypeName("MULTIPLE_VALUES_LIST")
    public static class MiraklMultipleValuesListAdditionalFieldValue extends MiraklAbstractAdditionalFieldWithMultipleValues {
        public MiraklMultipleValuesListAdditionalFieldValue() {
            super();
        }

        public MiraklMultipleValuesListAdditionalFieldValue(String code, List<String> values) {
            super(code, values);
        }

        @Override
        public MiraklAdditionalFieldType getFieldType() {
            return MiraklAdditionalFieldType.MULTIPLE_VALUES_LIST;
        }
    }

    public static class MiraklUnknownAdditionalFieldValue extends MiraklAbstractAdditionalFieldWithSingleValue {
        public MiraklUnknownAdditionalFieldValue() {
            LOGGER.warning("Deserialized an unknown Additional field type. Please ensure you are using the latest version of the Mirakl SDK.");
        }

        @Override
        public String getValue() {
            LOGGER.warning("Attempting to call getValue() on an unknown Additional field type. Please ensure you are using the latest version of the Mirakl SDK.");
            return null;
        }

        @Override
        public MiraklAdditionalFieldType getFieldType() {
            return null;
        }
    }


}
