package com.luanelioliveira.gobarber.infrastructure.valueobjects.exceptions;

public class BusinessException extends RuntimeException {

  public BusinessException(String message) {
    super(message);
  }
}
