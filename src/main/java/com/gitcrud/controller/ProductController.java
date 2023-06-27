package com.gitcrud.controller;

import com.gitcrud.model.Product;

import com.gitcrud.service.serviceIMPL.ProductServiceIMPL;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gitcrud.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final IProductService productService;

    @GetMapping("")
    public List<Product> findAllProduct(){
        return productService.findAll();
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Product> editProduct(@PathVariable Long id, @RequestBody Product product) {
        Product pro = productService.findById(id);
        if (pro == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        product.setId(pro.getId());
        return new ResponseEntity<>(productService.update(product), HttpStatus.OK);
    }


    @GetMapping
    private ResponseEntity<Product>findProductById(@RequestParam("id")Long id){
        if (productService.findById(id)!=null){
            return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        Product product = productService.findById(id);
        if (product == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        productService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
