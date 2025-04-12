package com.lite.demo.domain.ports.out;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lite.demo.domain.model.Product;
@Repository
public interface ProductRepositoryPort extends JpaRepository<Product, Long> {
}