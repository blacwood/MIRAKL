/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.front.request.quote.message;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class MiraklQuoteRequestMessageDocumentRequest {

    private final InputStream inputStream;
    private final String filename;

    public MiraklQuoteRequestMessageDocumentRequest(File file) throws FileNotFoundException {
        this.inputStream = new FileInputStream(file);
        this.filename = file.getName();
    }

    public MiraklQuoteRequestMessageDocumentRequest(InputStream inputStream, String filename) {
        this.inputStream = inputStream;
        this.filename = filename;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public String getFilename() {
        return filename;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklQuoteRequestMessageDocumentRequest that = (MiraklQuoteRequestMessageDocumentRequest) o;

        if (inputStream != null ? !inputStream.equals(that.inputStream) : that.inputStream != null) {
            return false;
        }
        return filename != null ? filename.equals(that.filename) : that.filename == null;

    }

    @Override
    public int hashCode() {
        int result = inputStream != null ? inputStream.hashCode() : 0;
        result = 31 * result + (filename != null ? filename.hashCode() : 0);
        return result;
    }
}
