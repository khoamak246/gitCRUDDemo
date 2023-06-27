package com.gitcrud.controller;

import com.gitcrud.model.Product;
import com.gitcrud.service.serviceIMPL.ProductServiceIMPL;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {
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

}
