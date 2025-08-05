package com.Aperion.E_commerce.Repository;

import com.Aperion.E_commerce.Model.Product;
import com.Aperion.E_commerce.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<Users,Long> {
    Optional<Users> findByUsername(String username);


}
