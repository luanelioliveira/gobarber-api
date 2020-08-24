package com.luanelioliveira.gobarber.customers.application.event.publish;

import com.luanelioliveira.gobarber.core.infrastructure.event.EventPublisher;
import com.luanelioliveira.gobarber.customers.domain.entity.Customer;
import com.luanelioliveira.gobarber.customers.domain.event.CustomerCreatedEvent;
import javax.inject.Named;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Named
@Slf4j
@RequiredArgsConstructor
public class CustomerCreatedEventPublisher {

  private final EventPublisher publisher;

  public void publish(Customer customer) {
    publisher.publish(new CustomerCreatedEvent(customer));
  }
}
