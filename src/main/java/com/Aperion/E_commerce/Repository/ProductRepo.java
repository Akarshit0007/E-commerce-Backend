package com.Aperion.E_commerce.Repository;

import com.Aperion.E_commerce.Model.Product;
import com.Aperion.E_commerce.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {
    List<Product> findByUser(Users user);

    Optional<Product>
    findByProdidAndUser(Long prodid, Users user);
}
