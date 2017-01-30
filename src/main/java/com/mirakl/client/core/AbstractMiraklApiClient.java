/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.core;

import com.mirakl.client.core.error.MiraklErrorResponseBean;
import com.mirakl.client.core.exception.MiraklApiException;
import com.mirakl.client.core.filter.MiraklAuthorizationRequestFilter;
import com.mirakl.client.core.filter.MiraklClientVersionRequestFilter;
import com.mirakl.client.core.filter.MiraklDefaultAcceptRequestFilter;
import com.mirakl.client.core.internal.MiraklClientConfigWrapper;
import com.mirakl.client.core.internal.mapper.MiraklObjectMapperProvider;
import com.mirakl.client.core.internal.util.info.SdkInformation;
import com.mirakl.client.core.internal.util.info.SdkInformationExtractor;
import com.mirakl.client.core.security.MiraklCredential;
import com.mirakl.client.request.MiraklApiRequest;
import com.mirakl.client.request.MiraklApiShopRequest;
import com.mirakl.client.request.common.synchro.AbstractMiraklRequestWithFile;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.media.multipart.BodyPart;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.MultiPart;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.media.multipart.file.FileDataBodyPart;
import org.glassfish.jersey.media.multipart.file.StreamDataBodyPart;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.*;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.InputStream;
import java.util.Map;
import java.util.logging.Logger;

import static com.mirakl.client.core.error.MiraklErrorResponseBeanParser.parseErrorFromResponse;

public abstract class AbstractMiraklApiClient {

    private static final Logger LOGGER = Logger.getLogger(AbstractMiraklApiClient.class.getName());

    // Default connect timeout in 30 seconds
    private static final int DEFAULT_CONNECT_TIMEOUT_MILLISECONDS = 30000;
    // Default connect timeout in 60 seconds
    private static final int DEFAULT_READ_TIMEOUT_MILLISECONDS = 60000;

    private static final String MULTIPART_FILENAME_PARAM_NAME = "file";
    private static final String SHOP_ID_PARAMETER_NAME = "shop_id";

    private boolean addSdkInformationAsQueryParam = true;

    private String endpoint;
    private Client client;
    private ClientConfig clientConfig;
    private MiraklCredential credential;
    private SdkInformation sdkInformation;

