package com.evgkor.finalProject.service;

import com.evgkor.finalProject.bean.Product;
import com.evgkor.finalProject.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product findById(Long id) {
        return productRepository.findById(id).get();
    }

    public Page<Product> findAllProduct(String keyword, int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber - 1, 7);
        if (keyword != null) {
            return productRepository.findAll(keyword, pageable);
        }
        return productRepository.findAll(pageable);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }


}
