package com.m7.mirakl;

import com.bigname.core.restful.client.security.Credential;
import com.bigname.marketplace.mirakl.client.MiraklApi;
import com.bigname.marketplace.mirakl.client.MiraklApiClient;
import com.bigname.marketplace.mirakl.client.domain.MiraklShops;
import com.bigname.marketplace.mirakl.client.domain.MiraklVersion;
import com.bigname.marketplace.mirakl.client.request.GetShopsRequest;

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

}
