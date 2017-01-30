package com.m7.mirakl;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

/**
 * Created by Manu on 1/30/2017.
 */
public class GetTransformedFile {
    public static final String URL_STRING = "https://envelopes-dev.mirakl.net/api/products/imports/2008/transformed_file";
    public static final String FRONT_API_KEY = "5e5905d3-8a11-4b6b-bce9-c37f7a0111d5";

    public static void main(String[] args) throws Exception {



        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet request = new HttpGet(URL_STRING);
        request.addHeader("Authorization", FRONT_API_KEY);

        CloseableHttpResponse response = httpclient.execute(request);
        System.out.println(response.getStatusLine().getStatusCode());
        StringBuffer result = new StringBuffer();
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }

        System.out.println(result);
        httpclient.close();
    }

}
