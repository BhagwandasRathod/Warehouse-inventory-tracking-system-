package com.bhagwandas;

public class Main {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();

        // listeners
        LoggerService logger = new LoggerService();
        AlertService alert = new AlertService(5); // threshold 5

        warehouse.addListener(logger);
        warehouse.addListener(alert);

        // add products
        Product p1 = new Product(101, "Laptop", 55000.0, 10);
        Product p2 = new Product(102, "Mouse", 500.0, 12);
        Product p3 = new Product(103, "Keyboard", 900.0, 3);

        warehouse.addProduct(p1);
        warehouse.addProduct(p2);
        warehouse.addProduct(p3);

        // actions
        warehouse.receiveShipment(103, 4);   // keyboard becomes 7
        warehouse.fulfillOrder(102, 8);      // mouse becomes 4 -> low
        warehouse.fulfillOrder(101, 6);      // laptop becomes 4 -> low
        warehouse.fulfillOrder(103, 2);      // keyboard becomes 5

        warehouse.displayAllProducts();
    }
}
