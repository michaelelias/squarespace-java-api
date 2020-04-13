package com.wildspirit.squarespace.inventory;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public final class UpdateInventoryRequest {
    public final List<QuantityOperation> incrementOperations;
    public final List<QuantityOperation> decrementOperations;
    public final List<QuantityOperation> setFiniteOperations;
    public final List<String> setUnlimitedOperations;

    public UpdateInventoryRequest(
            @JsonProperty("incrementOperations") List<QuantityOperation> incrementOperations,
            @JsonProperty("decrementOperations") List<QuantityOperation> decrementOperations,
            @JsonProperty("setFiniteOperations") List<QuantityOperation> setFiniteOperations,
            @JsonProperty("setUnlimitedOperations") List<String> setUnlimitedOperations) {
        this.incrementOperations = incrementOperations;
        this.decrementOperations = decrementOperations;
        this.setFiniteOperations = setFiniteOperations;
        this.setUnlimitedOperations = setUnlimitedOperations;
    }
}
