package com.bhagwandas;

public interface StockEventListener {
    void onStockReceived(Product product, int receivedQty);
    void onOrderFulfilled(Product product, int orderedQty);
    void onLowStock(Product product);
}
