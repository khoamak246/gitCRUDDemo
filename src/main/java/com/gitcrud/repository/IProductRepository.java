package com.gitcrud.repository;

import com.gitcrud.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IProductRepository extends JpaRepository<Product, Long> {
    @Query("Select p from Product  as p where p.name like concat('%',upper(?1) ,'%')")
    Iterable<Product> searchAllByName(@Param("name") String name);

}
