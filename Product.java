package com.bhagwandas;

public class Product {
    private int id;
    private String name;
    private double price;
    private int quantity;

    public Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public void displayProduct() {
        System.out.println("Product ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
    }
}
