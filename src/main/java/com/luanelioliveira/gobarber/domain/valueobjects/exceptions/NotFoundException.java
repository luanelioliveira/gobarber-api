package com.luanelioliveira.gobarber.domain.valueobjects.exceptions;

public class NotFoundException extends RuntimeException {

  public NotFoundException(String message) {
    super(message);
  }
}
