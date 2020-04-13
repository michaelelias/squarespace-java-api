# Squarespace Java API

A java client for the Squarespace REST API

[ ![Download](https://api.bintray.com/packages/i386/maven/squarespace-java-api/images/download.svg) ](https://bintray.com/i386/maven/squarespace-java-api/_latestVersion)

# Usage

## Construct the client
```
Squarespace squarespace = new Squarespace(/** your key */);
```

## Orders
### Get a single order
```
squarespace.order("123")
```

### Get all orders
```
GetOrdersRequest request = new GetOrdersRequest.Builder()
    .withStatus(FulfillmentStatus.PENDING)
    .build();
squarespace.orders(request);
```

### Fulfill order
```
FulfillOrderRequest request = new FulfillOrderRequest.Builder()
    .withOrderId("123")
    .build();
squarespace.fulfillOrder(request);
```

## Inventory
### Get all inventory items
```
squarespace.inventory();
```

### Update inventory
```
UpdateInventoryRequest req = new UpdateInventoryRequest.Builder()
    .increment("variant-1", 10)     // increase variant-1 by 10 units
    .deincrement("variant-2", 11)   // decrease variant-2 by 10 units
    .set("variant-3", 20)           // set variant-3 to absolutely 20 units
    .unlimited("variant-4")         // variant-4 has unlimited units
    .build();
squarespace.updateInventory(req);
```

## Transactions

### Get transaction documents
```
GetTransactionsRequest req = new GetTransactionsRequest.Builder()
    .before(earlierDate)
    .after(laterDate)
    .build();
squarespace.transactions(req);
```

# Maven
Use maven – one of life's necessary evils – to fetch the latest version of this library.

## Add repository
```
<repository>
    <id>bintray-i386-maven</id>
    <name>bintray</name>
    <url>https://dl.bintray.com/i386/maven</url>
    <snapshots>
        <enabled>false</enabled>
    </snapshots>
</repository>
```

## Add dependency
```
<dependency>
    <groupId>com.wildspirit.squarespace</groupId>
    <artifactId>squarespace-java-api</artifactId>
    <version>0.1</version>
</dependency>
```


# License

MIT License
