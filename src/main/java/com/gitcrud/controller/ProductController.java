package com.gitcrud.controller;

import com.gitcrud.model.Product;
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
    @PostMapping("/create")
    public ResponseEntity<String> createProduct(@RequestBody Product product){
        productService.save(product);
        return ResponseEntity.ok().body("Create success");
    }

    @GetMapping("")
    public List<Product> findAllProduct(){
        return productService.findAll();
    }

    @GetMapping("/findByName")
    public ResponseEntity<List<Product>> searchByName(@RequestParam("name") String name) {
        List<Product> list = (List<Product>) productService.findProductByName(name);
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

    @GetMapping("/findById/{id}")
    private ResponseEntity<Product>findProductById(@PathVariable("id")Long id){
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
