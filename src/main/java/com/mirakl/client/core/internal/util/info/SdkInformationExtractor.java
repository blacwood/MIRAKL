/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.core.internal.util.info;

import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SdkInformationExtractor {

    private static final Logger LOGGER = Logger.getLogger(SdkInformationExtractor.class.getName());

    public static SdkInformation getInfo(){
        InputStream stream = SdkInformationExtractor.class.getResourceAsStream("/version.txt");
        Properties props = new Properties();
        try {
            props.load(stream);
            stream.close();
            return new SdkInformation(props.getProperty("version"), props.getProperty("name"));
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Unable to read version used by the SDK", e);
            return new SdkInformation("UNKNOWN", "UNKNOWN");
        }
    }

}
