package com.luanelioliveira.gobarber.domain.valueobjects.exceptions;

public class CustomerAlreadyExistsException extends BusinessException {

  public CustomerAlreadyExistsException() {
    super("Customer already exists");
  }
}
