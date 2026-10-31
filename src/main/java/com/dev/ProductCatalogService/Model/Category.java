package com.dev.ProductCatalogService.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity 
public class Category extends BaseEntity{

    private Long id;

    private String name;

    private String description;

    @OneToMany(mappedBy = "category")
    List<Product> products;
}
