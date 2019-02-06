package com.ello.masterchef.sales.model;

import com.ello.masterchef.catalog.model.Channel;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.UUID;

public class PurchaseOrderRequest implements Serializable {

  @JsonProperty("employeeId")
  private UUID employeeId;
  @JsonProperty("purchaseOrderType")
  private PurchaseOrderType purchaseOrderType;
  @JsonProperty("channel")
  private Channel channel;

  public PurchaseOrderRequest() {}

  public UUID getEmployeeId() {
    return employeeId;
  }

  public PurchaseOrderRequest setEmployeeId(UUID employeeId) {
    this.employeeId = employeeId;
    return this;
  }

  public PurchaseOrderType getPurchaseOrderType() {
    return purchaseOrderType;
  }

  public PurchaseOrderRequest setPurchaseOrderType(PurchaseOrderType purchaseOrderType) {
    this.purchaseOrderType = purchaseOrderType;
    return this;
  }

  public Channel getChannel() {
    return channel;
  }

  public PurchaseOrderRequest setChannel(Channel channel) {
    this.channel = channel;
    return this;
  }
}
