package com.luanelioliveira.gobarber.alloy.controllers.errors;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(staticName = "of")
public class InvalidParam {
  private String name;
  private String reason;
}
