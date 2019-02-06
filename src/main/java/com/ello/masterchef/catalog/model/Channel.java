package com.ello.masterchef.catalog.model;

public enum Channel {

  SELF_SERVICE("SELF_SERVICE"), FREE("FREE"), UNIT("UNIT"), REFIL("REFIL");

  private String value;

  Channel(String value) {
    this.value = value;
  }

  public String getValue() {
    return this.value;
  }

}
