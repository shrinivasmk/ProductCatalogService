package com.dev.ProductCatalogService.Model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Product extends BaseEntity{
    private Long id;
    private String name;
    private Double price;
    private String description;
    private String imageUrl;
    private Category category;
}
