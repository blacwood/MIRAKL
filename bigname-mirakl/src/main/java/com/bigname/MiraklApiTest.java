package com.bigname;

import com.bigname.core.restful.client.security.Credential;
import com.bigname.marketplace.mirakl.client.MiraklApi;
import com.bigname.marketplace.mirakl.client.MiraklApiClient;
import com.bigname.marketplace.mirakl.client.domain.*;
import com.bigname.marketplace.mirakl.client.request.GetHierarchyRequest;
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
        for (MiraklShop miraklShop : shops.getShops()) {
            System.out.println(miraklShop.getId() + "," + miraklShop.getName() + "," + miraklShop.getDateCreated());
        }

        MiraklHierarchy hierarchy = client.getHierarchy(new GetHierarchyRequest());
        System.out.println(hierarchy.getNodes().size());

        for (HierarchyNode hierarchyNode : hierarchy.getNodes()) {
            System.out.println(hierarchyNode.getCode() + "," + hierarchyNode.getLabel() + "," + hierarchyNode.getLevel() + "," + hierarchyNode.getParentCode());
        }

    }

}
