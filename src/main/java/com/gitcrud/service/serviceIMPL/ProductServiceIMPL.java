package com.gitcrud.service.serviceIMPL;

import com.gitcrud.model.Product;
import com.gitcrud.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceIMPL implements IProductService {
    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public Product findById(Long id) {
        return null;
    }

    @Override
    public Product save(Product product) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Product searchByName(String name) {
        return null;
    }

    @Override
    public Product update(Product product) {
        return null;
    }
}
