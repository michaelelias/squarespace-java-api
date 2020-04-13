package com.wildspirit.squarespace.orders;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class GetOrdersRequest {
    public final List<FulfillmentStatus> fulfillmentStatus;
    public final Date modifiedAfter;
    public final Date modifiedBefore;

    private GetOrdersRequest(List<FulfillmentStatus> fulfillmentStatus, Date modifiedAfter, Date modifiedBefore) {
        this.fulfillmentStatus = fulfillmentStatus;
        this.modifiedAfter = modifiedAfter;
        this.modifiedBefore = modifiedBefore;
    }

    public static class Builder {
        private List<FulfillmentStatus> fulfillmentStatus = new ArrayList<>();
        private Date modifiedAfter;
        private Date modifiedBefore;

        public Builder withStatus(FulfillmentStatus status) {
            fulfillmentStatus.add(status);
            return this;
        }

        public Builder before(Date date) {
            this.modifiedBefore = date;
            return this;
        }

        public Builder after(Date date) {
            this.modifiedAfter = date;
            return this;
        }

        public GetOrdersRequest build() {
            return new GetOrdersRequest(fulfillmentStatus, modifiedAfter, modifiedBefore);
        }
    }
}
