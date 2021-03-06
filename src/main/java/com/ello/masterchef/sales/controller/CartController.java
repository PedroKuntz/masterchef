package com.ello.masterchef.sales.controller;

import com.ello.masterchef.sales.model.Cart;
import com.ello.masterchef.sales.model.PurchaseOrderItemDraft;
import com.ello.masterchef.sales.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/cart")
public class CartController {

  @Autowired
  private CartService cartService;

  @PostMapping(value = "/{purchaseOrderId}")
  public ResponseEntity<?> createCart(@PathVariable("purchaseOrderId")UUID purchaseOrderId) {
    Cart cart = cartService.createCart(purchaseOrderId);
    return new ResponseEntity(cart, HttpStatus.CREATED);
  }

  @GetMapping(value = "/{cartId}")
  public ResponseEntity<?> findByCartId(@PathVariable("cartId") UUID cartId) {
    Optional<Cart> cart = cartService.findCartById(cartId);
    return new ResponseEntity(cart,HttpStatus.OK);
  }


  @PutMapping(value = "/{cartId}/addItem")
  public ResponseEntity<?> addItem(@PathVariable("cartId") UUID cartId, @RequestBody PurchaseOrderItemDraft purchaseOrderItemDraft) {
    cartService.addCatalogItemInCart(cartId, purchaseOrderItemDraft);
    return new ResponseEntity(HttpStatus.OK);
  }

}
