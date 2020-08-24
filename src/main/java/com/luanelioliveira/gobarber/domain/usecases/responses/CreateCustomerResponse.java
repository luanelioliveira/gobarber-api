package com.luanelioliveira.gobarber.domain.usecases.responses;

import com.luanelioliveira.gobarber.domain.models.Customer;
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
