/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.message;


import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.jsontype.TypeIdResolver;
import org.codehaus.jackson.map.jsontype.impl.AsPropertyTypeDeserializer;
import org.codehaus.jackson.map.type.SimpleType;
import org.codehaus.jackson.node.TreeTraversingParser;
import org.codehaus.jackson.type.JavaType;

import java.io.IOException;

public class CustomMessageTypeDeserializer extends AsPropertyTypeDeserializer {

    public CustomMessageTypeDeserializer(JavaType bt, TypeIdResolver idRes, BeanProperty property, Class<?> defaultImpl, String typePropName) {
        super(bt, idRes, property, defaultImpl, typePropName);
    }

    @Override
    public Object deserializeTypedFromObject(JsonParser jp, DeserializationContext ctxt) throws IOException {
        JsonNode node = jp.readValueAsTree();
        Class<?> subType = findSubType(node);
        JavaType type = SimpleType.construct(subType);

        JsonParser jsonParser = new TreeTraversingParser(node, jp.getCodec());
        if (jsonParser.getCurrentToken() == null) {
            jsonParser.nextToken();
        }

        if (_baseType != null && _baseType.getClass() == type.getClass()) {
            type = _baseType.narrowBy(type.getRawClass());
        }

        JsonDeserializer<Object> deser = ctxt.getDeserializerProvider().findValueDeserializer(ctxt.getConfig(), type, _property);
        return deser.deserialize(jsonParser, ctxt);
    }

    protected Class<?> findSubType(JsonNode node) {
        Class<? extends AbstractMiraklMessage> subType;
        boolean hasOrderId = checkNotNull(node.get("order_id"));
        boolean hasOfferId = checkNotNull(node.get("offer_id"));

        if (hasOrderId == hasOfferId) {
            throw new IllegalArgumentException("cannot determine type for message, only one of following properties should be not null: order_id, offer_id ");
        }

        if (hasOrderId) {
            subType = MiraklOrderMessage.class;
        } else {
            subType = MiraklOfferMessage.class;
        }

        return subType;
    }

    private boolean checkNotNull(JsonNode node) {
        return node != null && !node.isNull();
    }

}
