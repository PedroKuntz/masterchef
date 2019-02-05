package com.ello.masterchef.integration;

public interface Rule<T, R> {

  R apply(T t);

}
