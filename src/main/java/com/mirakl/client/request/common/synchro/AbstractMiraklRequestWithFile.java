/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.request.common.synchro;

import com.mirakl.client.core.exception.MiraklRequestValidationException;
import com.mirakl.client.request.AbstractMiraklApiRequest;
import com.mirakl.client.request.MiraklApiRequest;

import java.io.File;
import java.io.InputStream;

public abstract class AbstractMiraklRequestWithFile extends AbstractMiraklApiRequest implements MiraklApiRequest {

    private File file;
    private InputStream inputStream;
    private String filename;

    public File getFile() {
        return file;
    }

    /**
     * Set the file that will be send for the import/synchronization.
     * Please not that the file and the inputstream cannot be both used at the same time
     */
    public void setFile(File file) {
        checkRequiredArgument(file, "file");
        if (inputStream != null) {
            throw new MiraklRequestValidationException("both file and inputStream cannot be used");
        }
        this.file = file;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    /**
     * Set the inputstream that will be send for the import/synchronization.
     * If the inputstream is set it is recommanded to set the filename
     */
    public void setInputStream(InputStream inputStream) {
        checkRequiredArgument(inputStream, "inputStream");
        if (file != null) {
            throw new MiraklRequestValidationException("both inputStream and file cannot be used");
        }
        this.inputStream = inputStream;
    }

    public String getFilename() {
        return filename;
    }

    /**
     * Set the filename used for the import/synchro in case the inputstream is used instead of the file
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AbstractMiraklRequestWithFile that = (AbstractMiraklRequestWithFile) o;

        if (file != null ? !file.equals(that.file) : that.file != null) {
            return false;
        }
        if (inputStream != null ? !inputStream.equals(that.inputStream) : that.inputStream != null) {
            return false;
        }
        return filename != null ? filename.equals(that.filename) : that.filename == null;

    }

    @Override
    public int hashCode() {
        int result = file != null ? file.hashCode() : 0;
        result = 31 * result + (inputStream != null ? inputStream.hashCode() : 0);
        result = 31 * result + (filename != null ? filename.hashCode() : 0);
        return result;
    }
}
