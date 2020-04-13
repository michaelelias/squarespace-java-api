package com.wildspirit.squarespace.orders;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public final class Fulfillment {
    public final Date shipDate;
    public final String carrierName;
    public final String service;
    public final String trackingNumber;
    public final String trackingUrl;

    public Fulfillment(
            @JsonProperty("shipDate") Date shipDate,
            @JsonProperty("carrierName") String carrierName,
            @JsonProperty("service") String service,
            @JsonProperty("trackingNumber") String trackingNumber,
            @JsonProperty("trackingUrl") String trackingUrl
    ) {
        this.shipDate = shipDate;
        this.carrierName = carrierName;
        this.service = service;
        this.trackingNumber = trackingNumber;
        this.trackingUrl = trackingUrl;
    }
}
