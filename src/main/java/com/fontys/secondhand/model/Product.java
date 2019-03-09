package com.fontys.secondhand.model;

import java.util.Objects;

public class Product {
    private String name;
    private String price;
    private String description;
    private String city;
    private String catogery;

    public Product(){}

    public Product(String name, String description,String price) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return name.equals(product.name) &&
                price.equals(product.price) &&
                description.equals(product.description) &&
                Objects.equals(city, product.city) &&
                Objects.equals(catogery, product.catogery);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, description, city, catogery);
    }
}
