package com.ello.masterchef.sales.model;

public enum PurchaseOrderItemType {

  UNIT("UNIT"), SUB_ITEM("SUB_ITEM"), ADDITIONAL("ADDITIONAL"), REFIL("REFIL"), COMBO("COMBO"), FREE("FREE");

  private String value;

  PurchaseOrderItemType(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
