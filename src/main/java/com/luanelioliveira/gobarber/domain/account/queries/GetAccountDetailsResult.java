package com.luanelioliveira.gobarber.domain.account.queries;

import com.luanelioliveira.gobarber.domain.account.Account;
import java.util.UUID;
import lombok.Value;

@Value
public class GetAccountDetailsResult {
  private final UUID id;
  private final String name;
  private final String email;

  public GetAccountDetailsResult(Account account) {
    this.id = account.getId();
    this.name = account.getName();
    this.email = account.getEmail().getValue();
  }
}
