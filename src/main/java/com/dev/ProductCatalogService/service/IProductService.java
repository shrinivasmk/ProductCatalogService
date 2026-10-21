package com.dev.ProductCatalogService.service;

import com.dev.ProductCatalogService.Model.Product;

public interface IProductService {
    Product getProductById(Long id);
}
