package com.Lins.Electronics_Store.controller;

import com.Lins.Electronics_Store.domain.Product;
import com.Lins.Electronics_Store.domain.ProductRepository;
import com.Lins.Electronics_Store.domain.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/electronics")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @GetMapping
    public ResponseEntity showAllProducts(){
        var allProducts = repository.findAll();
        return ResponseEntity.ok(allProducts);
    }

    @PostMapping
    public ResponseEntity createProduct(@RequestBody @Validated ProductRequest data){
        Product newProduct = new Product(data);
        repository.save(newProduct);
        return ResponseEntity.ok("Product created successfully");
    }

    @PutMapping
    public ResponseEntity changeProductById(@RequestBody @Validated ProductRequest data){
        Optional<Product> optionalProduct = repository.findById(data.id());
        if (optionalProduct.isPresent()){
            Product product = optionalProduct.get();
            product.setName(data.name());
            product.setPrice_in_cents(data.price_in_cents());
            repository.save(product);

            return ResponseEntity.ok("product updated successfully");
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable("id") String id){
        if (repository.existsById(id)){
            repository.deleteById(id);

            return ResponseEntity.ok("Deleted successfully");
        }else {
            return ResponseEntity.notFound().build();
        }
    }

}
