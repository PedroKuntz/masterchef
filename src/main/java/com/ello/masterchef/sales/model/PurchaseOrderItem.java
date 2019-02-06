package com.ello.masterchef.sales.model;

import com.ello.masterchef.commons.model.Entity;
import com.ello.masterchef.commons.model.State;

import java.util.Optional;
import java.util.UUID;

public class PurchaseOrderItem implements Entity {

  private UUID purchaseOrderItemId;
  private UUID catalogItemId;
  private State<PurchaseOrderItem> purchaseOrderItemState;
  private PurchaseOrderItemType purchaseOrderItemType;
  private Optional<UUID> purchaseOrderItemParentId;
  private Double price;
  private int amount;
  private double kg;

  public PurchaseOrderItem() {}

  public UUID getPurchaseOrderItemId() {
    return purchaseOrderItemId;
  }

  public PurchaseOrderItem setPurchaseOrderItemId(UUID purchaseOrderItemId) {
    this.purchaseOrderItemId = purchaseOrderItemId;
    return this;
  }

  public UUID getCatalogItemId() {
    return catalogItemId;
  }

  public PurchaseOrderItem setCatalogItemId(UUID catalogItemId) {
    this.catalogItemId = catalogItemId;
    return this;
  }

  public State<PurchaseOrderItem> getPurchaseOrderItemState() {
    return purchaseOrderItemState;
  }

  public PurchaseOrderItem setPurchaseOrderItemState(State<PurchaseOrderItem> purchaseOrderItemStateState) {
    this.purchaseOrderItemState = purchaseOrderItemStateState;
    return this;
  }

  public PurchaseOrderItemType getPurchaseOrderItemType() {
    return purchaseOrderItemType;
  }

  public PurchaseOrderItem setPurchaseOrderItemType(PurchaseOrderItemType purchaseOrderItemType) {
    this.purchaseOrderItemType = purchaseOrderItemType;
    return this;
  }

  public Optional<UUID> getPurchaseOrderItemParentId() {
    return purchaseOrderItemParentId;
  }

  public PurchaseOrderItem setPurchaseOrderItemParentId(Optional<UUID> purchaseOrderItemParentId) {
    this.purchaseOrderItemParentId = purchaseOrderItemParentId;
    return this;
  }

  public Double getPrice() {
    return price;
  }

  public PurchaseOrderItem setPrice(Double price) {
    this.price = price;
    return this;
  }

  public int getAmount() {
    return amount;
  }

  public PurchaseOrderItem setAmount(int amount) {
    this.amount = amount;
    return this;
  }

  public double getKg() {
    return kg;
  }

  public PurchaseOrderItem setKg(double kg) {
    this.kg = kg;
    return this;
  }
}
