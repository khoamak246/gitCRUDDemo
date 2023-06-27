package com.gitcrud.service.design;

<<<<<<< HEAD
import org.springframework.stereotype.Service;

import java.util.List;


=======
import java.util.List;

>>>>>>> 5471135b704ecb955e1ab11d70be0a5d38573ca9
public interface IGeneric <T>{

    List<T> findAll();
    T findById(Long id);
    T save(T t);
    void deleteById(Long id);
    T searchByName(String name);
    T update(T t);


}
