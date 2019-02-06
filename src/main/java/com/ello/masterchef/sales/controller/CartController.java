package com.ello.masterchef.sales.controller;

import com.ello.masterchef.sales.model.Cart;
import com.ello.masterchef.sales.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(value = "/cart")
public class CartController {

  @Autowired
  private CartService cartService;

  @PostMapping(value = "/{purchaseOrderId}")
  public ResponseEntity<?> createCart(@RequestParam("purchaseOrderId")UUID purchaseOrderId) {
    Cart cart = cartService.createCart(purchaseOrderId);
    return new ResponseEntity(cart, HttpStatus.CREATED);
  }



}
