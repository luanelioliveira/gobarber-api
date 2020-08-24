package com.luanelioliveira.gobarber.application.events;

import com.luanelioliveira.gobarber.domain.entities.Customer;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Getter;

@Getter
public class CustomerCreatedEvent {

  private UUID id;
  private Customer customer;
  private LocalDateTime createdAt;

  public CustomerCreatedEvent(Customer customer) {
    this.customer = customer;
    this.id = UUID.randomUUID();
    this.createdAt = LocalDateTime.now();
  }
}
