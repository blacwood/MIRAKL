package com.bigname.core.restful.client.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

/**
 * Created by Manu on 1/30/2017.
 */
@Provider
public class ObjectMapperProvider implements ContextResolver<ObjectMapper> {

    private final ObjectMapper objectMapper;

    public ObjectMapperProvider() {
        objectMapper = new CustomObjectMapper();
    }

//    public ObjectMapperProvider(ObjectMapper objectMapper) {
//        this.objectMapper = objectMapper;
//    }

//    public ObjectMapperProvider() {
//        this.objectMapper = new CustomObjectMapper();
//    }

    @Override
    public ObjectMapper getContext(Class<?> type) {
        return objectMapper;
    }
}
