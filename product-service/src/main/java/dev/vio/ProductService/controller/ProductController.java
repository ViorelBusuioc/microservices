package dev.vio.ProductService.controller;

import dev.vio.ProductService.dto.ProductRequest;
import dev.vio.ProductService.dto.ProductResponse;
import dev.vio.ProductService.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/products")
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest) {

        productService.createProduct(productRequest);
    }

    @GetMapping("/products")
    public List<ProductResponse> getAllProducts() {

        return productService.getAllProducts();
    }
}
