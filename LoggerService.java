package com.bhagwandas;

public class LoggerService implements StockEventListener {
    @Override
    public void onStockReceived(Product product, int receivedQty) {
        System.out.println("LOG: Received " + receivedQty + " units of " + product.getName()
                + " (ID: " + product.getId() + "). New qty: " + product.getQuantity());
    }

    @Override
    public void onOrderFulfilled(Product product, int orderedQty) {
        System.out.println("LOG: Fulfilled order of " + orderedQty + " units for " + product.getName()
                + " (ID: " + product.getId() + "). Remaining qty: " + product.getQuantity());
    }

    @Override
    public void onLowStock(Product product) {
        System.out.println("LOG: Low stock event for " + product.getName() + " (ID: " + product.getId() + ").");
    }
}
