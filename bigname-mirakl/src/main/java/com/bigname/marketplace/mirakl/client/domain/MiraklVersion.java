package com.bigname.marketplace.mirakl.client.domain;

/**
 * Created by Manu on 1/30/2017.
 */
public class MiraklVersion {
    private String version;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MiraklVersion that = (MiraklVersion) o;

        return version != null ? version.equals(that.version) : that.version == null;

    }

    @Override
    public int hashCode() {
        return version != null ? version.hashCode() : 0;
    }
}
