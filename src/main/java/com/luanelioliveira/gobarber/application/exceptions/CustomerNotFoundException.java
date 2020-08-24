package com.luanelioliveira.gobarber.application.exceptions;

import com.luanelioliveira.gobarber.infrastructure.valueobjects.exceptions.NotFoundException;

public class CustomerNotFoundException extends NotFoundException {

  public CustomerNotFoundException(String message) {
    super(message);
  }
}
