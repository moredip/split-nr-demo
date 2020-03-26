package com.example.recommendations.domain;

import com.github.javafaker.Faker;

import java.util.UUID;

public class Product {
    final UUID id;
    final String name;

    public Product(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static Product lookupById(UUID id){
        return generateFakeProduct();
    }

    public static Product generateFakeProduct(){
        return new Product(
                UUID.randomUUID(),
                Faker.instance().commerce().productName()
        );
    }
}
