package com.luanelioliveira.gobarber.ui.rest.customer.responses;

import com.luanelioliveira.gobarber.domain.usecases.responses.CreateCustomerResponse;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@RequiredArgsConstructor
@Value
public class CreateCustomerJsonResponse {

  private final UUID id;
  private final String name;
  private final String email;

  public CreateCustomerJsonResponse(final CreateCustomerResponse response) {
    this.id = response.getId();
    this.name = response.getName();
    this.email = response.getEmail();
  }
}
