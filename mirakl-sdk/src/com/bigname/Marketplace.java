package com.bigname;

import com.mirakl.client.core.security.MiraklCredential;
import com.mirakl.client.mmp.domain.shop.MiraklShop;
import com.mirakl.client.mmp.domain.shop.MiraklShops;
import com.mirakl.client.mmp.domain.version.MiraklVersion;
import com.mirakl.client.mmp.front.core.MiraklMarketplacePlatformFrontApi;
import com.mirakl.client.mmp.front.core.MiraklMarketplacePlatformFrontApiClient;
import com.mirakl.client.mmp.request.shop.MiraklGetShopsRequest;
import com.mirakl.client.mmp.request.version.MiraklGetVersionRequest;

/**
 * Created by Manu on 2/1/2017.
 */
public class Marketplace {

    public static final String API_KEY_FRONT = "5e5905d3-8a11-4b6b-bce9-c37f7a0111d5";
    public static final String ENV_URL = "https://envelopes-dev.mirakl.net/api";

    static MiraklCredential credential = new MiraklCredential(API_KEY_FRONT);

    static MiraklMarketplacePlatformFrontApi client = new MiraklMarketplacePlatformFrontApiClient(ENV_URL, credential);

    public static void main(String[] args) {
        getVersion();
        getShops();
    }

    public static void getVersion() {
        MiraklGetVersionRequest request = new MiraklGetVersionRequest();
        MiraklVersion version = client.getVersion();
        System.out.println(version.getVersion());
    }

    public static void getShops() {
        MiraklGetShopsRequest request = new MiraklGetShopsRequest();
        MiraklShops shops = client.getShops(request);
        System.out.println(shops.getTotalCount());
        for (MiraklShop miraklShop : shops.getShops()) {
            System.out.println(miraklShop.getId() + "," + miraklShop.getName() + "," + miraklShop.getState().name());
        }
    }
}
