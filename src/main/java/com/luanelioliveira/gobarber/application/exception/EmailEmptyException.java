package com.luanelioliveira.gobarber.application.exception;

import com.luanelioliveira.gobarber.domain.usecase.exception.BusinessException;

public class EmailEmptyException extends BusinessException {

  public EmailEmptyException() {
    super("Email cannot be empty");
  }
}
