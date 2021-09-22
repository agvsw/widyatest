package com.agus.widyatest.service;


import com.agus.widyatest.dto.ProductDTO;
import com.agus.widyatest.entity.Product;
import com.agus.widyatest.middleware.ProductNotFoundException;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product addProduct(ProductDTO productDTO);
    Page<Product> getAllProduct(int page, int size);
    Optional<Product> getProductById(Long id) throws ProductNotFoundException;
    void deleteProductById(Long id) throws ProductNotFoundException;
}
