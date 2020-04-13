package com.wildspirit.squarespace.orders;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class Shipping {
    public final String method;
    public final Amount amount;

    public Shipping(@JsonProperty("method") String method, @JsonProperty("amount") Amount amount) {
        this.method = method;
        this.amount = amount;
    }
}
