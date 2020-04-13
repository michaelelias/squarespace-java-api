package com.wildspirit.squarespace.orders;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class FormSubmission {
    public final String label;
    public final String value;

    public FormSubmission(
            @JsonProperty("label") String label,
            @JsonProperty("value") String value
    ) {
        this.label = label;
        this.value = value;
    }
}
