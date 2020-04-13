package com.wildspirit.squarespace.orders;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public final class Amount {
    public final BigDecimal value;
    public final String currency;

    public Amount(
            @JsonProperty("value") BigDecimal value,
            @JsonProperty("currency") String currency
    ) {
        this.value = value;
        this.currency = currency;
    }
}
