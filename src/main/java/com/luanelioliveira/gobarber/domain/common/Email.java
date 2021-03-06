package com.luanelioliveira.gobarber.domain.common;

import java.util.Objects;
import lombok.Value;

@Value
public class Email {
  private String value;

  public Email(String value) {
    if (Objects.isNull(value) || value.trim().isEmpty())
      throw new IllegalArgumentException("Email is required");

    this.value = value;
  }

  public String toString() {
    return value;
  }
}
