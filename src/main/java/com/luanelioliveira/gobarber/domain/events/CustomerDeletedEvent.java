package com.luanelioliveira.gobarber.domain.events;

import com.luanelioliveira.gobarber.domain.models.Customer;
import java.util.UUID;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true, includeFieldNames = true)
public class CustomerDeletedEvent extends Event {

  private UUID id;
  private String name;
  private String email;

  public CustomerDeletedEvent(Customer customer) {
    super();
    this.id = customer.getId();
    this.name = customer.getName();
    this.email = customer.getEmail();
  }
}
