package com.luanelioliveira.gobarber.customers.domain.event;

import com.luanelioliveira.gobarber.customers.domain.entity.Customer;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true, includeFieldNames = true)
public class CustomerCreatedEvent extends Event {

  public CustomerCreatedEvent(Customer customer) {
    super(customer);
  }
}
