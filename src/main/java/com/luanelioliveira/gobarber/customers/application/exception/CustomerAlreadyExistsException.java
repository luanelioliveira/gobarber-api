package com.luanelioliveira.gobarber.customers.application.exception;

import com.luanelioliveira.gobarber.customers.domain.usecase.exception.BusinessException;

public class CustomerAlreadyExistsException extends BusinessException {

  public CustomerAlreadyExistsException() {
    super("Customer already exists");
  }
}
