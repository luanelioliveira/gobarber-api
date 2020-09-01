package com.luanelioliveira.gobarber.alloy.controllers.accounts.responses;

import com.luanelioliveira.gobarber.domain.account.queries.GetAccountDetailsResult;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@RequiredArgsConstructor
@Value
public class GetAccountDetailsJsonResponse {

  private final UUID id;
  private final String name;
  private final String email;

  public GetAccountDetailsJsonResponse(final GetAccountDetailsResult result) {
    this.id = result.getId();
    this.name = result.getName();
    this.email = result.getEmail();
  }
}
