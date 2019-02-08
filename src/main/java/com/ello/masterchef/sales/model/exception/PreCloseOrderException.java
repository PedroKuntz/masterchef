package com.ello.masterchef.sales.model.exception;

public class PreCloseOrderException extends RuntimeException {

  public PreCloseOrderException(String message) {
    super(message);
  }

  public PreCloseOrderException(String message, Throwable cause) {
    super(message, cause);
  }

}
