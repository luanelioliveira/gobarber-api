package com.luanelioliveira.gobarber.domain.valueobjects.exceptions;

public class NameEmptyException extends BusinessException {

  public NameEmptyException() {
    super("Name cannot be empty");
  }
}
