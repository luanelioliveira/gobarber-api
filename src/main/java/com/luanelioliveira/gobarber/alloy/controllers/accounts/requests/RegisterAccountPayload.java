package com.luanelioliveira.gobarber.alloy.controllers.accounts.requests;

import com.luanelioliveira.gobarber.domain.account.commands.RegisterAccountCommand;
import lombok.Getter;

@Getter
public class RegisterAccountPayload {
  private String name;
  private String email;

  public RegisterAccountCommand toCommand() {
    return RegisterAccountCommand.of(this.name, this.email);
  }
}
