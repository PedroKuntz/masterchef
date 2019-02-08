package com.ello.masterchef.sales.model;

import com.ello.masterchef.sales.service.ChannelStrategy;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Channel implements ChannelStrategy {

  TABLE("TABLE") {
    @Override
    public void preClose(PurchaseOrder purchaseOrder) {

    }

    @Override
    public void close(PurchaseOrder purchaseOrder) {

    }
  }, BALCONY("BALCONY") {

    @Override
    public void preClose(PurchaseOrder purchaseOrder) {

    }

    @Override
    public void close(PurchaseOrder purchaseOrder) {

    }
  }, CARD("CARD") {

    @Override
    public void preClose(PurchaseOrder purchaseOrder) {

    }

    @Override
    public void close(PurchaseOrder purchaseOrder) {

    }
  }, DELIVERY("DELIVERY") {

    @Override
    public void preClose(PurchaseOrder purchaseOrder) {

    }

    @Override
    public void close(PurchaseOrder purchaseOrder) {

    }
  }, ORDER("ORDER") {

    @Override
    public void preClose(PurchaseOrder purchaseOrder) {

    }

    @Override
    public void close(PurchaseOrder purchaseOrder) {

    }
  };

  private String value;

  Channel(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return this.value;
  }

}
