package com.wildspirit.squarespace.transactions;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wildspirit.squarespace.orders.Amount;

import java.math.BigDecimal;

public final class ProcessingFee {
    public final String id;
    public final Amount amount;
    public final Amount amountGatewayCurrency;
    public final BigDecimal exchangeRate;
    public final Amount refundedAmount;
    public final Amount refundedAmountGatewayCurrency;
    public final Amount netAmount;
    public final Amount netAmountGatewayCurrency;

    public ProcessingFee(
            @JsonProperty("id") String id,
            @JsonProperty("amount") Amount amount,
            @JsonProperty("amountGatewayCurrency") Amount amountGatewayCurrency,
            @JsonProperty("exchangeRate") BigDecimal exchangeRate,
            @JsonProperty("refundedAmount") Amount refundedAmount,
            @JsonProperty("refundedAmountGatewayCurrency") Amount refundedAmountGatewayCurrency,
            @JsonProperty("netAmount") Amount netAmount,
            @JsonProperty("netAmountGatewayCurrency") Amount netAmountGatewayCurrency
    ) {
        this.id = id;
        this.amount = amount;
        this.amountGatewayCurrency = amountGatewayCurrency;
        this.exchangeRate = exchangeRate;
        this.refundedAmount = refundedAmount;
        this.refundedAmountGatewayCurrency = refundedAmountGatewayCurrency;
        this.netAmount = netAmount;
        this.netAmountGatewayCurrency = netAmountGatewayCurrency;
    }
}
