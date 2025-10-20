package com.bhagwandas;

public class AlertService implements StockEventListener {

    private int lowStockThreshold;

    public AlertService(int lowStockThreshold) {
        this.lowStockThreshold = lowStockThreshold;
    }

    @Override
    public void onStockReceived(Product product, int receivedQty) {
        // no-op for receive
    }

    @Override
    public void onOrderFulfilled(Product product, int orderedQty) {
        if (product.getQuantity() < lowStockThreshold) {
            onLowStock(product);
        }
    }

    @Override
    public void onLowStock(Product product) {
        System.out.println("⚠️ ALERT: Low stock for " + product.getName() +
                " (ID: " + product.getId() + "), Quantity: " + product.getQuantity());
    }

    public int getLowStockThreshold() {
        return lowStockThreshold;
    }
}
