package com.dev.ProductCatalogService.controller;

import com.dev.ProductCatalogService.Model.Product;
import com.dev.ProductCatalogService.dto.CategoryDto;
import com.dev.ProductCatalogService.dto.ProductDto;
import com.dev.ProductCatalogService.dto.ProductPitchDto;
import com.dev.ProductCatalogService.service.IProductService;
import com.dev.ProductCatalogService.service.PitchService;
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
    private PitchService pitchService;

    public ProductController(IProductService productService, PitchService pitchService) {
        this.productService = productService;
        this.pitchService = pitchService;
    }

    @GetMapping
    List<Product> getAllProducts() {
        return List.of();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("id") Long id) {
        if(id < 0){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Product product = productService.getProductById(id);
        if(product == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(from(product), HttpStatus.OK);
    }

    @GetMapping("/{id}/pitch")
    public ResponseEntity<ProductPitchDto> generatePitch(@PathVariable Long id) {
        if(id < 0){
            return  new ResponseEntity<ProductPitchDto>(HttpStatus.BAD_REQUEST);
        }

        Product product = productService.getProductById(id);
        if(product == null){
            return new ResponseEntity<ProductPitchDto>(HttpStatus.NOT_FOUND);
        }
        ProductPitchDto productPitchDto = new ProductPitchDto();
        productPitchDto.setId(product.getId());
        productPitchDto.setPitch(pitchService.generatePitch(product));
        return new ResponseEntity<>(productPitchDto, HttpStatus.OK);
    }

    private ProductDto from(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());

        CategoryDto category = new CategoryDto();
        category.setId(product.getCategory().getId());
        category.setName(product.getCategory().getName());
        category.setDescription(product.getCategory().getDescription());

        productDto.setCategory(category);
        return productDto;
    }
}
