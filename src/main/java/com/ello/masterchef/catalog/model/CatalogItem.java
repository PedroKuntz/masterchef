package com.ello.masterchef.catalog.model;

import com.ello.masterchef.integration.Entity;

import java.util.List;
import java.util.UUID;

public class CatalogItem implements Entity {

  private UUID catalogItemId;
  private Long itemId;
  private String nameItem;
  private String description;
  private String barCode;
  private CatalogItemType catalogItemType;
  private List<SalesPrice> salesPrice;
  private int amount;
  private double kg;
  private List<CatalogItem> parentCatalogItems;

  public CatalogItem() {}

  public UUID getCatalogItemId() {
    return catalogItemId;
  }

  public CatalogItem setCatalogItemId(UUID catalogItemId) {
    this.catalogItemId = catalogItemId;
    return this;
  }

  public Long getItemId() {
    return itemId;
  }

  public CatalogItem setItemId(Long itemId) {
    this.itemId = itemId;
    return this;
  }

  public String getNameItem() {
    return nameItem;
  }

  public CatalogItem setNameItem(String nameItem) {
    this.nameItem = nameItem;
    return this;
  }

  public String getDescription() {
    return description;
  }

  public CatalogItem setDescription(String description) {
    this.description = description;
    return this;
  }

  public String getBarCode() {
    return barCode;
  }

  public CatalogItem setBarCode(String barCode) {
    this.barCode = barCode;
    return this;
  }

  public CatalogItemType getCatalogItemType() {
    return catalogItemType;
  }

  public CatalogItem setCatalogItemType(CatalogItemType catalogItemType) {
    this.catalogItemType = catalogItemType;
    return this;
  }

  public List<SalesPrice> getSalesPrice() {
    return salesPrice;
  }

  public CatalogItem setSalesPrice(List<SalesPrice> salesPrice) {
    this.salesPrice = salesPrice;
    return this;
  }

  public int getAmount() {
    return amount;
  }

  public CatalogItem setAmount(int amount) {
    this.amount = amount;
    return this;
  }

  public double getKg() {
    return kg;
  }

  public CatalogItem setKg(double kg) {
    this.kg = kg;
    return this;
  }

  public List<CatalogItem> getParentCatalogItems() {
    return parentCatalogItems;
  }

  public CatalogItem setParentCatalogItems(List<CatalogItem> parentCatalogItems) {
    this.parentCatalogItems = parentCatalogItems;
    return this;
  }
}