# Squarespace Java API

A very simple wrapper around the Squarespace REST API

# Usage

```
Squarespace squarespace = new Squarespace(/** your key */);

// Get a single order
squarespace.order("123")

// Get all orders
GetOrdersRequest request = new GetOrdersRequest.Builder()
    .withStatus(FulfillmentStatus.PENDING)
    .build();
squarespace.orders(request);

// Fulfill order
FulfillOrderRequest request = new FulfillOrderRequest.Builder()
    .withOrderId("123")
    .build();
squarespace.fulfillOrder(request);

// Get all inventory items
squarespace.inventory();
```

# License

MIT License
