package com.ello.masterchef.sales.model;

import com.ello.masterchef.integration.Entity;

import java.util.List;
import java.util.UUID;

public class Cart implements Entity {

  private UUID cartId;
  private UUID purchaseOrderId;
  private List<PurchaseOrderItemDraft> purchaseOrderItemDraftList;

  public Cart() {
  }

  public UUID getCartId() {
    return cartId;
  }

  public void setCartId(UUID cartId) {
    this.cartId = cartId;
  }

  public UUID getPurchaseOrderId() {
    return purchaseOrderId;
  }

  public void setPurchaseOrderId(UUID purchaseOrderId) {
    this.purchaseOrderId = purchaseOrderId;
  }

  public List<PurchaseOrderItemDraft> getPurchaseOrderItemDraftList() {
    return purchaseOrderItemDraftList;
  }

  public void setPurchaseOrderItemDraftList(List<PurchaseOrderItemDraft> purchaseOrderItemDraftList) {
    this.purchaseOrderItemDraftList = purchaseOrderItemDraftList;
  }

  public void setPurchaseOrderItemDraft(PurchaseOrderItemDraft purchaseOrderItemDraft) {
    this.purchaseOrderItemDraftList.add(purchaseOrderItemDraft);
  }
}
