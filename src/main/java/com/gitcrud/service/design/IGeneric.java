package com.gitcrud.service.design;

<<<<<<< HEAD
import org.springframework.stereotype.Service;

import java.util.List;


=======
import java.util.List;

>>>>>>> 1cbe30bb7e9e72b2bb52ea065165b3f49d4196dd
public interface IGeneric <T>{

    List<T> findAll();
    T findById(Long id);
    T save(T t);
    void deleteById(Long id);
    T searchByName(String name);
    T update(T t);


}
