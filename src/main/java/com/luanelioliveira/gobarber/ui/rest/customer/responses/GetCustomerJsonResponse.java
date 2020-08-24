package com.luanelioliveira.gobarber.ui.rest.customer.responses;

import com.luanelioliveira.gobarber.domain.usecases.responses.GetCustomerResponse;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@RequiredArgsConstructor
@Value
public class GetCustomerJsonResponse {

  private final UUID id;
  private final String name;
  private final String email;

  public GetCustomerJsonResponse(final GetCustomerResponse response) {
    this.id = response.getId();
    this.name = response.getName();
    this.email = response.getEmail();
  }
}
