package com.gitcrud.service;

import com.gitcrud.model.Product;
import com.gitcrud.service.design.IGeneric;
import org.springframework.stereotype.Service;

public interface IProductService extends IGeneric<Product> {
    Iterable<Product> findProductByName( String name);
}
