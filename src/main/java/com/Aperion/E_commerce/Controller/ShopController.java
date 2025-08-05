package com.Aperion.E_commerce.Controller;

import com.Aperion.E_commerce.Model.Product;
import com.Aperion.E_commerce.Model.Product_DTO;
import com.Aperion.E_commerce.Service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/myshop")
public class ShopController {


    @Autowired
    ShopService service;

    @PostMapping("/add")
    public Product_DTO createproduct(@RequestBody Product product){
        return service.createproduct(product);

    }

    @GetMapping("/myproducts")
    public List<Product_DTO> getMyProducts(){
        return service.getMyProducts();
    }

    @DeleteMapping("/delete/{prodid}")
    public void deleteMyProduct(@PathVariable Long prodid){
         service.deleteMyProduct(prodid);

    }
    @PutMapping("/update/{prodid}")
   public ResponseEntity <?> updateproduct(@PathVariable Long prodid,@RequestBody Product updatedproduct){
        service.updateproduct(prodid,updatedproduct);
        return ResponseEntity.ok("Product Updated");
    }


}
