/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.request.catalog.product;

import com.mirakl.client.core.internal.MiraklApiEndpoint;
import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.core.internal.MiraklFrontOperatorApiEndpoint;
import com.mirakl.client.request.MiraklApiRequest;
import com.mirakl.client.request.common.synchro.AbstractMiraklRequestWithFile;

import java.io.File;
import java.io.InputStream;

@Unicity(includeAll = true)
public class MiraklProductSynchroRequest extends AbstractMiraklRequestWithFile implements MiraklApiRequest {

    public MiraklProductSynchroRequest(File file) {
        setFile(file);
    }

    public MiraklProductSynchroRequest(InputStream inputStream) {
        setInputStream(inputStream);
    }

    public MiraklProductSynchroRequest(InputStream inputStream, String filename) {
        this(inputStream);
        setFilename(filename);
    }

    @Override
    public MiraklApiEndpoint getEndpoint() {
        return MiraklFrontOperatorApiEndpoint.P21;
    }

}
