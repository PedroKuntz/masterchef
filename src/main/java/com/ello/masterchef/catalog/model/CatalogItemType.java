package com.ello.masterchef.catalog.model;

public enum CatalogItemType {

  UNIT("UNIT"),
  SUB_ITEM("SUB_ITEM"),
  ADDITIONAL("ADDITIONAL"),
  REFIL("REFIL"),
  COMBO("COMBO"),
  FREE("COMBO"),
  UNIT_PARENT("UNIT_PARENT");

  private String value;

  CatalogItemType(String value) {
    this.value = value;
  }

  public String getValue() {
    return this.value;
  }

}
