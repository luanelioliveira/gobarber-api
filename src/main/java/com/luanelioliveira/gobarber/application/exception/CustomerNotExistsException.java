package com.luanelioliveira.gobarber.application.exception;

import com.luanelioliveira.gobarber.domain.usecase.exception.NotFoundException;

public class CustomerNotExistsException extends NotFoundException {

  public CustomerNotExistsException() {
    super("Customer not exists");
  }
}
