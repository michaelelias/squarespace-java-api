package com.wildspirit.squarespace.orders;

import com.wildspirit.squarespace.common.Pagination;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GetOrdersResponse {
    public final List<Order> result;
    public final Pagination pagination;

    public GetOrdersResponse(@JsonProperty("result") List<Order> result, @JsonProperty("pagination") Pagination pagination) {
        this.result = result;
        this.pagination = pagination;
    }
}
