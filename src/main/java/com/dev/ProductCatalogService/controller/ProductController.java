package com.dev.ProductCatalogService.controller;

import com.dev.ProductCatalogService.Model.Product;
import com.dev.ProductCatalogService.dto.CategoryDto;
import com.dev.ProductCatalogService.dto.ProductDto;
import com.dev.ProductCatalogService.service.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    List<Product> getAllProducts() {
        return List.of();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("id") Long id) {
        Product product = productService.getProductById(id);
        return new ResponseEntity<>(from(product), HttpStatus.OK);
    }

    private ProductDto from(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());

        CategoryDto category = new CategoryDto();
        category.setId(product.getCatagory().getId());
        category.setName(product.getCatagory().getName());
        category.setDescription(product.getCatagory().getDescription());

        productDto.setCategory(category);
        return productDto;
    }
}
