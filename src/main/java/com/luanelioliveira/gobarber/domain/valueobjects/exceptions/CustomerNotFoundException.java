package com.luanelioliveira.gobarber.domain.valueobjects.exceptions;

import com.luanelioliveira.gobarber.infrastructure.valueobjects.exceptions.NotFoundException;

public class CustomerNotFoundException extends NotFoundException {

  public CustomerNotFoundException(String message) {
    super(message);
  }
}
