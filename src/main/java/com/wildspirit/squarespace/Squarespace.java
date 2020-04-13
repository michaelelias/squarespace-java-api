package com.wildspirit.squarespace;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wildspirit.squarespace.inventory.GetInventoryResponse;
import com.wildspirit.squarespace.inventory.InventoryItem;
import com.wildspirit.squarespace.orders.GetOrdersResponse;
import com.wildspirit.squarespace.orders.Order;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Iterator;

public final class Squarespace {
    private final OkHttpClient client = new OkHttpClient();
    private final String apiKey;
    private final ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

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

    public Iterable<Order> orders() {
        return () -> new Iterator<>() {
            GetOrdersResponse resp = httpGet("https://api.squarespace.com/1.0/commerce/orders", GetOrdersResponse.class);
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
}
