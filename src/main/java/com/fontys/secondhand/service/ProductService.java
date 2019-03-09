package com.fontys.secondhand.service;

import com.fontys.secondhand.model.Product;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class ProductService {

    List<Product> products = new ArrayList<>();

    public ProductService() {
        products.add(new Product("IphoneX", "128 GB, 2018", "900 $"));
        products.add(new Product("S9", "256 GB , White , 2019", "370 $"));
        products.add(new Product("Iphone5", "128 GB, 2018", "479 $"));
        products.add(new Product("Pixel", "64 GB, 2018", "320 $"));
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public boolean sellProduct(Product product) {
        products.add(product);
        return true;
    }

    public boolean buyProduct(Product product) {
        System.out.println(products.size());
        try{
            return products.remove(product);
        }finally {
            System.out.println(products.size());
        }

    }
}
