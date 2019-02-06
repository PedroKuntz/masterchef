package com.ello.masterchef.commons.model;

public interface Rule<T, R> {

  R apply(T t);

}
