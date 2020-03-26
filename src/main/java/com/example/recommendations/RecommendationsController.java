package com.example.recommendations;

import com.example.recommendations.domain.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.stream.Stream;

@RestController
@RequestMapping("/recommendations")
public class RecommendationsController {

    @GetMapping("related-to-product/{product-id}")
    Stream<Product> relatedProducts(@PathVariable("product-id") UUID productId){
        final var product = Product.lookupById(productId);

        final var productRecommender = new ClassicRecommendationsEngine();
        return productRecommender.productsRelatedTo(product);
    }

}
