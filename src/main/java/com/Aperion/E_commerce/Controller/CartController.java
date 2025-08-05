package com.Aperion.E_commerce.Controller;

import com.Aperion.E_commerce.Model.CartItem_DTO;
import com.Aperion.E_commerce.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    CartService service;

    @PostMapping("/add/{prodid}")
public ResponseEntity<String> add(@PathVariable Long prodid, @RequestParam int quantity){
        service.addToCart(prodid,quantity);
        return ResponseEntity.ok("Product added Successfully to cart");
    }
    @GetMapping("/mycart")
    public ResponseEntity<List<CartItem_DTO>> myCart(){
        return ResponseEntity.ok(service.getMyCart());
    }

    @DeleteMapping("/remove/{cartItemId}")
    public ResponseEntity<String> remove(@PathVariable Long cartItemId){
        service.removeFromcart(cartItemId);
        return ResponseEntity.ok("Item Removed Successfully from cart");
    }
@DeleteMapping("/clear")
 public ResponseEntity<String> clear(){
        service.clearCart();
        return ResponseEntity.ok("cart Cleared");
 }
}
