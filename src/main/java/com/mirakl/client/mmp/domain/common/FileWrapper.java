/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.domain.common;

import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.request.common.document.AbstractDocumentDownloadRequest;

import java.io.File;

@Unicity(props = "file")
public class FileWrapper {

    private File file;
    private boolean zipped;

    public FileWrapper(File file, AbstractDocumentDownloadRequest request) {
        this.file = file;
        this.zipped = request.resultWillBeWrappedInAZipArchive();
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    /**
     * Does the docuemnts are wrapped in a zip?
     */
    public boolean isZipped() {
        return zipped;
    }

    public void setZipped(boolean zipped) {
        this.zipped = zipped;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        FileWrapper that = (FileWrapper) o;

        return file != null ? file.equals(that.file) : that.file == null;

    }

    @Override
    public int hashCode() {
        return file != null ? file.hashCode() : 0;
    }
}
