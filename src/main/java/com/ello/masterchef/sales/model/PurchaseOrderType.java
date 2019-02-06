package com.ello.masterchef.sales.model;

public enum PurchaseOrderType {

  BALCONY("BALCAO"),
  TABLE("MESA"),
  DELIVERY("ENTREGA"),
  CARD("COMANDA");

  private String value;

  PurchaseOrderType(String value) {
    this.value = value;
  }

  public String getValue() {
    return this.value;
  }

}
