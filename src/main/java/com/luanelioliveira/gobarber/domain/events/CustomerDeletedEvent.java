package com.luanelioliveira.gobarber.domain.events;

import com.luanelioliveira.gobarber.domain.models.Customer;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true, includeFieldNames = true)
public class CustomerDeletedEvent extends Event {

  public CustomerDeletedEvent(Customer customer) {
    super(customer);
  }
}
