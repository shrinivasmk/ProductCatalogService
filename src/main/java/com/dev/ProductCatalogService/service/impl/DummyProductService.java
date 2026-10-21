package com.dev.ProductCatalogService.service.impl;

import com.dev.ProductCatalogService.Model.Product;
import com.dev.ProductCatalogService.service.IProductService;
import org.springframework.boot.restclient.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DummyProductService implements IProductService {

    private RestTemplate restTemplate;

    public DummyProductService(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    @Override
    public Product getProductById(Long id) {
        return null;
    }
}
