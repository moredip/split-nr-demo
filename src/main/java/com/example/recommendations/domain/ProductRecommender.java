package com.example.recommendations.domain;

import com.example.recommendations.domain.Product;

import java.util.stream.Stream;

public interface ProductRecommender {
    Stream<Product> productsRelatedTo(Product product);
}
