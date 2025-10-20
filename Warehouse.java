package com.bhagwandas;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {
    private List<Product> products;
    private List<StockEventListener> listeners;

    public Warehouse() {
        products = new ArrayList<>();
        listeners = new ArrayList<>();
    }

    public void addListener(StockEventListener listener) {
        listeners.add(listener);
    }

    // Add product
    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Product added: " + product.getName() + " (ID: " + product.getId() + ")");
    }

    // Receive shipment
    public void receiveShipment(int productId, int qty) {
        Product p = findProduct(productId);
        if (p == null) {
            System.out.println("Product ID " + productId + " not found.");
            return;
        }
        p.setQuantity(p.getQuantity() + qty);
        System.out.println("Shipment received for " + p.getName() + ": +" + qty + " => " + p.getQuantity());
        notifyStockReceived(p, qty);
    }

    // Fulfill order
    public void fulfillOrder(int productId, int qty) {
        Product p = findProduct(productId);
        if (p == null) {
            System.out.println("Product ID " + productId + " not found.");
            return;
        }
        if (p.getQuantity() >= qty) {
            p.setQuantity(p.getQuantity() - qty);
            System.out.println("Order fulfilled for " + p.getName() + ": -" + qty + " => " + p.getQuantity());
            notifyOrderFulfilled(p, qty);
            notifyLowStockIfNeeded(p);
        } else {
            System.out.println("Insufficient stock for " + p.getName() + ". Available: " + p.getQuantity());
        }
    }

    private Product findProduct(int productId) {
        for (Product p : products) {
            if (p.getId() == productId) return p;
        }
        return null;
    }

    private void notifyStockReceived(Product p, int qty) {
        for (StockEventListener l : listeners) {
            l.onStockReceived(p, qty);
        }
    }

    private void notifyOrderFulfilled(Product p, int qty) {
        for (StockEventListener l : listeners) {
            l.onOrderFulfilled(p, qty);
        }
    }

    private void notifyLowStockIfNeeded(Product p) {
        for (StockEventListener l : listeners) {
            // Only AlertService reacts based on its threshold; others can ignore.
            l.onLowStock(p);
        }
    }

    public void displayAllProducts() {
        System.out.println("\\n=== Inventory ===");
        if (products.isEmpty()) {
            System.out.println("No products in inventory.");
            return;
        }
        for (Product p : products) {
            p.displayProduct();
            System.out.println("------------------");
        }
    }
}
