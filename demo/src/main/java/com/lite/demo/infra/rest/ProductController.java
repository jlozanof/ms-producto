package com.lite.demo.infra.rest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.lite.demo.domain.model.Product;
import com.lite.demo.domain.ports.out.ProductRepositoryPort;
import com.lite.demo.infra.exception.ProductNotFoundException;


@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepositoryPort productRepository;

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productRepository.findById(id).orElseThrow(() -> new
        ProductNotFoundException(id));
    }


    @PostMapping("/create")
    public Product createProduct(@RequestBody Product product) {
    return productRepository.save(product);
    }
        
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
    Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
        product.setName(productDetails.getName());
        product.setPrice(productDetails.getPrice());
        product.setQuantity(productDetails.getQuantity());
        return productRepository.save(product);
       
    }    

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new
        ProductNotFoundException(id));
        productRepository.delete(product);
        return "Product " + id + " deleted successfully!";
        }


    
}
