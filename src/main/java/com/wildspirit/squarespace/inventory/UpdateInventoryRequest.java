package com.wildspirit.squarespace.inventory;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public final class UpdateInventoryRequest {
    public final List<QuantityOperation> incrementOperations;
    public final List<QuantityOperation> decrementOperations;
    public final List<QuantityOperation> setFiniteOperations;
    public final List<String> setUnlimitedOperations;

    private UpdateInventoryRequest(
            @JsonProperty("incrementOperations") List<QuantityOperation> incrementOperations,
            @JsonProperty("decrementOperations") List<QuantityOperation> decrementOperations,
            @JsonProperty("setFiniteOperations") List<QuantityOperation> setFiniteOperations,
            @JsonProperty("setUnlimitedOperations") List<String> setUnlimitedOperations) {
        this.incrementOperations = incrementOperations;
        this.decrementOperations = decrementOperations;
        this.setFiniteOperations = setFiniteOperations;
        this.setUnlimitedOperations = setUnlimitedOperations;
    }

    public static class Builder {
        private List<QuantityOperation> incrementOperations = new ArrayList<>();
        private List<QuantityOperation> decrementOperations = new ArrayList<>();
        private List<QuantityOperation> setFiniteOperations = new ArrayList<>();
        private List<String> setUnlimitedOperations = new ArrayList<>();

        public Builder increment(String variant, int qty) {
            incrementOperations.add(new QuantityOperation(variant, qty));
            return this;
        }

        public Builder deincrement(String variant, int qty) {
            decrementOperations.add(new QuantityOperation(variant, qty));
            return this;
        }

        public Builder set(String variant, int qty) {
            setFiniteOperations.add(new QuantityOperation(variant, qty));
            return this;
        }

        public Builder unlimited(String variant) {
            setUnlimitedOperations.add(variant);
            return this;
        }

        UpdateInventoryRequest build() {
            return new UpdateInventoryRequest(incrementOperations, decrementOperations, setFiniteOperations, setUnlimitedOperations);
        }
    }
}
