package org.example;

import Domain.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductRepository {
    private static final Map<String, Product> product = new HashMap<>();

    Product product1 = new Product("","firstproduct",100,true);

}
