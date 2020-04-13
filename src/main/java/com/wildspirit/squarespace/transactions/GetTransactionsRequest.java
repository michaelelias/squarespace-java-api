package com.wildspirit.squarespace.transactions;

import java.util.Date;

public final class GetTransactionsRequest {
    public final Date modifiedAfter;
    public final Date modifiedBefore;

    private GetTransactionsRequest(Date modifiedAfter, Date modifiedBefore) {
        this.modifiedAfter = modifiedAfter;
        this.modifiedBefore = modifiedBefore;
    }

    public final class Builder {
        private Date modifiedAfter;
        private Date modifiedBefore;

        public Builder before(Date date) {
            this.modifiedBefore = date;
            return this;
        }

        public Builder after(Date date) {
            this.modifiedBefore = date;
            return this;
        }

        public GetTransactionsRequest build() {
            return new GetTransactionsRequest(modifiedAfter, modifiedBefore);
        }
    }
}
