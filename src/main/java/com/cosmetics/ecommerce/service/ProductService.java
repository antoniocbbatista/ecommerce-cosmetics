package com.cosmetics.ecommerce.service;

import com.cosmetics.ecommerce.model.dto.ProductDTO;
import com.cosmetics.ecommerce.model.entity.Product;
import com.cosmetics.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ProductService {


    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public Page<ProductDTO> getAllProducts(Pageable pageable){
        Page<Product> products = repository.findAll(pageable);
        return products.map(ProductDTO::new);
    }

    public Page<ProductDTO> findProductsByName(Pageable pageable, String name){
        Page<Product> products = repository.findByNameContaining(pageable, name);
        return products.map(ProductDTO::new);
    }

    private void convertToDTO (ProductDTO productDTO, Product entity) {
        entity.setName(productDTO.name());
        entity.setDescription(productDTO.description());
        entity.setPrice(productDTO.price());
        entity.setCategory(productDTO.category());
        entity.setImageUrl(productDTO.imageUrl());
        entity.setStock(productDTO.stock());
    }
}
