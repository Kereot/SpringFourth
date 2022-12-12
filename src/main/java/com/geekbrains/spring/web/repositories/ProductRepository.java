package com.geekbrains.spring.web.repositories;

import com.geekbrains.spring.web.data.Product;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;
    @Getter
    private final int MAX_PROD = 5;

    @PostConstruct
    public void init() {
        products = new ArrayList<>();
        for (int i = 0; i < MAX_PROD; i++) {
            products.add(new Product(
                    i + 1,
                    "Product #" + (i + 1),
                    (float) Math.round((Math.random() * (1000 - 10 + 1) + 10) * 100)/100));
        }
    }

    public Product getById(int id) {
        return products.stream().
                filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(products);
    }

    public void addProduct(Integer id, String title, Float cost) {
        products.add(new Product(id, title, cost));
    }

    public void deleteProduct(Integer id) {
        products.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .ifPresent(products::remove);
    }
}
