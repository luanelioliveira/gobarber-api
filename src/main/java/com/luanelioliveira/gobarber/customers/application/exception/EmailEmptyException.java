package com.luanelioliveira.gobarber.customers.application.exception;

import com.luanelioliveira.gobarber.customers.domain.usecase.exception.BusinessException;

public class EmailEmptyException extends BusinessException {

  public EmailEmptyException() {
    super("Email cannot be empty");
  }
}
