package com.luanelioliveira.gobarber.ui.rest.customer.requests;

import com.luanelioliveira.gobarber.domain.usecases.requests.CreateCustomerRequest;
import lombok.Getter;

@Getter
public class CreateCustomerPayload {
  private String name;
  private String email;

  public CreateCustomerRequest toRequest() {
    return CreateCustomerRequest.builder().name(this.getName()).email(this.getEmail()).build();
  }
}
