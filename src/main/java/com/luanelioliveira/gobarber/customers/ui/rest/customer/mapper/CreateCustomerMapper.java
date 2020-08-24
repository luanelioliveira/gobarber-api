package com.luanelioliveira.gobarber.customers.ui.rest.customer.mapper;

import com.luanelioliveira.gobarber.customers.domain.usecase.request.CreateCustomerRequest;
import com.luanelioliveira.gobarber.customers.ui.rest.customer.request.CreateCustomerPayload;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CreateCustomerMapper {

  public static CreateCustomerRequest toRequest(CreateCustomerPayload request) {
    return CreateCustomerRequest.builder()
        .name(request.getName())
        .email(request.getEmail())
        .build();
  }
}
