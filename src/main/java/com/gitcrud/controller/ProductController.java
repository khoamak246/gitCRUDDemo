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

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {
  private   ProductServiceIMPL productServiceIMPL;
@DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
    Product product = productServiceIMPL.findById(id);
    if (product == null){
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    productServiceIMPL.deleteById(id);
    return new ResponseEntity<>(HttpStatus.OK);
}

}
