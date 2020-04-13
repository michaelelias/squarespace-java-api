package com.wildspirit.squarespace.orders;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class Discounts {
    public final String description;
    public final Amount amount;
    public final String promoCode;

    public Discounts(
            @JsonProperty("description") String description,
            @JsonProperty("amount") Amount amount,
            @JsonProperty("promocode") String promoCode) {
        this.description = description;
        this.amount = amount;
        this.promoCode = promoCode;
    }
}
