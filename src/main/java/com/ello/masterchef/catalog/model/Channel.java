package com.ello.masterchef.catalog.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Channel {

  SELF_SERVICE("SELF_SERVICE"), FREE("FREE"), UNIT("UNIT"), REFIL("REFIL");

  private String value;

  Channel(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return this.value;
  }

}
