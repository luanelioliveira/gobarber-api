package com.luanelioliveira.gobarber.customers.domain.usecase.exception;

public class BusinessException extends RuntimeException {

  public BusinessException(String message) {
    super(message);
  }
}
