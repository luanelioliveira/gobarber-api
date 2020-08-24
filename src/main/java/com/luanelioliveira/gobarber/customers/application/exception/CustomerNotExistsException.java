package com.luanelioliveira.gobarber.customers.application.exception;

import com.luanelioliveira.gobarber.customers.domain.usecase.exception.NotFoundException;

public class CustomerNotExistsException extends NotFoundException {

  public CustomerNotExistsException() {
    super("Customer not exists");
  }
}
