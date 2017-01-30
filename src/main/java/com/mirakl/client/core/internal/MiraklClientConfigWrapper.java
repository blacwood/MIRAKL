/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.core.internal;

import com.mirakl.client.core.internal.mapper.CustomObjectMapper;
import org.codehaus.jackson.map.ObjectMapper;
import org.glassfish.jersey.client.ClientConfig;

public class MiraklClientConfigWrapper {

    private ClientConfig clientConfig;
    private ObjectMapper objectMapper = new CustomObjectMapper();
    private boolean verifySslCertificate = true;

    public MiraklClientConfigWrapper(ClientConfig clientConfig) {
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
