package com.wildspirit.squarespace.inventory;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class InventoryItem {
    public final String variantId;
    public final String sku;
    public final String descriptor;
    public final boolean isUnlimited;
    public final int quantity;

    public InventoryItem(
            @JsonProperty("variantId") String variantId,
            @JsonProperty("sku") String sku,
            @JsonProperty("descriptor") String descriptor,
            @JsonProperty("isUnlimited") boolean isUnlimited,
            @JsonProperty("quantity") int quantity) {
        this.variantId = variantId;
        this.sku = sku;
        this.descriptor = descriptor;
        this.isUnlimited = isUnlimited;
        this.quantity = quantity;
    }
}