    /**
     * @param endpoint   the url of the Mirakl instance
     * @param credential the API key that will be used for the authentication
     */
    protected AbstractMiraklApiClient(String endpoint, MiraklCredential credential) {
        this.endpoint = endpoint;
        this.credential = credential;
        this.sdkInformation = SdkInformationExtractor.getInfo();

        LOGGER.fine("initializing mirakl API client with endpoint: " + this.endpoint);

        setDefaultConfiguration();

        MiraklClientConfigWrapper configWrapper = new MiraklClientConfigWrapper(clientConfig);
        configure(configWrapper);

        clientConfig.register(new MiraklObjectMapperProvider(configWrapper.getObjectMapper()));

        ClientBuilder builder = ClientBuilder.newBuilder()
                .withConfig(clientConfig);

        if (!configWrapper.isVerifySslCertificate()) {
            builder.hostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String s, SSLSession sslSession) {
                    return true;
                }
            });
        }

        this.client = builder.build();
    }

    private void setDefaultConfiguration() {
        clientConfig = new ClientConfig();
        clientConfig.register(new MultiPartFeature());
        clientConfig.register(new JacksonFeature());
        clientConfig.register(new MiraklDefaultAcceptRequestFilter());
        clientConfig.register(new MiraklClientVersionRequestFilter());
        clientConfig.register(new MiraklAuthorizationRequestFilter());
        clientConfig.property(ClientProperties.CONNECT_TIMEOUT, DEFAULT_CONNECT_TIMEOUT_MILLISECONDS);
        clientConfig.property(ClientProperties.READ_TIMEOUT, DEFAULT_READ_TIMEOUT_MILLISECONDS);
    }

    /**
     * Override this method to configure the REST Client
     */
    protected void configure(MiraklClientConfigWrapper clientConfigWrapper) {
        //Using the open close principle to let the sdk user configure jersey if needed
    }

    protected WebTarget buildWebTarget(MiraklApiRequest request) {
        // Setting the request URL
        WebTarget webTarget = client.target(endpoint);

        // Setting the path
        for (String path : request.getEndpoint().getPaths()) {
            webTarget = webTarget.path(path);
        }

        // Resolving template in path
        Map<String, String> requestTemplates = request.getRequestTemplates();
        for (Map.Entry<String, String> entry : requestTemplates.entrySet()) {
            webTarget = webTarget.resolveTemplate(entry.getKey(), entry.getValue());
        }

        // Setting the query params
        for (Map.Entry<String, String> param : request.getQueryParams().entrySet()) {
            webTarget = webTarget.queryParam(param.getKey(), param.getValue());
        }
        webTarget = addShopIdQueryParamIfRequired(request, webTarget);

        if (addSdkInformationAsQueryParam) {
            webTarget = webTarget.queryParam("sdk-version", sdkInformation.getVersion());
            webTarget = webTarget.queryParam("sdk-module", sdkInformation.getModuleName());
        }

        return webTarget;
    }

    private WebTarget addShopIdQueryParamIfRequired(MiraklApiRequest request, WebTarget webTarget) {
        if (request instanceof MiraklApiShopRequest) {
            String shopId = ((MiraklApiShopRequest) request).getShopId();
            if (shopId != null) {
                webTarget = webTarget.queryParam(SHOP_ID_PARAMETER_NAME, shopId);
            }
        }
        return webTarget;
    }

    protected MultiPart buildMultiPartFileRequest(AbstractMiraklRequestWithFile request) {
        File file = request.getFile();
        InputStream inputStream = request.getInputStream();

        BodyPart bodyPart;

        if (file != null) {
            bodyPart = new FileDataBodyPart(MULTIPART_FILENAME_PARAM_NAME, file, MediaType.TEXT_PLAIN_TYPE);
        } else {
            bodyPart = new StreamDataBodyPart(MULTIPART_FILENAME_PARAM_NAME, inputStream, request.getFilename());
        }

        return new FormDataMultiPart().bodyPart(bodyPart);
    }

    protected File getFile(MiraklApiRequest request) {
        return get(request, File.class);
    }

    private Invocation.Builder getRequest(MiraklApiRequest request) {
        Invocation.Builder r = buildWebTarget(request).request();
        r.property(HttpHeaders.AUTHORIZATION, credential.getApiKey());
        return r;
    }

    protected <E> E get(MiraklApiRequest request, Class<E> returnType) {
        try {
            return getRequest(request).get(returnType);
        } catch (WebApplicationException e) {
            MiraklErrorResponseBean errorResponseBean = parseErrorFromResponse(e.getResponse());
            throw new MiraklApiException(errorResponseBean, e);
        }
    }

    protected Response post(MiraklApiRequest request, Entity entity) {
        try {
            return getRequest(request).post(entity);
        } catch (WebApplicationException e) {
            MiraklErrorResponseBean errorResponseBean = parseErrorFromResponse(e.getResponse());
            throw new MiraklApiException(errorResponseBean, e);
        }
    }

    protected <E> E post(MiraklApiRequest request, Entity<?> entity, Class<E> returnType) {
        try {
            return getRequest(request).post(entity, returnType);
        } catch (WebApplicationException e) {
            MiraklErrorResponseBean errorResponseBean = parseErrorFromResponse(e.getResponse());
            throw new MiraklApiException(errorResponseBean, e);
        }
    }

    protected Response put(MiraklApiRequest request, Entity entity) {
        try {
            return getRequest(request).put(entity);
        } catch (WebApplicationException e) {
            MiraklErrorResponseBean errorResponseBean = parseErrorFromResponse(e.getResponse());
            throw new MiraklApiException(errorResponseBean, e);
        }
    }

    protected <E> E put(MiraklApiRequest request, Entity<?> entity, Class<E> returnType) {
        try {
            return getRequest(request).put(entity, returnType);
        } catch (WebApplicationException e) {
            MiraklErrorResponseBean errorResponseBean = parseErrorFromResponse(e.getResponse());
            throw new MiraklApiException(errorResponseBean, e);
        }
    }

    public void setAddSdkInformationAsQueryParam(boolean addSdkInformationAsQueryParam) {
        this.addSdkInformationAsQueryParam = addSdkInformationAsQueryParam;
    }

}
