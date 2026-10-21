package com.dev.ProductCatalogService.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
    private String name;
    private Double price;
    private String description;
    private CategoryDto category;
}
