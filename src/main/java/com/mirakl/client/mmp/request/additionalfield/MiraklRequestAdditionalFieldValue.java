/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.request.additionalfield;

import com.mirakl.client.domain.common.Unicity;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import java.io.IOException;
import java.util.List;

@JsonDeserialize(using = MiraklRequestAdditionalFieldValue.MiraklOutputAdditionalFieldValueDeserializer.class)
@Unicity(props = {"code"})
public abstract class MiraklRequestAdditionalFieldValue {

    private String code;

    public MiraklRequestAdditionalFieldValue() {
    }

    public MiraklRequestAdditionalFieldValue(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public static class MiraklSimpleRequestAdditionalFieldValue extends MiraklRequestAdditionalFieldValue {

        private String value;

        public MiraklSimpleRequestAdditionalFieldValue() {
        }

        public MiraklSimpleRequestAdditionalFieldValue(String code, String value) {
           super(code);
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

    }

    public static class MiraklMultipleRequestAdditionalFieldValue extends MiraklRequestAdditionalFieldValue {

        private List<String> values;

        public MiraklMultipleRequestAdditionalFieldValue() {
        }

        public MiraklMultipleRequestAdditionalFieldValue(String code, List<String> values) {
            super(code);
            this.values = values;
        }

        public List<String> getValues() {
            return values;
        }

        public void setValues(List<String> values) {
            this.values = values;
        }
    }


    /**
     * deserializer used only when API returns the input from SDK 'as is'
     * for example in case of error some APIs will return an 'input with error'
     */
    public static class MiraklOutputAdditionalFieldValueDeserializer extends JsonDeserializer<MiraklRequestAdditionalFieldValue> {

        @Override
        public MiraklRequestAdditionalFieldValue deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            JsonNode node = jsonParser.getCodec().readTree(jsonParser);

            if (!node.has("code")) {
                throw new JsonMappingException("Could not locate property 'code' in received mirakl output additional field "   );
            }

            String code = node.get("code").asText();



            if (node.has("value")) {

                String value = node.findValue("value").asText();
                return new MiraklSimpleRequestAdditionalFieldValue(code, value);

            } else if (node.has("values")){

                List<String> values = node.findValuesAsText("values");
                return new MiraklMultipleRequestAdditionalFieldValue(code, values);

            } else {

                throw new JsonMappingException("Could not locate property 'value' or 'values' in received mirakl output additional field");
            }

        }
    }
}
