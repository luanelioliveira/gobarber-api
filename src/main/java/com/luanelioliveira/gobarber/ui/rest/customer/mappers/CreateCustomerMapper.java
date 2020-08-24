package com.luanelioliveira.gobarber.ui.rest.customer.mappers;

import com.luanelioliveira.gobarber.domain.usecases.requests.CreateCustomerRequest;
import com.luanelioliveira.gobarber.ui.rest.customer.requests.CreateCustomerPayload;
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
