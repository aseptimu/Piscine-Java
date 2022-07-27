package edu.school21.models;

import java.util.Objects;

public class Product {
    Integer identifier;
    String name;
    Integer price;

    public Product(Integer identifier, String name, Integer price) {
        this.identifier = identifier;
        this.name = name;
        this.price = price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifier, name, price);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Product prod = (Product) obj;
        return Objects.equals(identifier, prod.identifier) && Objects.equals(name, prod.name) &&
                Objects.equals(price, prod.price);
    }

    @Override
    public String toString() {
        return "Product:\n" +
                "name: " + name + '\n' +
                "identifier: " + identifier + '\n' +
                "price: " + price;
    }

    public void setIdentifier(Integer identifier) {
        this.identifier = identifier;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getIdentifier() {
        return identifier;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }
}
