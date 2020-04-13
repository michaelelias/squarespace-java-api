package com.wildspirit.squarespace.orders;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class Address {
    public final String firstName;
    public final String lastName;
    public final String address1;
    public final String address2;
    public final String postalCode;
    public final String city;
    public final String state;
    public final String countryCode;
    public final String phone;

    public Address(
            @JsonProperty("firstName") String firstName,
            @JsonProperty("lastName") String lastName,
            @JsonProperty("address1") String address1,
            @JsonProperty("address2") String address2,
            @JsonProperty("postalCode") String postalCode,
            @JsonProperty("city") String city,
            @JsonProperty("state") String state,
            @JsonProperty("countryCode") String countryCode,
            @JsonProperty("phone") String phone
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address1 = address1;
        this.address2 = address2;
        this.postalCode = postalCode;
        this.city = city;
        this.state = state;
        this.countryCode = countryCode;
        this.phone = phone;
    }
}
