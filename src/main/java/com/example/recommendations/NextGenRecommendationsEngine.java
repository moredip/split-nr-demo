package com.example.recommendations;

import com.example.recommendations.domain.Product;
import com.example.recommendations.domain.ProductRecommender;

import java.util.stream.Stream;

public class NextGenRecommendationsEngine implements ProductRecommender {
    @Override
    public Stream<Product> productsRelatedTo(Product product) {
        return Stream.generate(Product::generateFakeProduct).limit(20);
    }
}
