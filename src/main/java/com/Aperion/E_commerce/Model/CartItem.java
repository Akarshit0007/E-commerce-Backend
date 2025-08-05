package com.Aperion.E_commerce.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long cartid;

    @ManyToOne
    @JoinColumn(name="user_id")
    private Users user;

   @ManyToOne
   @JoinColumn(name = "prodid")
    private Product product;

    private int quantity;
    private double price;
}
