package com.m7.mirakl;

import com.bigname.core.restful.client.security.Credential;
import com.bigname.marketplace.mirakl.client.MiraklApi;
import com.bigname.marketplace.mirakl.client.MiraklApiClient;
import com.bigname.marketplace.mirakl.client.domain.MiraklShops;
import com.bigname.marketplace.mirakl.client.domain.MiraklVersion;
import com.bigname.marketplace.mirakl.client.request.GetShopsRequest;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Manu on 1/30/2017.
 */
public class MiraklApiTest {

    public static final String FRONT_API_KEY = "5e5905d3-8a11-4b6b-bce9-c37f7a0111d5";
    public static final String ENV_URL = "https://envelopes-dev.mirakl.net/api";

    public static void main(String[] args) {
        Credential credential = new Credential(FRONT_API_KEY);
        MiraklApi client = new MiraklApiClient(ENV_URL, credential);
        MiraklVersion version = client.getVersion();
        System.out.println(version.getVersion());

        MiraklShops shops = client.getShops(new GetShopsRequest());
        System.out.println(shops.getTotalCount());

    }

    public void postJsonWithHttpParams() throws URISyntaxException, UnsupportedEncodingException, IOException {

        //add the http parameters you wish to pass
        List<NameValuePair> postParameters = new ArrayList<>();
        postParameters.add(new BasicNameValuePair("param1", "param1_value"));
        postParameters.add(new BasicNameValuePair("param2", "param2_value"));

        //Build the server URI together with the parameters you wish to pass
        URIBuilder uriBuilder = new URIBuilder("http://google.ug");
        uriBuilder.addParameters(postParameters);

        HttpPost postRequest = new HttpPost(uriBuilder.build());
        postRequest.setHeader("Content-Type", "application/json");

        //this is your JSON string you are sending as a request
        String yourJsonString = "{\"str1\":\"a value\",\"str2\":\"another value\"} ";

        //pass the json string request in the entity
        HttpEntity entity = new ByteArrayEntity(yourJsonString.getBytes("UTF-8"));
        postRequest.setEntity(entity);

        //create a socketfactory in order to use an http connection manager
        PlainConnectionSocketFactory plainSocketFactory = PlainConnectionSocketFactory.getSocketFactory();
        Registry<ConnectionSocketFactory> connSocketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", plainSocketFactory)
                .build();

        PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager(connSocketFactoryRegistry);

        connManager.setMaxTotal(20);
        connManager.setDefaultMaxPerRoute(20);

        RequestConfig defaultRequestConfig = RequestConfig.custom()
                .setSocketTimeout(5000)
                .setConnectTimeout(5000)
                .setConnectionRequestTimeout(5000)
                .build();

        // Build the http client.
        CloseableHttpClient httpclient = HttpClients.custom()
                .setConnectionManager(connManager)
                .setDefaultRequestConfig(defaultRequestConfig)
                .build();

        CloseableHttpResponse response = httpclient.execute(postRequest);

        //Read the response
        String responseString = "";

        int statusCode = response.getStatusLine().getStatusCode();
        String message = response.getStatusLine().getReasonPhrase();

        HttpEntity responseHttpEntity = response.getEntity();

        InputStream content = responseHttpEntity.getContent();

        BufferedReader buffer = new BufferedReader(new InputStreamReader(content));
        String line;

        while ((line = buffer.readLine()) != null) {
            responseString += line;
        }

        //release all resources held by the responseHttpEntity
        EntityUtils.consume(responseHttpEntity);

        //close the stream
        response.close();

        // Close the connection manager.
        connManager.close();
    }

}
