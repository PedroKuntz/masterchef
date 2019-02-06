package com.ello.masterchef.commons.model;

import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;

public interface State<T> extends Serializable {

  void next(T t);
  void prev(T t);
  void notify(T t);

  @JsonValue
  String getValue();

}