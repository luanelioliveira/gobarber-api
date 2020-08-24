package com.luanelioliveira.gobarber.ui.rest.customer.adapters;

import com.luanelioliveira.gobarber.domain.usecases.requests.CreateCustomerRequest;
import com.luanelioliveira.gobarber.ui.rest.customer.requests.CreateCustomerPayload;

public class CreateCustomerAdapter {

  public static CreateCustomerRequest toRequest(CreateCustomerPayload request) {
    return CreateCustomerRequest.builder()
        .name(request.getName())
        .email(request.getEmail())
        .build();
  }
}
