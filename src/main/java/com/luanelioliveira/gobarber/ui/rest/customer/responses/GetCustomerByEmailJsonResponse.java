package com.luanelioliveira.gobarber.ui.rest.customer.responses;

import com.luanelioliveira.gobarber.domain.usecases.responses.GetCustomerByEmailResponse;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@RequiredArgsConstructor
@Value
public class GetCustomerByEmailJsonResponse {

  private final UUID id;
  private final String name;
  private final String email;

  public GetCustomerByEmailJsonResponse(final GetCustomerByEmailResponse response) {
    this.id = response.getId();
    this.name = response.getName();
    this.email = response.getEmail();
  }
}
