package com.ello.masterchef.sales.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Channel {

  TABLE("TABLE"), BALCONY("BALCONY"), CARD("CARD"), DELIVERY("DELIVERY"), ORDER("ORDER");

  private String value;

  Channel(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return this.value;
  }

}
