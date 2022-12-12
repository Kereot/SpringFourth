package com.geekbrains.spring.web.controllers;

import com.geekbrains.spring.web.data.Product;
import com.geekbrains.spring.web.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
    }

    @GetMapping("/add")
    public void addProduct(
            @RequestParam(required = false) Integer newProductId,
            @RequestParam(required = false) String newProductName,
            @RequestParam(required = false) Float newProductCost
    ) {
        if (newProductId != null && !newProductName.isBlank() && newProductCost != null) {
            productService.addProduct(newProductId, newProductName, newProductCost);
        }
    }

    @GetMapping("/change_cost")
    public void changePrice(@RequestParam Integer productId, @RequestParam(defaultValue = "0") Float cost) {
        productService.changePrice(productId, cost);
    }
}
