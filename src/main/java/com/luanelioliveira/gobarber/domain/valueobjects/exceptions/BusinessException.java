package com.luanelioliveira.gobarber.domain.valueobjects.exceptions;

public class BusinessException extends RuntimeException {

  public BusinessException(String message) {
    super(message);
  }
}
