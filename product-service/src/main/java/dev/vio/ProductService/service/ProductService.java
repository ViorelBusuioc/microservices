package dev.vio.ProductService.service;

import dev.vio.ProductService.dto.ProductRequest;
import dev.vio.ProductService.dto.ProductResponse;

import java.util.List;

public interface ProductService {

    public void createProduct(ProductRequest productRequest);
    public List<ProductResponse> getAllProducts();
}
