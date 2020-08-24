package com.luanelioliveira.gobarber.ui.rest.customer.response;

import com.luanelioliveira.gobarber.domain.usecase.response.GetCustomerByIdResponse;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@RequiredArgsConstructor
@Value
public class GetCustomerByIdJsonResponse {

  private final UUID id;
  private final String name;
  private final String email;

  public GetCustomerByIdJsonResponse(final GetCustomerByIdResponse response) {
    this(response.getId(), response.getName(), response.getEmail());
  }
}
