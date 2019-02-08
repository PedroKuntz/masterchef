package com.ello.masterchef.catalog.model;

import com.ello.masterchef.commons.model.Entity;
import com.ello.masterchef.sales.model.Channel;

import java.util.UUID;

public class SalesPrice implements Entity {

  private UUID salesPriceId;
  private Channel channel;
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

  public Channel getChannel() {
    return channel;
  }

  public SalesPrice setChannel(Channel channel) {
    this.channel = channel;
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
