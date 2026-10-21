package com.dev.ProductCatalogService.controller;


import com.dev.ProductCatalogService.Model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    //Api to get all products
    @GetMapping("/products")
    List<Product> getAllProducts(){
        return List.of();
    }
}