package com.labo2ncapas.service.impl;

import com.labo2ncapas.domain.entity.Product;
import com.labo2ncapas.repository.ProductRepository;
import com.labo2ncapas.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public void createProduct(Product product) {
        productRepository.save(product);
    }
}
