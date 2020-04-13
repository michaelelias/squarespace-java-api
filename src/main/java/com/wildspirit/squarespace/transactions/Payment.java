package com.wildspirit.squarespace.transactions;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wildspirit.squarespace.orders.Amount;

import java.util.Date;
import java.util.List;

public final class Payment {
    public final String id;
    public final Amount amount;
    public final Amount refundedAmount;
    public final Amount netAmount;
    public final String creditCardType;
    public final String provider;
    public final List<ProcessingFee> processingFees;
    public final String giftCardId;
    public final Date paidOn;
    public final String externalTransactionId;
    public final String externalCustomerId;

    public Payment(
            @JsonProperty("id") String id,
            @JsonProperty("amount") Amount amount,
            @JsonProperty("refundedAmount") Amount refundedAmount,
            @JsonProperty("netAmount") Amount netAmount,
            @JsonProperty("creditCardType") String creditCardType,
            @JsonProperty("provider") String provider,
            @JsonProperty("processingFees") List<ProcessingFee> processingFees,
            @JsonProperty("giftCardId") String giftCardId,
            @JsonProperty("paidOn") Date paidOn,
            @JsonProperty("externalTransactionId") String externalTransactionId,
            @JsonProperty("externalCustomerId") String externalCustomerId) {
        this.id = id;
        this.amount = amount;
        this.refundedAmount = refundedAmount;
        this.netAmount = netAmount;
        this.creditCardType = creditCardType;
        this.provider = provider;
        this.processingFees = processingFees;
        this.giftCardId = giftCardId;
        this.paidOn = paidOn;
        this.externalTransactionId = externalTransactionId;
        this.externalCustomerId = externalCustomerId;
    }
}
