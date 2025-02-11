package com.cosmetics.ecommerce.controller;

import com.cosmetics.ecommerce.model.dto.ProductDTO;
import com.cosmetics.ecommerce.repository.ProductRepository;
import com.cosmetics.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public ResponseEntity<Page<ProductDTO>> getAllProducts(Pageable pageable){
        Page<ProductDTO> products = service.getAllProducts(pageable);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<ProductDTO>> searchProductsByName(Pageable pageable, @RequestParam String name){
        Page<ProductDTO> products = service.findProductsByName(pageable, name);
        return ResponseEntity.ok(products);
    }

    @PostMapping()
    public ResponseEntity<ProductDTO> createProduct (@RequestBody ProductDTO product) {
        product = service.createProduct(product);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(product.id()).toUri();
        return ResponseEntity.ok(product);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Page<ProductDTO>> updateProduct(Pageable pageable, @PathVariable String name, @RequestBody ProductDTO product) {
        Page<ProductDTO> products = service.updateProduct(pageable, name, product);
        return ResponseEntity.ok(products);
    }

    @DeleteMapping(value = "/{name}")
    public ResponseEntity<Void> delete(@PathVariable String name){
        service.delete(name);
        return ResponseEntity.noContent().build();
    }
}
