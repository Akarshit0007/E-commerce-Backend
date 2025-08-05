package com.Aperion.E_commerce.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product_DTO  {
    private Long prodid;
    private String prodname;
    private double prodprice;
    private String username;


    public Product_DTO(Long prodid, String prodname, double prodprice, Object o, String username) {
    }
}
