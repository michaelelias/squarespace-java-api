package com.wildspirit.squarespace.inventory;

import com.wildspirit.squarespace.common.Pagination;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public final class GetInventoryResponse {
    public final List<InventoryItem> inventory;
    public final Pagination pagination;

    public GetInventoryResponse(@JsonProperty("inventory") List<InventoryItem> inventory, @JsonProperty("pagination") Pagination pagination) {
        this.inventory = inventory;
        this.pagination = pagination;
    }
}
