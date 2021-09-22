package com.agus.widyatest.controller;

import com.agus.widyatest.dto.CommonResponse;
import com.agus.widyatest.dto.ProductDTO;
import com.agus.widyatest.entity.Product;
import com.agus.widyatest.middleware.ProductNotFoundException;
import com.agus.widyatest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@EnableWebSecurity
@EnableAuthorizationServer
@EnableResourceServer
public class ProductController {

    private static final String ROLE_ADMIN = "ROLE_ADMIN";
    private static final String ROLE_USER = "ROLE_USER";

    @Autowired
    private ProductService productService;

    @Secured({ROLE_USER, ROLE_ADMIN})
    @GetMapping(path = "/products")
    public CommonResponse<Page<Product>> getAllProduct(@RequestParam int page,
                                                        @RequestParam int size){
        CommonResponse<Page<Product>> response = new CommonResponse<>();
        response.setData(productService.getAllProduct(page, size));
        return response;
    }


    @Secured({ROLE_USER, ROLE_ADMIN})
    @GetMapping(path = "/product")
    public CommonResponse<?> getProductById(@RequestParam Long id) throws ProductNotFoundException {
        CommonResponse<Optional<Product>> response = new CommonResponse<>();
        response.setData(productService.getProductById(id));
        return response;
    }

    @Secured({ROLE_ADMIN})
    @PostMapping(path = "/product")
    public CommonResponse<?> addProduct(@RequestBody ProductDTO productDTO) {
        CommonResponse<Product> response = new CommonResponse<>();
        response.setData(productService.addProduct(productDTO));
        return response;
    }

    @Secured({ROLE_ADMIN})
    @DeleteMapping(path = "/product")
    public CommonResponse<?> deleteProductById(@RequestParam Long id) throws ProductNotFoundException {
        CommonResponse<Product> response = new CommonResponse<>();
        productService.deleteProductById(id);
        response.setResponseMessage("Data Successfully deleted");
        return response;
    }

    @Secured({ROLE_ADMIN})
    @PutMapping(path = "/product")
    public CommonResponse<?> updateProduct(@RequestBody ProductDTO productDTO) {
        CommonResponse<Product> response = new CommonResponse<>();
        response.setData(productService.addProduct(productDTO));
        return response;
    }
}
