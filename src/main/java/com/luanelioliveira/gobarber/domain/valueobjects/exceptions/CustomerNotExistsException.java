package com.luanelioliveira.gobarber.domain.valueobjects.exceptions;

public class CustomerNotExistsException extends NotFoundException {

  public CustomerNotExistsException() {
    super("Customer not exists");
  }
}
