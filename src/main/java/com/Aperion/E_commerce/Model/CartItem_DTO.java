package com.Aperion.E_commerce.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class CartItem_DTO {
    private Long cartid;
    private String prodname;
    private int quantity;
    private double price;
    private double total;

    public CartItem_DTO(CartItem item){
        this.cartid=item.getCartid();
        this.prodname=item.getProduct().getProdname();
        this.quantity=item.getQuantity();
        this.price=item.getPrice();
        this.total=item.getPrice()*item.getQuantity();
    }
}
