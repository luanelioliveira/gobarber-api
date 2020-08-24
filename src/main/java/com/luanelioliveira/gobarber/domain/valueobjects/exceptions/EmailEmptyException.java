package com.luanelioliveira.gobarber.domain.valueobjects.exceptions;

public class EmailEmptyException extends BusinessException {

  public EmailEmptyException() {
    super("Email cannot be empty");
  }
}
