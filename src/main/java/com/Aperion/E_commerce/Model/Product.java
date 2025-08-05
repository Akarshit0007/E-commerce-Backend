package com.Aperion.E_commerce.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prodid;
    @NotBlank(message = "Name cannot be blank")
    private String prodname;
     @Min(value = 1,message = "Price must be at least 1")
    private double prodprice;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

}
