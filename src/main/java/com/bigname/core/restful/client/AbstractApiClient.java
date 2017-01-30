package com.bigname.core.restful.client;

import com.bigname.core.restful.client.error.ErrorResponse;
import com.bigname.core.restful.client.error.ErrorResponseParser;
import com.bigname.core.restful.client.exception.ApiException;
import com.bigname.core.restful.client.filter.AuthorizationRequestFilter;
import com.bigname.core.restful.client.filter.DefaultAcceptRequestFilter;
import com.bigname.core.restful.client.mapper.ObjectMapperProvider;
import com.bigname.core.restful.client.request.ApiRequest;
import com.bigname.core.restful.client.security.Credential;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.media.multipart.MultiPartFeature;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.*;
import javax.ws.rs.core.HttpHeaders;
import java.util.*;
import java.util.logging.Logger;

/**
 * Created by Manu on 1/30/2017.
 */
public class AbstractApiClient {
    private static final Logger LOGGER = Logger.getLogger(AbstractApiClient.class.getName());

    // Default connect timeout in 30 seconds
    private static final int DEFAULT_CONNECT_TIMEOUT_MILLISECONDS = 30000;
    // Default connect timeout in 60 seconds
    private static final int DEFAULT_READ_TIMEOUT_MILLISECONDS = 60000;

    private String endpoint;
    private Client client;
    private ClientConfig clientConfig;
    private Credential credential;

    protected AbstractApiClient(String endpoint, Credential credential) {
        this.endpoint = endpoint;
        this.credential = credential;


    }

    protected void init(ClientRequestFilter[] requestFilters) {
        LOGGER.fine("Initializing REST API client with endpoint: " + this.endpoint);

        setDefaultConfiguration(requestFilters);

        ClientConfigWrapper configWrapper = new ClientConfigWrapper(clientConfig);
        configure(configWrapper);

        clientConfig.register(new ObjectMapperProvider(configWrapper.getObjectMapper()));

        ClientBuilder builder = ClientBuilder.newBuilder().withConfig(clientConfig);
        this.client = builder.build();

    }

    protected void configure(ClientConfigWrapper clientConfigWrapper) {}

    private void setDefaultConfiguration(ClientRequestFilter[] requestFilters) {
        clientConfig = new ClientConfig();
        clientConfig.register(new MultiPartFeature());
        clientConfig.register(new JacksonFeature());
        clientConfig.register(new DefaultAcceptRequestFilter());
        for(ClientRequestFilter requestFilter : requestFilters) {
            clientConfig.register(requestFilter);
        }
        clientConfig.register(new AuthorizationRequestFilter());
        clientConfig.property(ClientProperties.CONNECT_TIMEOUT, DEFAULT_CONNECT_TIMEOUT_MILLISECONDS);
        clientConfig.property(ClientProperties.READ_TIMEOUT, DEFAULT_READ_TIMEOUT_MILLISECONDS);
    }

    protected <E> E get(ApiRequest request, Class<E> returnType) {
        try {
            return getRequest(request).get(returnType);
        } catch (WebApplicationException e) {
            ErrorResponse errorResponseBean = ErrorResponseParser.parseErrorFromResponse(e.getResponse());
            throw new ApiException(errorResponseBean, e);
        }
    }

    private Invocation.Builder getRequest(ApiRequest request) {
        Invocation.Builder builder = buildWebTarget(request).request();
        builder.property(HttpHeaders.AUTHORIZATION, credential.getApiKey());
        return builder;
    }

    protected WebTarget buildWebTarget(ApiRequest request) {
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

        return webTarget;
    }
}
