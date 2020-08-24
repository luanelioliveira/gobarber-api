package com.luanelioliveira.gobarber.application.exception;

import com.luanelioliveira.gobarber.domain.usecase.exception.BusinessException;

public class NameEmptyException extends BusinessException {

  public NameEmptyException() {
    super("Name cannot be empty");
  }
}
