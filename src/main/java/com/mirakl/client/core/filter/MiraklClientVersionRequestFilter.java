/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.core.filter;

import com.mirakl.client.core.internal.util.info.SdkInformation;
import com.mirakl.client.core.internal.util.info.SdkInformationExtractor;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 *
 */
@Provider
public class MiraklClientVersionRequestFilter implements ClientRequestFilter {

    private SdkInformation sdkInformation;

    private static final String MIRAKL_SDK_VERSION_HEADER = "X-Mirakl-Sdk-Version";
    private static final String MIRAKL_SDK_MODULE_NAME = "X-Mirakl-Sdk-Module";

    public MiraklClientVersionRequestFilter() {
        sdkInformation = SdkInformationExtractor.getInfo();
    }

    @Override
    public void filter(ClientRequestContext requestContext) throws IOException {
        requestContext.getHeaders().putSingle(MIRAKL_SDK_VERSION_HEADER, sdkInformation.getVersion());
        requestContext.getHeaders().putSingle(MIRAKL_SDK_MODULE_NAME, sdkInformation.getModuleName());
    }

}
