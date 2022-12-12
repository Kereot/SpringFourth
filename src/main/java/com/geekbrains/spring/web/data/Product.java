package com.geekbrains.spring.web.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Product {
    Integer id;
    String name;
    Float cost;

    public Product(Integer id, String name, Float cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }
}
