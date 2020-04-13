package com.wildspirit.squarespace.transactions;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wildspirit.squarespace.orders.Amount;

import java.util.Date;
import java.util.List;

public final class Document {
    public final String id;
    public final Date createdOn;
    public final Date modifiedOn;
    public final String customerEmail;
    public final String salesOrderId;
    public final boolean voided;
    public final Amount totalSales;
    public final Amount totalNetSales;
    public final Amount totalNetShipping;
    public final Amount totalTaxes;
    public final Amount total;
    public final Amount totalNetPayment;
    public final List<Payment> payments;

    public Document(
            @JsonProperty("id") String id,
            @JsonProperty("createdOn") Date createdOn,
            @JsonProperty("modifiedOn") Date modifiedOn,
            @JsonProperty("customerEmail") String customerEmail,
            @JsonProperty("salesOrderId") String salesOrderId,
            @JsonProperty("voided") boolean voided,
            @JsonProperty("totalSales") Amount totalSales,
            @JsonProperty("totalNetSales") Amount totalNetSales,
            @JsonProperty("totalNetShipping") Amount totalNetShipping,
            @JsonProperty("totalTaxes") Amount totalTaxes,
            @JsonProperty("total") Amount total,
            @JsonProperty("totalNetPayment") Amount totalNetPayment,
            @JsonProperty("payments") List<Payment> payments) {
        this.id = id;
        this.createdOn = createdOn;
        this.modifiedOn = modifiedOn;
        this.customerEmail = customerEmail;
        this.salesOrderId = salesOrderId;
        this.voided = voided;
        this.totalSales = totalSales;
        this.totalNetSales = totalNetSales;
        this.totalNetShipping = totalNetShipping;
        this.totalTaxes = totalTaxes;
        this.total = total;
        this.totalNetPayment = totalNetPayment;
        this.payments = payments;
    }
}
