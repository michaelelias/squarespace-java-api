package com.wildspirit.squarespace.inventory;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class QuantityOperation {
    public final String variantId;
    public final Integer quantity;

    public QuantityOperation(@JsonProperty("variantId") String variantId, @JsonProperty("quantity") Integer quantity) {
        this.variantId = variantId;
        this.quantity = quantity;
    }
}
