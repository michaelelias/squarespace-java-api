package com.wildspirit.squarespace;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wildspirit.squarespace.inventory.GetInventoryResponse;
import com.wildspirit.squarespace.inventory.InventoryItem;
import com.wildspirit.squarespace.inventory.UpdateInventoryRequest;
import com.wildspirit.squarespace.orders.GetOrdersRequest;
import com.wildspirit.squarespace.orders.GetOrdersResponse;
import com.wildspirit.squarespace.orders.Order;
import io.mikael.urlbuilder.UrlBuilder;
import okhttp3.*;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringJoiner;

public final class Squarespace {
    private final OkHttpClient client = new OkHttpClient();
    private final String apiKey;
    private final ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    private static final SimpleDateFormat ISO8601 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");

    public Squarespace(String apiKey) {
        this.apiKey = apiKey;
    }

    public Iterable<InventoryItem> inventory() {
       return () -> new Iterator<>() {
           GetInventoryResponse resp = httpGet("https://api.squarespace.com/1.0/commerce/inventory", GetInventoryResponse.class);
           Iterator<InventoryItem> inventory = resp.inventory.iterator();

           @Override
           public boolean hasNext() {
               if (inventory.hasNext()) {
                   return true;
               } else {
                   if (resp.pagination.hasNextPage) {
                       // Fetch the next page
                       resp = httpGet(resp.pagination.nextPageUrl, GetInventoryResponse.class);
                       inventory = resp.inventory.iterator();
                       return inventory.hasNext();
                   } else {
                       // No more pages
                       return false;
                   }
               }
           }

           @Override
           public InventoryItem next() {
               return inventory.next();
           }
       };
    }

    public void updateInventory(UpdateInventoryRequest req) {
        Map<String, String> params = new HashMap<>();
        params.put("Idempotency-Key", newIdempotencyKey());
        httpPost("https://api.squarespace.com/1.0/commerce/inventory/adjustments", req, params, Void.class);
    }

    public Iterable<Order> orders(GetOrdersRequest req) {
        UrlBuilder builder = UrlBuilder.fromString("https://api.squarespace.com/1.0/commerce/orders");
        if (req.fulfillmentStatus != null && !req.fulfillmentStatus.isEmpty()) {
            StringJoiner joiner = new StringJoiner(",");
            req.fulfillmentStatus.forEach(status -> joiner.add(status.name()));
            builder.addParameter("fulfillmentStatus", joiner.toString());
        }
        if (req.modifiedAfter != null) {
            builder.addParameter("modifiedAfter", ISO8601.format(req.modifiedAfter));
        }
        if (req.modifiedBefore != null) {
            builder.addParameter("modifiedBefore", ISO8601.format(req.modifiedBefore));
        }
        return () -> new Iterator<>() {
            GetOrdersResponse resp = httpGet(builder.toString(), GetOrdersResponse.class);
            Iterator<Order> orders = resp.result.iterator();

            @Override
            public boolean hasNext() {
                if (orders.hasNext()) {
                    return true;
                } else {
                    if (resp.pagination.hasNextPage) {
                        // Fetch the next page
                        resp = httpGet(resp.pagination.nextPageUrl, GetOrdersResponse.class);
                        orders = resp.result.iterator();
                        return orders.hasNext();
                    } else {
                        // No more pages
                        return false;
                    }
                }
            }

            @Override
            public Order next() {
                return orders.next();
            }
        };
    }

    private <T> T httpGet(String url, Class<T> responseClazz) {
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Authorization", "Bearer " + apiKey)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return mapper.readValue(response.body().bytes(), responseClazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private <T> T httpPost(String url, Object object, Map<String, String> params, Class<T> responseClazz) {
        byte[] bytes;
        try {
            bytes = mapper.writeValueAsBytes(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        RequestBody requestBody = RequestBody.create(bytes, MediaType.get("application/json"));
        Request.Builder builder = new Request.Builder()
                .url(url)
                .addHeader("Authorization", "Bearer " + apiKey)
                .post(requestBody);
        params.forEach(builder::addHeader);
        Request request = builder.build();
        try (Response response = client.newCall(request).execute()) {
            return mapper.readValue(response.body().bytes(), responseClazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String newIdempotencyKey() {
        return RandomStringUtils.random(64, true, true);
    }
}
