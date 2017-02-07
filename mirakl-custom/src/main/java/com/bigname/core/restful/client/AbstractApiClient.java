package com.bigname.core.restful.client;

import com.bigname.core.restful.client.request.ApiRequest;
import com.bigname.core.restful.client.security.Credential;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Manu on 2/7/2017.
 */
public class AbstractApiClient {
    // Default connect timeout in 30 seconds
    private static final int DEFAULT_CONNECT_TIMEOUT_MILLISECONDS = 30000;
    // Default connect timeout in 60 seconds
    private static final int DEFAULT_READ_TIMEOUT_MILLISECONDS = 60000;

    private static final String MULTIPART_FILENAME_PARAM_NAME = "file";

    private String endpoint;

    private Credential credential;

    private static final ObjectMapper MAPPER = new ObjectMapper();
    static {
        MAPPER.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        MAPPER.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        MAPPER.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    protected AbstractApiClient(String endpoint, Credential credential) {
        this.endpoint = endpoint;
        this.credential = credential;
    }

    protected <T> T get(ApiRequest apiRequest, Class<T> objectType) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet request = getRequest(apiRequest, HttpGet.class);
        HttpResponse response = httpclient.execute(request);
        StringBuffer result = new StringBuffer();
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        return MAPPER.readValue(result.toString(), objectType);
//        System.out.println(result);
//
//        return result.toString();
    }

    private <T> T getRequest(ApiRequest apiRequest, Class<T> requestType) {
        if(requestType.isAssignableFrom(HttpPost.class)) {
            HttpPost request = new HttpPost(getEndpoint(apiRequest));
            request.addHeader("Authorization", credential.getApiKey());
            return (T)request;
        } else {
            HttpGet request = new HttpGet(getEndpoint(apiRequest));
            request.addHeader("Authorization", credential.getApiKey());
            return (T)request;
        }
    }

    private String getEndpoint(ApiRequest apiRequest) {
        StringBuilder path = new StringBuilder(endpoint);
        for (String str : apiRequest.getEndpoint().getPaths()) {
            path.append("/").append(str);
        }
        return path.toString();
    }



}
