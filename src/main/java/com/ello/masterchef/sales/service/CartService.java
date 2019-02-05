package com.ello.masterchef.sales.service;

import com.ello.masterchef.sales.model.Cart;
import com.ello.masterchef.sales.model.PurchaseOrderItemDraft;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CartService {


    public Cart createCart(UUID purchaseOrderId) {
        return new Cart();
    }

    public void addCatalogItemInCart(UUID cartId, PurchaseOrderItemDraft purchaseOrderItemDraft) {

    }

    public Cart findCartById(UUID cartId) {
        return new Cart();
    }



}
