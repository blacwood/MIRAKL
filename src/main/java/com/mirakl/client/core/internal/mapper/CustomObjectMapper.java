/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.core.internal.mapper;

import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.PropertyNamingStrategy;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.module.SimpleModule;

import java.math.BigDecimal;

public class CustomObjectMapper extends ObjectMapper {

    public CustomObjectMapper() {
        super();
        this.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
        this.disable(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS);
        this.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
        this.disable(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES);

        SimpleModule testModule = new SimpleModule("mirakl-module", new Version(1, 0, 0, null))
                .addDeserializer(BigDecimal.class, new BigDecimalMoneyDeserializer());

        this.registerModule(testModule);
    }

}
