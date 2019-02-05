package com.ello.masterchef.sales.model;

import com.ello.masterchef.catalog.model.SalesModel;
import com.ello.masterchef.integration.Entity;
import com.ello.masterchef.integration.State;

import java.util.List;
import java.util.UUID;

public class PurchaseOrder implements Entity {

  private UUID purchaseId;
  private UUID employeeId;
  private List<PurchaseOrderItem> purchaseOrderItems;
  private PurchaseOrderType purchaseOrderType;
  private SalesModel salesModel;
  private State<PurchaseOrder> purchaseOrderState;

  public PurchaseOrder() {}

  public UUID getPurchaseId() {
    return purchaseId;
  }

  public PurchaseOrder setPurchaseId(UUID purchaseId) {
    this.purchaseId = purchaseId;
    return this;
  }

  public UUID getEmployee() {
    return employeeId;
  }

  public PurchaseOrder setEmployee(UUID employeeId) {
    this.employeeId = employeeId;
    return this;
  }

  public List<PurchaseOrderItem> getPurchaseOrderItems() {
    return purchaseOrderItems;
  }

  public PurchaseOrder setPurchaseOrderItems(List<PurchaseOrderItem> purchaseOrderItems) {
    this.purchaseOrderItems = purchaseOrderItems;
    return this;
  }

  public PurchaseOrderType getPurchaseOrderType() {
    return purchaseOrderType;
  }

  public PurchaseOrder setPurchaseOrderType(PurchaseOrderType purchaseOrderType) {
    this.purchaseOrderType = purchaseOrderType;
    return this;
  }

  public SalesModel getSalesModel() {
    return salesModel;
  }

  public PurchaseOrder setSalesModel(SalesModel salesModel) {
    this.salesModel = salesModel;
    return this;
  }

  public State<PurchaseOrder> getPurchaseOrderState() {
    return purchaseOrderState;
  }

  public PurchaseOrder setPurchaseOrderState(State<PurchaseOrder> purchaseOrderState) {
    this.purchaseOrderState = purchaseOrderState;
    return this;
  }
}
