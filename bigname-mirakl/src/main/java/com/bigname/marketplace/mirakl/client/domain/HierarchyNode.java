package com.bigname.marketplace.mirakl.client.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Manu on 2/2/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class HierarchyNode {

    private String code;

    private String label;

    private int level;

    private String parentCode;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HierarchyNode)) return false;

        HierarchyNode that = (HierarchyNode) o;

        return getCode() != null ? getCode().equals(that.getCode()) : that.getCode() == null;

    }

    @Override
    public int hashCode() {
        return getCode() != null ? getCode().hashCode() : 0;
    }
}
