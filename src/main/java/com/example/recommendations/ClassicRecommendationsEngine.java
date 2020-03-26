package com.example.recommendations;

import com.example.recommendations.domain.Product;
import com.example.recommendations.domain.ProductRecommender;

import java.util.stream.Stream;

import static com.example.recommendations.domain.Product.generateFakeProduct;


public class ClassicRecommendationsEngine implements ProductRecommender {
    @Override
    public Stream<Product> productsRelatedTo(Product product){
        return Stream.of(
                generateFakeProduct()
        );
    }
}