package com.example.recommendations;

import com.example.recommendations.domain.Product;
import com.example.recommendations.domain.ProductRecommender;

import java.util.stream.Stream;

import static com.example.recommendations.domain.Product.generateFakeProduct;


public class ClassicRecommendationsEngine implements ProductRecommender {
    @Override
    public Stream<Product> productsRelatedTo(Product product){
        sleep(100); //simulate a short computation delay
        return Stream.generate(Product::generateFakeProduct).limit(10);
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis); //simulate an expensive computation delay
        } catch (InterruptedException e) {
        }
    }
}