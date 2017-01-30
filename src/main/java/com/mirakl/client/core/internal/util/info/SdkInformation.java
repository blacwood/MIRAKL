/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.core.internal.util.info;

public class SdkInformation {

    private String version;
    private String moduleName;

    public SdkInformation(String version, String moduleName) {
        this.version = version;
        this.moduleName = moduleName;
    }

    public String getVersion() {
        return version;
    }

    public String getModuleName() {
        return moduleName;
    }

}
