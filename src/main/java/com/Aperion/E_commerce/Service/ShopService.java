package com.Aperion.E_commerce.Service;

import com.Aperion.E_commerce.Model.Product;
import com.Aperion.E_commerce.Model.Product_DTO;
import com.Aperion.E_commerce.Model.Users;
import com.Aperion.E_commerce.Repository.ProductRepo;
import com.Aperion.E_commerce.Repository.UserRepo;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.stream.Collectors;

@Service
public class ShopService {
    private final ProductRepo productRepo;

    private final UserRepo userRepo;


   public ShopService(ProductRepo productRepo,UserRepo userRepo){
       this.productRepo=productRepo;
       this.userRepo=userRepo;
   }

   public String getCurrentUsername(){
       Authentication auth=
               SecurityContextHolder.getContext().getAuthentication();
       return auth.getName();
   }
   public Users getCurrentUser(){
       String username=getCurrentUsername();

               return
               userRepo.findByUsername(username)
                       .orElseThrow(()-> new RuntimeException("User Not Found Exception"));



   }





    public Product_DTO createproduct(Product product) {

        String username= getCurrentUsername();

        Users user= getCurrentUser();




        product.setUser(user);
        Product saved=
                productRepo.save(product);
        return new Product_DTO(
                saved.getProdid(),
                        saved.getProdname(),
                saved.getProdprice(),
        saved.getUser().getUsername());
    }




    public List<Product_DTO> getMyProducts() {

        String username= getCurrentUsername();

        Users user= getCurrentUser();
                       List<Product> products=
                               productRepo.findByUser(user);
                       return products.stream()
                               .map(p-> new Product_DTO(
                                       p.getProdid(),
                                       p.getProdname(),
                                       p.getProdprice(),
                                       p.getUser().getUsername()
                               ))
                               .collect(Collectors.toList());

    }



    public void deleteMyProduct(Long prodid) {

        String username= getCurrentUsername();

        Users user= getCurrentUser();
       Product product=
               productRepo.findByProdidAndUser(prodid,user)
                       .orElseThrow(()-> new RuntimeException("Product Not found or not owned By User"));

       productRepo.delete(product);


    }


    public void updateproduct(Long prodid, Product updatedproduct) {

        String username= getCurrentUsername();

        Users user= getCurrentUser();
        Product existingproduct=
                productRepo.findByProdidAndUser(prodid,user)
                        .orElseThrow(()->new RuntimeException("Product Not Found Or Owned By user"));

        existingproduct.setProdname(updatedproduct.getProdname());
        existingproduct.setProdprice(updatedproduct.getProdprice());
        productRepo.save(existingproduct);

         }
}
