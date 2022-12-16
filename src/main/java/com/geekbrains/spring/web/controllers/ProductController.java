package com.geekbrains.spring.web.controllers;

import com.geekbrains.spring.web.data.Product;
import com.geekbrains.spring.web.repositories.ProductDao;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductDao productDao;

    public ProductController(ProductDao productDao) {
        this.productDao = productDao;
    }

    @GetMapping("")
    public List<Product> getAllProducts() {
        return productDao.findAll();
    }

    @GetMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Integer id) {
        productDao.deleteById(id);
    }

    @GetMapping("/add")
    public void addProduct(
            @RequestParam(required = false) String newProductName,
            @RequestParam(required = false) Float newProductCost
    ) {
        if (!newProductName.isBlank() && newProductCost != null) {
            productDao.addProduct(new Product(newProductName, newProductCost));
        }
    }

    @GetMapping("/change_cost")
    public void changePrice(@RequestParam Integer productId, @RequestParam(defaultValue = "0") Float cost) {
        productDao.updatePrice(productId, cost);
    }
}
