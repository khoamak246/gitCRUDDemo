package com.gitcrud.controller;

import com.gitcrud.model.Product;
import com.gitcrud.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final IProductService productService;
    @PostMapping("/create")
    public ResponseEntity<String> createProduct(@RequestBody Product product){
        productService.save(product);
        return ResponseEntity.ok().body("Create success");
    }

}
