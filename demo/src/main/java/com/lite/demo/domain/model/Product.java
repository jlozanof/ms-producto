package com.lite.demo.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
public  class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private Long id;
    private String name;
    private Double price;
    private Integer quantity;
  
 public Product() {}
}

