package com.luanelioliveira.gobarber.customers.domain.entity;

import java.util.UUID;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Customer {

  private UUID id;
  private String name;
  private String email;

  private Customer() {}

  public static Customer newCustomer(String name, String email) {
    Customer customer = new Customer();
    customer.id = UUID.randomUUID();
    customer.name = name;
    customer.email = email;
    return customer;
  }
}
