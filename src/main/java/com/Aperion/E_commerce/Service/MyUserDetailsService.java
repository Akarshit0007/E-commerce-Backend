package com.Aperion.E_commerce.Service;

import com.Aperion.E_commerce.Model.UserPrincipal;
import com.Aperion.E_commerce.Model.Users;
import com.Aperion.E_commerce.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo userrepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> user=userrepo.findByUsername(username);
        if(user.isEmpty()){
            System.out.println("User Not Found");
            throw new UsernameNotFoundException("User Not found");
        }
        return new UserPrincipal(user.orElse(null));
    }
}
