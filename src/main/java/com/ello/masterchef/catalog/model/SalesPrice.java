package com.ello.masterchef.catalog.model;

import com.ello.masterchef.integration.Entity;

import java.util.UUID;

public class SalesPrice implements Entity {

  private UUID salesPriceId;
  private SalesModel salesModel;
  private Double price;
  private SalesRules salesRules;

  public SalesPrice() {}

  public UUID getSalesPriceId() {
    return salesPriceId;
  }

  public SalesPrice setSalesPriceId(UUID salesPriceId) {
    this.salesPriceId = salesPriceId;
    return this;
  }

  public SalesModel getSalesModel() {
    return salesModel;
  }

  public SalesPrice setSalesModel(SalesModel salesModel) {
    this.salesModel = salesModel;
    return this;
  }

  public Double getPrice() {
    return price;
  }

  public SalesPrice setPrice(Double price) {
    this.price = price;
    return this;
  }

  public SalesRules getSalesRules() {
    return salesRules;
  }

  public SalesPrice setSalesRules(SalesRules salesRules) {
    this.salesRules = salesRules;
    return this;
  }
}
