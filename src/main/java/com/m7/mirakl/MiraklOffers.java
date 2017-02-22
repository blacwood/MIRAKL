package com.m7.mirakl;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

/**
 * Created by Manu on 2/22/2017.
 */
public class MiraklOffers {
    public static final String URL_STRING = "https://envelopes-dev.mirakl.net/api/offers/export";
    public static final String FRONT_API_KEY = "5e5905d3-8a11-4b6b-bce9-c37f7a0111d5";

    public static void main(String[] args) throws Exception {

        File file = new File("C:\\tmp\\offers-1487017699294.csv");

        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet request = new HttpGet(URL_STRING);
        request.addHeader("Authorization", FRONT_API_KEY);

        HttpEntity entity = httpclient.execute(request).getEntity();
        if (entity != null) {
            try (FileOutputStream outstream = new FileOutputStream(file)) {
                entity.writeTo(outstream);
            }
        }
        httpclient.close();
    }
}
