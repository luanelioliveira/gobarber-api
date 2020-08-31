package com.luanelioliveira.gobarber.domain.common.exceptions;

public class EntityNotFoundException extends RuntimeException {

  public EntityNotFoundException() {
    super("This entity not exists");
  }
}
