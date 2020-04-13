package com.wildspirit.squarespace.orders;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wildspirit.squarespace.orders.Fulfillment;
import com.wildspirit.squarespace.orders.Shipping;

import java.util.ArrayList;
import java.util.List;

public final class FulfillOrderRequest {
    @JsonIgnore
    public final String orderId;
    @JsonProperty("shouldSendNotification")
    public final boolean shouldSendNotification;
    @JsonProperty("shipments")
    public final List<Fulfillment> shipments;

    private FulfillOrderRequest(String orderId, boolean shouldSendNotification, List<Fulfillment> shipments) {
        this.orderId = orderId;
        this.shouldSendNotification = shouldSendNotification;
        this.shipments = shipments;
    }

    public static final class Builder {
        private String orderId;
        private boolean shouldSendNotification = true;
        private List<Fulfillment> shipments = new ArrayList<>();

        public Builder withOrderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder withShipment(Fulfillment fulfillment) {
            shipments.add(fulfillment);
            return this;
        }

        public Builder shouldSendNotification(boolean notify) {
            this.shouldSendNotification = notify;
            return this;
        }

        public FulfillOrderRequest build() {
            return new FulfillOrderRequest(orderId, shouldSendNotification, shipments);
        }
    }
}
