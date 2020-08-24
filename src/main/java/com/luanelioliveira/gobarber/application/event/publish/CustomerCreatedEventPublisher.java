package com.luanelioliveira.gobarber.application.event.publish;

import com.luanelioliveira.gobarber.domain.entity.Customer;
import com.luanelioliveira.gobarber.domain.event.CustomerCreatedEvent;
import com.luanelioliveira.gobarber.infrastructure.event.EventPublisher;
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
