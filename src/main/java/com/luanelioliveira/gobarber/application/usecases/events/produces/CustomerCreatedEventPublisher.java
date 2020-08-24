package com.luanelioliveira.gobarber.application.usecases.events.produces;

import com.luanelioliveira.gobarber.domain.events.CustomerCreatedEvent;
import com.luanelioliveira.gobarber.domain.models.Customer;
import com.luanelioliveira.gobarber.infrastructure.events.EventPublisher;
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
