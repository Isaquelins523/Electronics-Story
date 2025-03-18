package com.Lins.Electronics_Store.domain.product;

import com.Lins.Electronics_Store.requests.ProductRequest;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "products")
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private Integer price_in_cents;


    public Product(ProductRequest request) {
        this.id = request.id();
        this.name = request.name();
        this.price_in_cents = request.price_in_cents();
    }
}
