package com.ello.masterchef.sales.service;

import com.ello.masterchef.sales.model.Cart;
import com.ello.masterchef.sales.model.PurchaseOrderItemDraft;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IList;
import com.hazelcast.core.IMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CartService {

  private final HazelcastInstance cartInstance;

  @Autowired
  public CartService(@Qualifier("shoppingCart") HazelcastInstance cartInstance) {
    this.cartInstance = cartInstance;
  }

  public Cart createCart(UUID purchaseOrderId) {
    IMap<UUID, Cart> cartInMemory = cartInstance.getMap("cart");
    Cart cart = buildCart(purchaseOrderId);
    cartInMemory.put(purchaseOrderId,cart);
    return cart;
  }

  public void addCatalogItemInCart(UUID cartId, PurchaseOrderItemDraft purchaseOrderItemDraft) {
    IMap<UUID, Cart> cartInMemory = cartInstance.getMap("cart");
    Cart cart = cartInMemory.get(cartId);
    cart.setPurchaseOrderItemDraft(purchaseOrderItemDraft);
    cartInMemory.set(cartId,cart);
  }

  public Cart findCartById(UUID cartId) {
    IMap<UUID, Cart> cartInMemory = cartInstance.getMap("cart");
    return cartInMemory.get(cartId);
  }

  private Cart buildCart(UUID purchaseOrderId) {
    Cart cart = new Cart();
    cart.setCartId(purchaseOrderId);
    cart.setPurchaseOrderId(purchaseOrderId);
    return cart;
  }


}
