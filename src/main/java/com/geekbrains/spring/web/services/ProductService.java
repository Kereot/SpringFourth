package com.geekbrains.spring.web.services;

import com.geekbrains.spring.web.data.Product;
import com.geekbrains.spring.web.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {return productRepository.getAllProducts();}

    public void addProduct(Integer id, String name, Float cost) {productRepository.addProduct(id, name, cost);}

    public void deleteProduct(Integer id) {productRepository.deleteProduct(id);}

    public void changePrice(Integer id, Float cost) {
        Product product = productRepository.getById(id);
        product.setCost(cost);
    }

}
