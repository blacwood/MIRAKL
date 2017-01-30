/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.core.internal.mapper;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

import java.io.IOException;
import java.math.BigDecimal;

public class BigDecimalMoneyDeserializer extends JsonDeserializer<BigDecimal> {

    /**
     * This deserializer is a dirty fix for a Jackson issue
     * see https://github.com/FasterXML/jackson-databind/issues/632
     * <p/>
     * With @JsonUnwrapped the precision of bigdecimal is incorrect (jackson is
     * stripping trailing zeros at the end of number)
     * Thus we have to force scale to two decimals for amounts with currency that have decimals
     * but we do nothing for amounts of currency without decimal such as Yen (JPY) or Chilian Pesos (CLP)
     */
    @Override
    public BigDecimal deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        BigDecimal decimalValue = jp.getDecimalValue();
        if (decimalValue.scale() > 0) {
            return decimalValue.setScale(2, BigDecimal.ROUND_UNNECESSARY);
        } else {
            return decimalValue;
        }
    }
}