package com.luanelioliveira.gobarber.domain.valueobjects.exceptions;

import com.luanelioliveira.gobarber.infrastructure.valueobjects.exceptions.BusinessException;

public class CustomerAlreadyExistsException extends BusinessException {

  public CustomerAlreadyExistsException(String email) {
    super("Customer already exists for email " + email);
  }
}
