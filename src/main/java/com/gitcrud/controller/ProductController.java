package com.gitcrud.controller;

import com.gitcrud.model.Product;
import com.gitcrud.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {
    private  final IProductService productService;
    @GetMapping
    private ResponseEntity<Product>findProductById(@RequestParam("id")Long id){
        if (productService.findById(id)!=null){
        return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
    }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
