package com.luanelioliveira.gobarber.domain.usecase.exception;

public class NotFoundException extends RuntimeException {

  public NotFoundException(String message) {
    super(message);
  }
}
