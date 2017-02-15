package com.m7.mirakl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvListReader;
import org.supercsv.io.ICsvListReader;
import org.supercsv.prefs.CsvPreference;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

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
        convert(rd);
        /*String[] header = new String[0];
        String line = "";
        while ((line = rd.readLine()) != null) {
            if(header.length == 0) {
                header = convertToArray(line);
            }
            result.append(line);
        }

        System.out.println(result);*/
        httpclient.close();
//        convert(rd, header);
    }

    public static void convert(BufferedReader reader) throws Exception{


        ICsvListReader listReader = new CsvListReader(reader, new CsvPreference.Builder('"', ';', "\n").build());
        String[] header = listReader.getHeader(true);
        final CellProcessor[] processors = new CellProcessor[header.length];
        for (int i = 0; i < processors.length; i ++) {
            processors[i] = new Optional();
        }
        while(listReader.read() != null) {
                List<Object> list = listReader.executeProcessors(processors);

            System.out.println(new ObjectMapper().writeValueAsString(list));
        }


    }

    public static String[] convertToArray(String values) {
        StringTokenizer tokenizer = new StringTokenizer(values, "\";\"");
        List<String> valList = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            valList.add(tokenizer.nextToken());
        }
        return valList.toArray(new String[0]);
    }



}
