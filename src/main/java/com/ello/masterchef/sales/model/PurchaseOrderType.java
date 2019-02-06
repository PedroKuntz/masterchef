package com.ello.masterchef.sales.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PurchaseOrderType {

  BALCONY("BALCAO"),
  TABLE("MESA"),
  DELIVERY("ENTREGA"),
  CARD("COMANDA");

  private String value;

  PurchaseOrderType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return this.value;
  }

}
