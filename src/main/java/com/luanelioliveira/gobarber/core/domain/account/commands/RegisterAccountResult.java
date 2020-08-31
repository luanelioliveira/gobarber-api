package com.luanelioliveira.gobarber.core.domain.account.commands;

import com.luanelioliveira.gobarber.core.domain.account.Account;
import java.util.UUID;
import lombok.Value;

@Value
public class RegisterAccountResult {
  private final UUID id;
  private final String name;
  private final String email;

  public RegisterAccountResult(Account account) {
    this.id = account.getId();
    this.name = account.getName();
    this.email = account.getEmail().getValue();
  }
}
