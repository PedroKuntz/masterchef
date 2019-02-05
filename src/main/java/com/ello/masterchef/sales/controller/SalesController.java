package com.ello.masterchef.sales.controller;

import com.ello.masterchef.sales.service.CartService;
import com.ello.masterchef.sales.model.PurchaseOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/sales")
public class SalesController {

    @Autowired
    private CartService cartService;


    @PostMapping
    public ResponseEntity<?> createPurchaseOrder(@RequestBody PurchaseOrder purchaseOrder) {
        return new ResponseEntity(cartService.createPurchaseOrder(purchaseOrder), HttpStatus.CREATED);
    }

    @PutMapping(value = "/send/{cart_id}")
    public ResponseEntity<?> sendCartId(@RequestParam("cart_id")UUID cartId) {
        this.cartService.sendPurchaseOrder(cartId);
        return new ResponseEntity(HttpStatus.CREATED);
    }

}
