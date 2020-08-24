package com.luanelioliveira.gobarber.customers.application.exception;

import com.luanelioliveira.gobarber.customers.domain.usecase.exception.BusinessException;

public class NameEmptyException extends BusinessException {

  public NameEmptyException() {
    super("Name cannot be empty");
  }
}
