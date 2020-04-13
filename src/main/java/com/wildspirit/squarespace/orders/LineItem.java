package com.wildspirit.squarespace.orders;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public final class LineItem {
    public final String id;
    public final String variantId;
    public final String sku;
    public final String productId;
    public final String productName;
    public final Integer quanity;
    public final Amount unitPricePaid;
    public final List<VariantOption> variantOptions;
    public final String imageUrl;

    public LineItem(
            @JsonProperty("id") String id,
            @JsonProperty("varientId") String variantId,
            @JsonProperty("sku") String sku,
            @JsonProperty("productId") String productId,
            @JsonProperty("productName") String productName,
            @JsonProperty("quantity") Integer quantity,
            @JsonProperty("unitPricePaid") Amount unitPricePaid,
            @JsonProperty("variantOptions") List<VariantOption> variantOptions,
            @JsonProperty("imageUrl") String imageUrl
    ) {
        this.id = id;
        this.variantId = variantId;
        this.sku = sku;
        this.productId = productId;
        this.productName = productName;
        this.quanity = quantity;
        this.unitPricePaid = unitPricePaid;
        this.variantOptions = variantOptions;
        this.imageUrl = imageUrl;
    }

}
