package com.luanelioliveira.gobarber.domain.events;

import com.luanelioliveira.gobarber.domain.models.Customer;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true, includeFieldNames = true)
public class CustomerCreatedEvent extends Event {

  public CustomerCreatedEvent(Customer customer) {
    super(customer);
  }
}
