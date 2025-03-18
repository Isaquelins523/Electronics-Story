package com.Lins.Electronics_Store.repositories;

import com.Lins.Electronics_Store.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
