package com.luanelioliveira.gobarber.application.exception;

import com.luanelioliveira.gobarber.domain.usecase.exception.BusinessException;

public class CustomerAlreadyExistsException extends BusinessException {

  public CustomerAlreadyExistsException() {
    super("Customer already exists");
  }
}
