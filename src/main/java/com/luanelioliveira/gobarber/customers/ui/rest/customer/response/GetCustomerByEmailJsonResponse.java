package com.luanelioliveira.gobarber.customers.ui.rest.customer.response;

import com.luanelioliveira.gobarber.customers.domain.usecase.response.GetCustomerByEmailResponse;
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
    this(response.getId(), response.getName(), response.getEmail());
  }
}
