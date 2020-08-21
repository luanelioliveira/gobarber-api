package com.luanelioliveira.gobarber.infrastructure.valueobjects.exceptions;

public class NotFoundException extends RuntimeException {

  public NotFoundException(String message) {
    super(message);
  }
}
