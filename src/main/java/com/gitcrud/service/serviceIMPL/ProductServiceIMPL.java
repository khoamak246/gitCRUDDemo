package com.gitcrud.service.serviceIMPL;

import com.gitcrud.model.Product;
import com.gitcrud.repository.IProductRepository;
import com.gitcrud.service.IProductService;
import lombok.RequiredArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceIMPL implements IProductService {

    private final IProductRepository productRepository;
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        if (productRepository.findById(id).isPresent()) {
            return productRepository.findById(id).get();
        }
        return null;
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
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
