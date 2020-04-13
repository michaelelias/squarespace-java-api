package com.wildspirit.squarespace.common;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class Pagination {
    public final String nextPageUrl;
    public final String nextPageCursor;
    public final boolean hasNextPage;

    public Pagination(
            @JsonProperty("nextPageUrl") String nextPageUrl,
            @JsonProperty("nextPageCursor") String nextPageCursor,
            @JsonProperty("hasNextPage") boolean hasNextPage
    ) {
        this.nextPageUrl = nextPageUrl;
        this.nextPageCursor = nextPageCursor;
        this.hasNextPage = hasNextPage;
    }
}
