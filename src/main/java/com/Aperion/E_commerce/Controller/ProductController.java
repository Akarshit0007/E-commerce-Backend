package com.Aperion.E_commerce.Controller;

import com.Aperion.E_commerce.Model.Product_DTO;
import com.Aperion.E_commerce.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/home")
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping("/products")
    public List<Product_DTO> allproducts(){
        return service.allproducts();
    }
}
