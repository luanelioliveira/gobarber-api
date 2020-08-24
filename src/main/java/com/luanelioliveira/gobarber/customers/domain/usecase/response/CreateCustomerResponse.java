package com.luanelioliveira.gobarber.customers.domain.usecase.response;

import com.luanelioliveira.gobarber.customers.domain.entity.Customer;
import java.util.UUID;
import lombok.Value;

@Value
public class CreateCustomerResponse {
  private final UUID id;
  private final String name;
  private final String email;

  public CreateCustomerResponse(Customer customer) {
    this.id = customer.getId();
    this.name = customer.getName();
    this.email = customer.getEmail();
  }
}
