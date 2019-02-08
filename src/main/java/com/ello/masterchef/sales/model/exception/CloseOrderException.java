package com.ello.masterchef.sales.model.exception;

public class CloseOrderException extends RuntimeException{

  public CloseOrderException(String message) {
    super(message);
  }

  public CloseOrderException(String message, Throwable cause) {
    super(message, cause);
  }

}
