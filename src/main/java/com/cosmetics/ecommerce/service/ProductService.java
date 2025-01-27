package com.cosmetics.ecommerce.service;

import com.cosmetics.ecommerce.model.dto.CategoryDTO;
import com.cosmetics.ecommerce.model.dto.ProductDTO;
import com.cosmetics.ecommerce.model.entity.Category;
import com.cosmetics.ecommerce.model.entity.Product;
import com.cosmetics.ecommerce.repository.CategoryRepository;
import com.cosmetics.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class ProductService {


    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public Page<ProductDTO> getAllProducts(Pageable pageable){
        Page<Product> products = productRepository.findAll(pageable);
        return products.map(ProductDTO::new);
    }

    @Transactional
    public Page<ProductDTO> findProductsByName(Pageable pageable, String name){
        Page<Product> products = productRepository.findByNameContaining(pageable, name);
        return products.map(ProductDTO::new);
    }

    @Transactional
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = new Product();

        // Verifica se a categoria foi fornecida no DTO
        if (productDTO.category() == null || productDTO.category().name() == null) {
            throw new IllegalArgumentException("Digite o nome da categoria");
        }
        String categoryName = productDTO.category().name();
        Category category = categoryRepository.findByName(categoryName)
                .orElseGet(() -> {
                    Category newCategory = new Category();
                    newCategory.setName(categoryName);
                    return newCategory;
                });
        convertToProduct(productDTO, product);
        product.setCategory(category);
        product = productRepository.save(product);
        return new ProductDTO(product);
    }

    @Transactional
    public Page<ProductDTO> updateProduct(Pageable pageable, String name, ProductDTO productDTO){
        var products = productRepository.findByNameContaining(pageable, name);

        var updatedProducts = products.getContent().stream()
                .peek(p -> p.setName(productDTO.name()))
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        productRepository.saveAll(products.getContent());
        return new PageImpl<>(updatedProducts, pageable, products.getTotalElements());
    }

    @Transactional
    public void delete(String name){
        Product product = productRepository.findByName(name);
        if (product == null){
            throw new IllegalArgumentException("Produto não encontrado: " + name);
        }

        Category category = product.getCategory();
        if (category != null){
            category.removeProduct(product);
            if (category.getProducts().isEmpty()){
                categoryRepository.delete(category);
            }
        }
        productRepository.delete(product);
    }

    private ProductDTO convertToDTO(Product product) {
        return new ProductDTO(
                product.getId(), product.getName(), product.getDescription(),
                product.getPrice(), product.getImageUrl(),
                product.getStock(), product.getCategory() != null ? new CategoryDTO(product.getCategory()) : null
        );
    }

    private void convertToProduct(ProductDTO productDTO, Product entity) {
        entity.setName(productDTO.name());
        entity.setDescription(productDTO.description());
        entity.setPrice(productDTO.price());
        entity.setImageUrl(productDTO.imageUrl());
        entity.setStock(productDTO.stock());
    }
}
