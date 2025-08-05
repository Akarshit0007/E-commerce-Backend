package com.Aperion.E_commerce.Service;

import com.Aperion.E_commerce.Model.Product;
import com.Aperion.E_commerce.Model.Product_DTO;
import com.Aperion.E_commerce.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;

    public List<Product_DTO> allproducts() {
        List<Product> products=
        productRepo.findAll();
        return products.stream()
                .map(p-> new Product_DTO(
                        p.getProdid(),
                        p.getProdname(),
                        p.getProdprice(),
                        p.getUser().getUsername()
                ))
                .collect(Collectors.toList());
    }
}
