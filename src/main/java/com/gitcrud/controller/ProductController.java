package com.gitcrud.controller;

import com.gitcrud.model.Product;
import com.gitcrud.service.IProductService;
import com.gitcrud.service.serviceIMPL.ProductServiceIMPL;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @Autowired
    private ProductServiceIMPL productServiceIMPL;
    @GetMapping("/findByName")
    public ResponseEntity<List<Product>> searchByName(@RequestParam("name") String name) {
        List<Product> list = (List<Product>) productServiceIMPL.findProductByName(name);
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
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
}
