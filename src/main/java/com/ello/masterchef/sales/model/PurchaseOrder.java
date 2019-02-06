package com.ello.masterchef.sales.model;

import com.ello.masterchef.catalog.model.Channel;
import com.ello.masterchef.integration.Entity;
import com.ello.masterchef.integration.State;

import java.util.List;
import java.util.UUID;

public class PurchaseOrder implements Entity {

  private UUID purchaseId;
  private UUID employeeId;
  private List<PurchaseOrderItem> purchaseOrderItems;
  private PurchaseOrderType purchaseOrderType;
  private Channel channel;
  private State<PurchaseOrder> purchaseOrderState;
  private Double totalPrice;

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

  public Channel getChannel() {
    return channel;
  }

  public PurchaseOrder setChannel(Channel channel) {
    this.channel = channel;
    return this;
  }

  public State<PurchaseOrder> getPurchaseOrderState() {
    return purchaseOrderState;
  }

  public PurchaseOrder setPurchaseOrderState(State<PurchaseOrder> purchaseOrderState) {
    this.purchaseOrderState = purchaseOrderState;
    return this;
  }

  public UUID getEmployeeId() {
    return employeeId;
  }

  public PurchaseOrder setEmployeeId(UUID employeeId) {
    this.employeeId = employeeId;
    return this;
  }

  public Double getTotalPrice() {
    return totalPrice;
  }

  public PurchaseOrder setTotalPrice(Double totalPrice) {
    this.totalPrice = totalPrice;
    return this;
  }
}
