package com.wildspirit.squarespace.transactions;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wildspirit.squarespace.common.Pagination;

import java.util.List;

public final class GetTransactionsResponse {
    public final List<Document> documents;
    public final Pagination pagination;

    public GetTransactionsResponse(
            @JsonProperty("documents") List<Document> documents,
            @JsonProperty("pagination") Pagination pagination
    ) {
        this.documents = documents;
        this.pagination = pagination;
    }
}
