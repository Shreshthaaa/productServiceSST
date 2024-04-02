package com.sst.productservicesst.controllers;

import com.sst.productservicesst.dtos.FakeStoreProductDto;
import com.sst.productservicesst.models.Product;
import com.sst.productservicesst.services.FakeStoreProductService;
import com.sst.productservicesst.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//this controller is capable to host HTTP APIs
//localhost:8080/products -> ProductController
@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        return productService.getProductById(id);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
}
