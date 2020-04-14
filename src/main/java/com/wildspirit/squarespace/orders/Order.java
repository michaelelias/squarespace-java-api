package com.wildspirit.squarespace.orders;

import com.wildspirit.squarespace.common.Pagination;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

public class Order {
    public final String id;
    public final String orderNumber;
    public final Date createdOn;
    public final Date modifiedOn;
    public final String channel;
    public final boolean testMode;
    public final String customerEmail;
    public final Address shippingAddress;
    public final FulfillmentStatus fulfillmentStatus;
    public final List<LineItem> lineItems;
    public final List<Fulfillment> fulfillments;
    public final List<FormSubmission> formSubmission;
    public final List<Discounts> discountLines;
    public final List<Shipping> shippingLines;
    public final Amount subTotal;
    public final Amount shippingTotal;
    public final Amount discountTotal;
    public final Amount taxTotal;
    public final Amount refundedTotal;
    public final Amount grandTotal;

    public Order(
            @JsonProperty("id") String id,
            @JsonProperty("orderNumber") String orderNumber,
            @JsonProperty("createdOn") Date createdOn,
            @JsonProperty("modifiedOn") Date modifiedOn,
            @JsonProperty("channel") String channel,
            @JsonProperty("testMode") boolean testMode,
            @JsonProperty("customerEmail") String customerEmail,
            @JsonProperty("shippingAddress") Address shippingAddress,
            @JsonProperty("fulfillmentStatus") FulfillmentStatus fulfillmentStatus,
            @JsonProperty("lineItems") List<LineItem> lineItems,
            @JsonProperty("fulfillments") List<Fulfillment> fulfillments,
            @JsonProperty("formSubmission") List<FormSubmission> formSubmission,
            @JsonProperty("discountLines")  List<Discounts> discountLines,
            @JsonProperty("shippingLines") List<Shipping> shippingLines,
            @JsonProperty("subTotal") Amount subTotal,
            @JsonProperty("shippingTotal") Amount shippingTotal,
            @JsonProperty("discountTotal") Amount discountTotal,
            @JsonProperty("taxTotal") Amount taxTotal,
            @JsonProperty("refundedTotal") Amount refundedTotal,
            @JsonProperty("grandTotal") Amount grandTotal
    ) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.createdOn = createdOn;
        this.modifiedOn = modifiedOn;
        this.channel = channel;
        this.testMode = testMode;
        this.customerEmail = customerEmail;
        this.shippingAddress = shippingAddress;
        this.fulfillmentStatus = fulfillmentStatus;
        this.lineItems = lineItems;
        this.fulfillments = fulfillments;
        this.formSubmission = formSubmission;
        this.discountLines = discountLines;
        this.shippingLines = shippingLines;
        this.subTotal = subTotal;
        this.shippingTotal = shippingTotal;
        this.discountTotal = discountTotal;
        this.taxTotal = taxTotal;
        this.refundedTotal = refundedTotal;
        this.grandTotal = grandTotal;
    }

}
