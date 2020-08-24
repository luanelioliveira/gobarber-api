package com.luanelioliveira.gobarber.application.exceptions;

import com.luanelioliveira.gobarber.domain.usecases.exceptions.BusinessException;

public class CustomerAlreadyExistsException extends BusinessException {

  public CustomerAlreadyExistsException(String email) {
    super("Customer already exists for email " + email);
  }
}
