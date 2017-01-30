package com.bigname.core.restful.client;

import com.bigname.core.restful.client.mapper.CustomObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.glassfish.jersey.client.ClientConfig;

/**
 * Created by Manu on 1/30/2017.
 */
public class ClientConfigWrapper {
    private ClientConfig clientConfig;
    private ObjectMapper objectMapper = new CustomObjectMapper();

    private boolean verifySslCertificate = true;

    public ClientConfigWrapper(ClientConfig clientConfig) {
        this.clientConfig = clientConfig;
    }

    public ClientConfig getClientConfig() {
        return clientConfig;
    }

    public void setClientConfig(ClientConfig clientConfig) {
        this.clientConfig = clientConfig;
    }

    public boolean isVerifySslCertificate() {
        return verifySslCertificate;
    }

    /**
     * SSL Certificate verification should be disabled only for dev purposes
     */
    public void setVerifySslCertificate(boolean verifySslCertificate) {
        this.verifySslCertificate = verifySslCertificate;
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

}
