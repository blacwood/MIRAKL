package com.bigname.marketplace.mirakl.client;

import com.bigname.marketplace.mirakl.client.domain.MiraklShops;
import com.bigname.marketplace.mirakl.client.domain.MiraklVersion;
import com.bigname.marketplace.mirakl.client.request.GetShopsRequest;

/**
 * Created by Manu on 1/30/2017.
 */
public interface MiraklApi {
    MiraklVersion getVersion();

    MiraklShops getShops(GetShopsRequest request);
}
