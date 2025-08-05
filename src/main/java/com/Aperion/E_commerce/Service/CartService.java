package com.Aperion.E_commerce.Service;

import com.Aperion.E_commerce.Model.CartItem;
import com.Aperion.E_commerce.Model.CartItem_DTO;
import com.Aperion.E_commerce.Model.Product;
import com.Aperion.E_commerce.Model.Users;
import com.Aperion.E_commerce.Repository.CartRepo;
import com.Aperion.E_commerce.Repository.ProductRepo;
import com.Aperion.E_commerce.Repository.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.security.Security;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CartService {
   @Autowired
    CartRepo cartRepo;
   @Autowired
    UserRepo userRepo;
   @Autowired
    ProductRepo productRepo;

   public Users getCurrentUser(){
       String username=
               SecurityContextHolder.getContext().getAuthentication().getName();
       return
               userRepo.findByUsername(username)
                       .orElseThrow(()-> new UsernameNotFoundException("User Not Found"));

   }

@Transactional
    public void addToCart(Long prodid, int quantity) {
       Users user=getCurrentUser();
       if(user==null){
           throw new RuntimeException("User Not Found");
       }
        Product product=
                productRepo.findById(prodid)
                        .orElseThrow(()-> new RuntimeException("Product not found"));
        Optional<CartItem> existing=
                cartRepo.findByUserAndProduct(user,product);
        if (existing.isPresent()){
            CartItem item=existing.get();
            item.setQuantity(item.getQuantity()+quantity);
            cartRepo.save(item);
        }else{
            CartItem item=new CartItem();
            item.setUser(user);
            item.setProduct(product);
            item.setQuantity(quantity);
            item.setPrice(product.getProdprice());
           cartRepo.save(item);
        }

 }

    public List<CartItem_DTO> getMyCart() {
       Users user=getCurrentUser();
       return cartRepo.findByUser(user)
               .stream()
               .map(CartItem_DTO::new)
               .collect(Collectors.toList());
    }

    public void removeFromcart(Long cartItemId) {
       cartRepo.deleteById(cartItemId);
    }

    public void clearCart() {
       Users user=getCurrentUser();
       List<CartItem> items=
               cartRepo.findByUser(user);
       cartRepo.deleteAll(items);
    }
}
