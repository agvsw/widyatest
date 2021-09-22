package com.agus.widyatest.service.impl;

import com.agus.widyatest.dto.ProductDTO;
import com.agus.widyatest.entity.Product;
import com.agus.widyatest.middleware.ProductNotFoundException;
import com.agus.widyatest.repository.ProductRepository;
import com.agus.widyatest.service.ProductService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImplement implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product addProduct(ProductDTO productDTO) {
        Product product = new ObjectMapper().convertValue(productDTO, Product.class);
        return productRepository.save(product);
    }

    @Override
    public Page<Product> getAllProduct(int page, int size) {
        Pageable pagination = PageRequest.of(page, size);
        return productRepository.findAll(pagination);
    }

    @Override
    public Optional<Product> getProductById(Long id) throws ProductNotFoundException {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()){
            return product;
        }
        throw new ProductNotFoundException(41, String.format("Product with id %d not found", id));
    }

    @Override
    public void deleteProductById(Long id) throws ProductNotFoundException {
        try {
            productRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new ProductNotFoundException(40, String.format("Product id %d not found", id));
        }

    }
}
