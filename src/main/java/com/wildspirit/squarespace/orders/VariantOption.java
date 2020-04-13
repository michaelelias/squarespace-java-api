package com.wildspirit.squarespace.orders;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class VariantOption {
    public final String value;
    public final String optionName;

    public VariantOption(
            @JsonProperty("value") String value,
            @JsonProperty("optionName") String optionName
    ) {
        this.value = value;
        this.optionName = optionName;
    }
}
