package com.evgkor.finalProject.repository;

import com.evgkor.finalProject.bean.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends PagingAndSortingRepository<Product,Long> {
    @Query("SELECT p FROM Product p WHERE "
            +"CONCAT(p.id,p.name,p.category,p.price,p.description,p.discount)"
            + "LIKE %?1%" )
    Page<Product> findAll(String keyword, Pageable pageable);
}
