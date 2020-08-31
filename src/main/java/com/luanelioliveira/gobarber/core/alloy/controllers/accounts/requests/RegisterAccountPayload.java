package com.luanelioliveira.gobarber.core.alloy.controllers.accounts.requests;

import com.luanelioliveira.gobarber.core.domain.account.commands.RegisterAccountCommand;
import lombok.Getter;

@Getter
public class RegisterAccountPayload {
  private String name;
  private String email;

  public RegisterAccountCommand toCommand() {
    return RegisterAccountCommand.builder().name(this.name).email(this.email).build();
  }
}
