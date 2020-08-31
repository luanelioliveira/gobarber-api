package com.luanelioliveira.gobarber.core.alloy.controllers.accounts.responses;

import com.luanelioliveira.gobarber.core.domain.account.commands.RegisterAccountResult;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@RequiredArgsConstructor
@Value
public class RegisterAccountJsonResponse {

  private final UUID id;
  private final String name;
  private final String email;

  public RegisterAccountJsonResponse(final RegisterAccountResult response) {
    this.id = response.getId();
    this.name = response.getName();
    this.email = response.getEmail();
  }
}
