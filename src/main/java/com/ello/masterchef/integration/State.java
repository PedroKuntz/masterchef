package com.ello.masterchef.integration;

public interface State<T> {

  void next(T t);
  void prev(T t);
  void notify(T t);

  String getValue();

}