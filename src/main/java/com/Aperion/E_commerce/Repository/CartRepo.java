package com.Aperion.E_commerce.Repository;

import com.Aperion.E_commerce.Model.CartItem;
import com.Aperion.E_commerce.Model.Product;
import com.Aperion.E_commerce.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepo extends JpaRepository <CartItem,Long> {
    List<CartItem>findByUser(Users user);
    Optional<CartItem> findByUserAndProduct(Users user, Product products);
}
