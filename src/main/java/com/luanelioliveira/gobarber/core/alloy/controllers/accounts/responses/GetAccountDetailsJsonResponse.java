package com.luanelioliveira.gobarber.core.alloy.controllers.accounts.responses;

import com.luanelioliveira.gobarber.core.domain.account.queries.GetAccountDetailsResult;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@RequiredArgsConstructor
@Value
public class GetAccountDetailsJsonResponse {

  private final UUID id;
  private final String name;
  private final String email;

  public GetAccountDetailsJsonResponse(final GetAccountDetailsResult response) {
    this.id = response.getId();
    this.name = response.getName();
    this.email = response.getEmail();
  }
}
