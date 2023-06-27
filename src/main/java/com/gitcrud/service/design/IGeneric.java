package com.gitcrud.service.design;

import java.util.List;

public interface IGeneric <T>{

    List<T> findAll();
    T findById(Long id);
    T save(T t);
    void deleteById(Long id);
    T searchByName(String name);
    T update(T t);


}
