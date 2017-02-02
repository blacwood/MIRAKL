package com.bigname.marketplace.mirakl.client.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by Manu on 2/2/2017.
 */
public class MiraklHierarchy {

    @JsonProperty("hierarchies")
    private List<HierarchyNode> nodes;

    public List<HierarchyNode> getNodes() {
        return nodes;
    }

    public void setNodes(List<HierarchyNode> nodes) {
        this.nodes = nodes;
    }
}
