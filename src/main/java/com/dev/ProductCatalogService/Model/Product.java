package com.dev.ProductCatalogService.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@Entity
public class Product extends BaseEntity{
    private Long id;

    private String name;

    @Column(precision = 19,scale = 3)
    private BigDecimal price;

    private String description;

    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
