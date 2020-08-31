package com.luanelioliveira.gobarber.domain.common.exceptions;

public class BusinessException extends RuntimeException {

  public BusinessException(String message) {
    super(message);
  }
}
